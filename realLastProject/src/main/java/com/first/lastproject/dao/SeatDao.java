package com.first.lastproject.dao;

import java.util.ArrayList;

import com.first.lastproject.dto.OrderDto;
import com.first.lastproject.dto.SeatDto;

public interface SeatDao {

//seat 좌석
	public ArrayList<SeatDto> getSeats();
	public int startSeat(int seat_num);
	public int timeFinishedSeat(int seat_num);
//host에서 좌석 정보보기
	public OrderDto seatInformation(int seat_num);
}
