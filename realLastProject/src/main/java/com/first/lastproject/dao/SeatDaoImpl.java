package com.first.lastproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.first.lastproject.dto.OrderDto;
import com.first.lastproject.dto.SeatDto;
@Repository
public class SeatDaoImpl implements SeatDao {
	DataSource dataSource;

	@Autowired
	private SqlSession sqlSession;

	@Override
	public ArrayList<SeatDto> getSeats(){
		ArrayList<SeatDto> seats = new ArrayList<SeatDto>();
		SeatDao seatDao=this.sqlSession.getMapper(SeatDao.class);
		seats = seatDao.getSeats();
		return seats;
	}
		

	public OrderDto seatInformation(int seat_num) {
		OrderDto orderDto = new OrderDto();
		SeatDao seatDao=this.sqlSession.getMapper(SeatDao.class);
		orderDto = seatDao.seatInformation(seat_num);
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
		int count = 0;
		SeatDao seatDao=this.sqlSession.getMapper(SeatDao.class);
		count =seatDao.timeFinishedSeat(seat_num);
		return count;
	}
	
}
