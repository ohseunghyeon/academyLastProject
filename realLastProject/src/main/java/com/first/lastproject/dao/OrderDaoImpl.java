package com.first.lastproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.first.lastproject.dto.OrderDto;

public class OrderDaoImpl implements OrderDao {
	DataSource dataSource;

	private static OrderDaoImpl instance;

	public static OrderDaoImpl getInstance() {
		if (instance == null) {
			instance = new OrderDaoImpl();
		}
		return instance;
	}

	private OrderDaoImpl() {
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
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
	public int useCoupon(int coupon_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			con = dataSource.getConnection();
			String sql = "delete from p_coupon where coupon_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, coupon_num);
			count = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
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
			String sql = "INSERT INTO p_order_menu VALUES (?,?)"; // 손님이 주문한 메뉴 추가.
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, order_code);
			pstmt.setInt(2, food_code);
			count = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
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
			con = dataSource.getConnection(); // 컨넥션풀에서 connection객체 가져온다.
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
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return order_code;
	}

	public String concatFoodName(String order_id) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String food_name = null;

		try {
			con = dataSource.getConnection();
			String sql = "select f.food_name, count(f.food_name) num from p_order_menu o join p_food f on(o.food_code=f.food_code) where order_id = ? group by f.food_name";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, order_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if (food_name == null) {
					food_name = "";
				}
				food_name += rs.getString("food_name") + "(" + rs.getInt("num") + ") ";
				
			}
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.getStackTrace();
			}
		}
		return food_name;
	}

	public ArrayList<OrderDto> getUndoneOrder() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<OrderDto> orderUndoneList = null;

		try {
			con = dataSource.getConnection();
			String sql = "select * from p_order where order_done=0";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if (orderUndoneList == null) {
					orderUndoneList = new ArrayList<OrderDto>();
				}
				OrderDto orderDto = new OrderDto();
				orderDto.setOrder_id(rs.getString("order_id"));
				orderDto.setSeat_num(rs.getInt("seat_num"));
				orderUndoneList.add(orderDto);
			}
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.getStackTrace();
			}
		}

		return orderUndoneList;
	}

	@Override
	public int updateOrderSeatEndTime(String order_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			con = dataSource.getConnection();
			String sql = "UPDATE p_order SET end_time=sysdate WHERE order_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, order_id);
			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	@Override
	public int makeOrderDone(String order_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			con = dataSource.getConnection();
			String sql = "UPDATE p_order SET order_done=1 WHERE order_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, order_id);
			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
}
