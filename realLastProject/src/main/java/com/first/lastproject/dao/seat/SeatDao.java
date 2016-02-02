package com.first.lastproject.dao.seat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.first.lastproject.dto.OrderDto;
import com.first.lastproject.dto.SeatDto;

public class SeatDao implements InterfaceSeatDao {
	DataSource dataSource;

	private static SeatDao instance;

	public static SeatDao getInstance() {
		if (instance == null) {
			instance = new SeatDao();
		}
		return instance;
	}

	private SeatDao() {
		try {
			// Servers/context.xml에 정의한 커넥션 풀을 가져와서 쓰겠다.
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<SeatDto> getSeats() {
		ArrayList<SeatDto> seats = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			String sql = "select * from p_seat";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if (seats == null) {
					seats = new ArrayList<SeatDto>();
				}
				SeatDto seat = new SeatDto();
				seat.setSeat_num(rs.getInt("seat_num"));
				seat.setOccupied(rs.getInt("occupied"));
				seats.add(seat);
			}
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

		return seats;
	}

	public OrderDto seatInformation(int seat_num) {
		OrderDto orderDto = new OrderDto();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "select * from p_order where seat_num=? order by order_time desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seat_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				orderDto.setOrder_id(rs.getString("order_id"));
				orderDto.setSeat_num(rs.getInt("seat_num"));
				orderDto.setId(rs.getString("id"));
				orderDto.setOrder_time(rs.getTimestamp("order_time"));
				orderDto.setEnd_time(rs.getTimestamp("end_time"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return orderDto;

	}

	@Override
	public int startSeat(int seat_num) { //결제 완료시 좌석을 점유됨으로 변경.
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			con = dataSource.getConnection();
			String sql = "UPDATE p_seat SET occupied=1 WHERE seat_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seat_num);
			result = pstmt.executeUpdate();
			
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
		return result;
	}

	@Override
	public int timeFinishedSeat(int seat_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			con = dataSource.getConnection();
			String sql = "UPDATE p_seat SET occupied=0 WHERE seat_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seat_num);
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

}
