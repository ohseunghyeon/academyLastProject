package com.first.lastproject.dao.seat;

import java.util.ArrayList;

import com.first.lastproject.dto.SeatDto;

public interface InterfaceSeatDao {

//seat 좌석
	public ArrayList<SeatDto> getSeats();
	public int selectSeats();
	public int timeFinishedSeats();
}
