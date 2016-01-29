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

}
