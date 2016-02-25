package com.first.lastproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.first.lastproject.dto.AccountDto;

@Repository
public class AccountDaoImpl implements AccountDao {

	DataSource dataSource;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<AccountDto> getDayAccount() {//일간 정산표
		
		ArrayList <AccountDto> dayList = new ArrayList<AccountDto>();
		AccountDto dto = new AccountDto();
		AccountDao dao = this.sqlSession.getMapper(AccountDao.class);
		dayList = dao.getDayAccount();
			/*String sql = "SELECT * FROM day_calculate_view "
					+ "WHERE order_time >= to_char(trunc(sysdate,'dd'),'yyyy/mm/dd') "
					+ "AND order_time < to_char(trunc(sysdate,'dd')+1,'yyyy/mm/dd')"
					+ " ORDER BY order_id ASC";*/
		return dayList;
	}
	
	public int getDayCount(Map<String, String> map2) {
		System.out.println("count-Day");
		AccountDao dao = this.sqlSession.getMapper(AccountDao.class);
		int cnt = dao.getDayCount(map2);
		
		return cnt;
	}
	
public List<AccountDto> getDayAccounts(Map<String, String> map2) {//일간 정산표-월간/기간 정산에서 일자 누를 시에
		
		List <AccountDto> daySelList = new ArrayList<AccountDto>();
		AccountDto dto = new AccountDto();
		AccountDao dao = this.sqlSession.getMapper(AccountDao.class);
		int cnt = getDayCount(map2);
		if(cnt > 0) {
			daySelList = dao.getDayAccounts(map2);
			
		}
		
		/*try {
			con = dataSource.getConnection();
			String sql = "SELECT * FROM day_calculate_view "
					+ "WHERE order_time BETWEEN to_date(?, 'yyyy-mm-dd hh24:mi:ss')"
					+ "AND to_date(?, 'yyyy-mm-dd hh24:mi:ss')"
					+ " ORDER BY order_id ASC";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dayDate + " 00:00:00");
			pstmt.setString(2, dayDate + " 23:59:59");
			rs = pstmt.executeQuery();
			
			
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
		
		}*/
		return daySelList;
	}

	public int getDayPrice() {
		System.out.println("getDayPrice");
		AccountDao dao = this.sqlSession.getMapper(AccountDao.class);
		int price = dao.getDayPrice();
		
	
		return price;
	}

	@Override
	public AccountDto getDayTotalAccount() {//일간 총 금액 및 시간표
		AccountDto dto = new AccountDto();
		int price = getDayPrice();
		System.out.println("일간 : " + price);
		dto.setTotal_price(price);
			/*String sql = "SELECT SUM(price) total_price FROM day_calculate_view "
					+ "WHERE order_time >= to_char(trunc(sysdate,'dd'),'yyyy/mm/dd') "
					+ "AND order_time < to_char(trunc(sysdate,'dd')+1,'yyyy/mm/dd')";*/
		return dto;
	}
	
	public int getDaySelectPrice(Map<String, String> map) {
		System.out.println("getDayPrice");
		AccountDao dao = this.sqlSession.getMapper(AccountDao.class);
		int price = dao.getDaySelectPrice(map);
		System.out.println("일간2 : " + price);
	
		return price;
	}
	@Override
	public AccountDto getDayTotalAccount(Map<String, String> map) {//일간 총 금액 및 시간표-월간 및 기간에서 일자 누를 시에
		
		AccountDto dto = new AccountDto();
		int price = getDaySelectPrice(map);
		dto.setTotal_price(price);
		
		/*try {
			con = dataSource.getConnection();
			String sql = "SELECT SUM(price) total_price FROM day_calculate_view "
					+ "WHERE order_time BETWEEN to_date(?, 'yyyy-mm-dd hh24:mi:ss') "
					+ "AND to_date(?, 'yyyy-mm-dd hh24:mi:ss')";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dayDate + " 00:00:00");
			pstmt.setString(2, dayDate + " 23:59:59");
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
		
		}*/
		return dto;
	}

	@Override
	public ArrayList<AccountDto> getMonthAccountDays(Map<String, String> map) {//월간 일자
		ArrayList<AccountDto> monthList = new ArrayList<AccountDto>();
		AccountDao dao = this.sqlSession.getMapper(AccountDao.class);
		monthList = dao.getMonthAccountDays(map);
		/*map.put("mapMonth",mapMonth);
		map.put("mapNextMonth", mapNextMonth);*/
		/*	String sql = "SELECT * FROM "
					+ "(SELECT(TO_DATE (?, 'YYYY-MM-DD') + LEVEL - 1) "
					+ "FROM DUAL "
					+ "CONNECT BY (TO_DATE (?, 'YYYY-MM-DD') + LEVEL - 1) < "
					+ "TO_DATE (?, 'YYYY-MM-DD'))";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Calendar.getInstance().get(Calendar.YEAR)+"-"+monlist+"-01");
			pstmt.setString(2, Calendar.getInstance().get(Calendar.YEAR)+"-"+monlist+"-01");
			pstmt.setString(3, Calendar.getInstance().get(Calendar.YEAR)+"-"+(monlist+1)+"-01");*/
		return monthList;
	}
	
