package com.first.lastproject.dao.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class OrderDao implements InterfaceOrderDao {
	DataSource dataSource;
	
	private static OrderDao instance;
	
	public static OrderDao getInstance() {
		if (instance == null) {
			instance = new OrderDao();
		}
		return instance;
	}
	
	private OrderDao() {
		try {
			// Servers/context.xml에 정의한 커넥션 풀을 가져와서 쓰겠다.
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insertOrder(String id, int seat_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		
		try {
			con = dataSource.getConnection();
			String sql = "INSERT INTO p_order VALUES (seq_order_code.nextval,?,?,sysdate,sysdate+3/24, 0)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seat_num);
			pstmt.setString(2, id);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
	public int insertOrderMenu(String order_code, int food_code) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		
		try {
			con = dataSource.getConnection();
			String sql = "INSERT INTO p_order_menu VALUES (?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, order_code);
			pstmt.setInt(2, food_code);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
	@Override
	public String getOrder_code(int seat_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String order_code = null;
		try {
			con = dataSource.getConnection(); //컨넥션풀에서 connection객체 가져온다.
			String sql = "select * from p_order where seat_num=? order by order_time DESC";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seat_num);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				order_code = rs.getString("order_id");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return order_code;
	}
}
