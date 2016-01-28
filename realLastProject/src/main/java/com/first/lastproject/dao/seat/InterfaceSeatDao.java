package com.first.lastproject.dao.seat;

import java.util.ArrayList;

import com.first.lastproject.dto.OrderDto;
import com.first.lastproject.dto.SeatDto;

public interface InterfaceSeatDao {

//seat 좌석
	public ArrayList<SeatDto> getSeats();
	public int selectSeats();
	public int timeFinishedSeats();
//host에서 좌석 정보보기
	public OrderDto seatInformation(int seat_num);
}