	public int getMonthAccountCount(Map<String, String> map) {
		System.out.println("getMonthAccountCount");
		AccountDao dao = this.sqlSession.getMapper(AccountDao.class);
		int cnt = dao.getMonthAccountCount(map);
		
		return cnt;
	}

	public int getMonthPrice(Map<String, String> map) {
		System.out.println("getMonthPrice");
		AccountDao dao = this.sqlSession.getMapper(AccountDao.class);
		int price = dao.getMonthPrice(map);
		
		return price;
	}
	
	public AccountDto getMonthAccountPrice(Map<String, String> map) {//월간 일자별 총 수익 금액
		System.out.println("getMonthAccountPrice");
		AccountDto dto = new AccountDto();
		//AccountDao dao = this.sqlSession.getMapper(AccountDao.class);
		int cnt = getMonthAccountCount(map);
		if(cnt > 0) {
			//monthPrice = dto.setPrice(getMonthPrice(map2));
			int price = getMonthPrice(map);
			dto.setPrice(price);
		}
		/*try {
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
		
		}*/
		return dto;
	}
	
	public int getMonthTotalPrice(Map<String, String> map) {
		System.out.println("getMonthPrice");
		AccountDao dao = this.sqlSession.getMapper(AccountDao.class);
		int price = dao.getMonthTotalPrice(map);
		
		return price;
	}
	
	public AccountDto getMonthTotalAccount(Map<String, String> map) {//월간 총 수익 금액
		
		AccountDto monPriceDto = new AccountDto();
		int price = getMonthTotalPrice(map);
		monPriceDto.setTotal_price(price);
		
		/*try {
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
		
		}*/
		return monPriceDto;
	}
	
	@Override
	public List<AccountDto> getSelectAccountDays(Map<String, String> map) {//기간 일자
		List <AccountDto> selectList = new ArrayList<AccountDto>();
		AccountDao dao = this.sqlSession.getMapper(AccountDao.class);
		AccountDto dto = null;
		selectList = dao.getSelectAccountDays(map);

		/*try {
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
		
		}*/
		return selectList;
	}
	
	public int getSelectAccountCount(Map<String, String> map) {
		System.out.println("getSelectAccountCount");
		AccountDao dao = this.sqlSession.getMapper(AccountDao.class);
		int cnt = dao.getSelectAccountCount(map);
		return cnt;
	}
	
	public int getSelectPrice(Map<String, String> map) {
		System.out.println("getSelectPrice");
		AccountDao dao = this.sqlSession.getMapper(AccountDao.class);
		int price = dao.getSelectPrice(map);
		
		return price;
	}
	
	public AccountDto getSelectAccountPrice(Map<String, String> map) {//기간 일자별 총 수익 금액
		System.out.println("getSelectAccountPrice");
		AccountDto dto = new AccountDto();
		int cnt = getSelectAccountCount(map);
		if(cnt > 0) {
			int price = getSelectPrice(map);
			dto.setPrice(price);
		}
		/*Calendar today = Calendar.getInstance();
		String[] startL = startday.split("-");
		int year = Integer.parseInt(startL[0]);
		int month = Integer.parseInt(startL[1]);
		int day = Integer.parseInt(startL[2]);
		int day2 = Integer.parseInt(startL[2]);
		int day3 = Integer.parseInt(startL[2]);
		int day4 = Integer.parseInt(startL[2]);
		long diffDays = 0;
		today.set(today.get(Calendar.YEAR), month - 1, day);
		System.out.println(month - 1);
		
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
					+ "BETWEEN to_date(?, 'yyyy-mm-dd hh24:mi:ss') "
					+ "AND to_date(?, 'yyyy-mm-dd hh24:mi:ss')";
			for(int i = 0; i <= diffDays; i++) {
			pstmt = con.prepareStatement(sql);
			System.out.println("start = " + year + "-" + month + "-" + (day++) + " 00:00:00");
			System.out.println("end = " + year + "-" + month + "-" + (day2++) + " 23:59:59");
			
			pstmt.setString(1, year + "-" + month + "-" + (day3++) + " 00:00:00");
			pstmt.setString(2, year + "-" + month + "-" + (day4++) + " 23:59:59");
			if(day > today.getActualMaximum(Calendar.DATE)) {
				day = 1;
				day2 = 1;
				day3 = 1;
				day4 = 1;
				month = month+1;
				today.set(today.get(Calendar.YEAR), month - 1, day);
			}
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
		
		}*/
		return dto;
	}
	
	public int getSelectTotalPrice(Map<String, String> map) {
		System.out.println("getSelectTotalPrice");
		AccountDao dao = this.sqlSession.getMapper(AccountDao.class);
		int price = dao.getSelectTotalPrice(map);
		
		return price;
	}
	
	public AccountDto getSelectTotalAccount(Map<String, String> map) {//기간 총 수익 금액
		AccountDto selPriceDto = new AccountDto();
		int price = getSelectTotalPrice(map);
		selPriceDto.setTotal_price(price);
		/*Connection con = null;
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
		
		}*/
		
		return selPriceDto;
	}
}
