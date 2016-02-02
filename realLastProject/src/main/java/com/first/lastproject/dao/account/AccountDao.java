package com.first.lastproject.dao.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.first.lastproject.dto.AccountDto;


public class AccountDao implements InterfaceAccountDao {

	DataSource dataSource;
	
	private static AccountDao instance;
	
	public static AccountDao getInstance() {
		if (instance == null) {
			instance = new AccountDao();
		}
		return instance;
	}
	
	private AccountDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<AccountDto> getDayAccount() {//일간 정산표
		
		ArrayList <AccountDto> dayList = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT * FROM day_calculate_view "
					+ "WHERE order_time >= to_char(trunc(sysdate,'dd'),'yyyy/mm/dd') "
					+ "AND order_time < to_char(trunc(sysdate,'dd')+1,'yyyy/mm/dd')"
					+ " ORDER BY order_id ASC";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println(rs);
			
			while(rs.next()) {
				if(dayList == null) {
					dayList = new ArrayList<AccountDto>();
				}
				AccountDto dto = new AccountDto();
			dto.setOrder_id(rs.getString("order_id"));
			dto.setSeat_num(rs.getInt("seat_num"));
			dto.setOrder_time(rs.getTimestamp("order_time"));
			dto.setUsed_time(rs.getString("used_time"));
			dto.setPrice(rs.getInt("price"));
			dayList.add(dto);
			System.out.println(dayList);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		return dayList;
	}

	@Override
	public AccountDto getDayTotalAccount() {//일간 총 금액 및 시간표
		
		AccountDto dto = new AccountDto();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT SUM(price) total_price FROM day_calculate_view WHERE order_time >= to_char(trunc(sysdate,'dd'),'yyyy/mm/dd') AND order_time < to_char(trunc(sysdate,'dd')+1,'yyyy/mm/dd')";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto.setTotal_price(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		return dto;
	}

	@Override
	public List<AccountDto> getMonthAccountDays(int monlist) {//월간 일자
		ArrayList <AccountDto> monthList = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT * FROM "
					+ "(SELECT(TO_DATE (?, 'YYYY-MM-DD') + LEVEL - 1) "
					+ "FROM DUAL "
					+ "CONNECT BY (TO_DATE (?, 'YYYY-MM-DD') + LEVEL - 1) < "
					+ "TO_DATE (?, 'YYYY-MM-DD'))";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Calendar.getInstance().get(Calendar.YEAR)+"-"+monlist+"-01");
			pstmt.setString(2, Calendar.getInstance().get(Calendar.YEAR)+"-"+monlist+"-01");
			pstmt.setString(3, Calendar.getInstance().get(Calendar.YEAR)+"-"+(monlist+1)+"-01");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(monthList == null) {
					monthList = new ArrayList<AccountDto>();
				}
				AccountDto dto1 = new AccountDto();
			dto1.setDate(rs.getTimestamp(1));
			System.out.println(dto1);
			monthList.add(dto1);
			}
			System.out.println(monthList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		return monthList;
	}

