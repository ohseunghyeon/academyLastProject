package com.first.lastproject.dao.seat;

import com.first.lastproject.dto.SeatDto;

public interface InterfaceSeatDao {

//seat 좌석
	public SeatDto getSeats();
	public int selectSeats();
	public int timeFinishedSeats();
}
