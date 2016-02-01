package com.first.lastproject.dao.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public List<AccountDto> getDayAccount() {
		
		ArrayList <AccountDto> dayList = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT * FROM day_calculate_view "
					+ "WHERE order_time >= to_char(trunc(sysdate,'dd'),'yyyy/mm/dd') "
					+ "AND order_time < to_char(trunc(sysdate,'dd')+1,'yyyy/mm/dd')"
					+ "ORDER BY order_id ASC";
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
	public AccountDto getDayTotalAccount() {
		
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
	public List<AccountDto> getMonthAccountDays() {
		ArrayList <AccountDto> monthList = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT TO_DATE(TO_CHAR(SYSDATE, 'yyyymm')|| "
					+ "LPAD(LEVEL, 2, '0'))DATES"
					+ "FROM DUAL "
					+ "CONNECT BY TO_DATE(TO_CHAR(SYSDATE,'YYYYMM')|| '01', 'YYYYMMDD') + LEVEL - 1"
					+ "<= LAST_DAY(SYSDATE)";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(monthList == null) {
					monthList = new ArrayList<AccountDto>();
				}
				AccountDto dto1 = new AccountDto();
			dto1.setDate(rs.getTimestamp(1));
			monthList.add(dto1);
			System.out.println(monthList);
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
		return monthList;
	}

	public List<AccountDto> getMonthAccountPrice() {
		ArrayList <AccountDto> monthprice = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT SUM(price) total_price "
					+ "FROM day_calculate_view WHERE order_time "
					+ "BETWEEN to_date('2016-?-? 00:00:00', 'yyyy-mm-dd hh24:mi:ss')"
					+ "AND to_date('2016-?-? 23:59:59', 'yyyy-mm-dd hh24:mi:ss')";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(monthprice == null) {
					monthprice = new ArrayList<AccountDto>();
				}
				AccountDto dto2 = new AccountDto();
			dto2.setPrice(1);
			monthprice.add(dto2);
			System.out.println(monthprice);
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
	
	public AccountDto getMonthTotalAccount() {
		
		AccountDto monPriceDto = new AccountDto();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT SUM(price) total_price FROM day_calculate_view "
					+ "WHERE order_time between to_date('2016-?-01 00:00:00', 'yyyy-mm-dd hh24:mi:ss')"
					+ "AND to_date('2016-?-01 00:00:00', 'yyyy-mm-dd hh24:mi:ss')";
			pstmt = con.prepareStatement(sql);
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
}