	public List<AccountDto> getMonthAccountPrice(int monlist) {//월간 일자별 총 수익 금액
		ArrayList <AccountDto> monthprice = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Calendar today = Calendar.getInstance();
		today.set(today.get(Calendar.YEAR), monlist-1, 1);
		int i = 1;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT SUM(price) price "
					+ "FROM day_calculate_view WHERE order_time "
					+ "BETWEEN to_date(?, 'yyyy-mm-dd hh24:mi:ss') "
					+ "AND to_date(?, 'yyyy-mm-dd hh24:mi:ss')";
			for(i = 1; i <= today.getActualMaximum(Calendar.DATE); i++) {
			pstmt = con.prepareStatement(sql);
			System.out.println("start=" + Calendar.getInstance().get(Calendar.YEAR)+"-"+monlist+"-"+(i)+" 00:00:00");
			System.out.println("end=" + Calendar.getInstance().get(Calendar.YEAR)+"-"+monlist+"-"+(i)+" 23:59:59");
			pstmt.setString(1, Calendar.getInstance().get(Calendar.YEAR)+"-"+monlist+"-"+i+" 00:00:00");
			pstmt.setString(2, Calendar.getInstance().get(Calendar.YEAR)+"-"+monlist+"-"+i+" 23:59:59");
	
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(monthprice == null) {
					monthprice = new ArrayList<AccountDto>();
				}
				AccountDto dto2 = new AccountDto();
			dto2.setPrice(rs.getInt("price"));
			monthprice.add(dto2);
			continue;
			}
			pstmt.close();
		}	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		return monthprice;
	}
	
	public AccountDto getMonthTotalAccount(int monlist) {//월간 총 수익 금액
		
		AccountDto monPriceDto = new AccountDto();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Calendar today = Calendar.getInstance();
		System.out.println(monlist);
		System.out.println(today.get(Calendar.YEAR)+"-"+monlist+"-01 00:00:00");
		System.out.println(today.get(Calendar.YEAR)+"-"+(monlist+1)+"-01 00:00:00");
		try {
			con = dataSource.getConnection();
			String sql = "SELECT SUM(price) FROM day_calculate_view "
					+ "WHERE order_time between to_date(?, 'yyyy-mm-dd hh24:mi:ss') "
					+ "AND to_date(?, 'yyyy-mm-dd hh24:mi:ss')";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, today.get(Calendar.YEAR)+"-"+monlist+"-01 00:00:00");
			pstmt.setString(2, today.get(Calendar.YEAR)+"-"+(monlist+1)+"-01 00:00:00");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				monPriceDto.setTotal_price(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		return monPriceDto;
	}
	
	@Override
	public List<AccountDto> getSelectAccountDays(String startday, String endday) {//기간 일자
		ArrayList <AccountDto> selectList = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT * FROM "
					+ "(SELECT(TO_DATE (?, 'YYYY-MM-DD') + LEVEL - 1) "
					+ "FROM DUAL "
					+ "CONNECT BY (TO_DATE (?, 'YYYY-MM-DD') + LEVEL - 1) <= "
					+ "TO_DATE (?, 'YYYY-MM-DD'))";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, startday);
			pstmt.setString(2, startday);
			pstmt.setString(3, endday);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(selectList == null) {
					selectList = new ArrayList<AccountDto>();
				}
				AccountDto dto = new AccountDto();
			dto.setDate(rs.getTimestamp(1));
			System.out.println(dto);
			selectList.add(dto);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		return selectList;
	}
	
	public List<AccountDto> getSelectAccountPrice(String startday, String endday) {//기간 일자별 총 수익 금액
		ArrayList <AccountDto> selectPrice = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Calendar today = Calendar.getInstance();
		String[] startL = startday.split("-");
		String[] endL = endday.split("-");
		int start = Integer.parseInt(startL[0]+startL[1]+startL[2]);
		long diffDays = 0;
		
		   try {
		        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		        Date beginDate = formatter.parse(startday);
		        Date endDate = formatter.parse(endday);
		         
		        // 시간차이를 시간,분,초를 곱한 값으로 나누면 하루 단위가 나옴
		        long diff = endDate.getTime() - beginDate.getTime();
		        diffDays = diff / (24 * 60 * 60 * 1000);
		 
		        System.out.println("날짜차이=" + diffDays);
		         
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		
		try {
			con = dataSource.getConnection();
			String sql = "SELECT SUM(price) price "
					+ "FROM day_calculate_view WHERE order_time "
					+ "BETWEEN to_date(?, 'yyyymmdd hh24:mi:ss') "
					+ "AND to_date(?, 'yyyymmdd hh24:mi:ss')";
			for(int i = 1; i <= diffDays; i++) {
			pstmt = con.prepareStatement(sql);
			System.out.println("start=" + (start++) + " 00:00:00");
			System.out.println("end=" + (start++) +" 23:59:59");
			
			pstmt.setString(1, (start) + " 00:00:00");
			pstmt.setString(2, (start) + " 23:59:59");
	
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(selectPrice == null) {
					selectPrice = new ArrayList<AccountDto>();
				}
				AccountDto dto = new AccountDto();
			dto.setPrice(rs.getInt("price"));
			selectPrice.add(dto);
			continue;
			}
			pstmt.close();
		}	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		return selectPrice;
	}
	@Override
	public AccountDto getSelectTotalAccount(String startday, String endday) {//기간 총 수익 금액
		AccountDto selPriceDto = new AccountDto();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println(startday);
		System.out.println(endday);
		try {
			con = dataSource.getConnection();
			String sql = "SELECT SUM(price) as total_price FROM day_calculate_view "
					+ "WHERE order_time between to_date(?, 'yyyy-mm-dd') "
					+ "AND to_date(?, 'yyyy-mm-dd')";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, startday);
			pstmt.setString(2, endday);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				selPriceDto.setTotal_price(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		
		return selPriceDto;
	}
}
