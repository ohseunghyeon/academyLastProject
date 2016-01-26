package com.first.lastproject.dto;

import java.sql.Timestamp;

public class SeatDto {
	private int table_num;
	private int occupied;
	private Timestamp start_time;
	private Timestamp end_time;
	public int getTable_num() {
		return table_num;
	}
	public void setTable_num(int table_num) {
		this.table_num = table_num;
	}
	public int getOccupied() {
		return occupied;
	}
	public void setOccupied(int occupied) {
		this.occupied = occupied;
	}
	public Timestamp getStart_time() {
		return start_time;
	}
	public void setStart_time(Timestamp start_time) {
		this.start_time = start_time;
	}
	public Timestamp getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Timestamp end_time) {
		this.end_time = end_time;
	}
	
	
}
