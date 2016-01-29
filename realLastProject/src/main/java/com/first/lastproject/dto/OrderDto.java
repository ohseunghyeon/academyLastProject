package com.first.lastproject.dto;

import java.sql.Timestamp;

public class OrderDto {
	private String order_id;
	private int seat_num;
	private String id;
	private Timestamp order_time;
	private Timestamp end_time;
	private int order_done;

	public int getOrder_done() {
		return order_done;
	}

	public void setOrder_done(int order_done) {
		this.order_done = order_done;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public int getSeat_num() {
		return seat_num;
	}

	public void setSeat_num(int seat_num) {
		this.seat_num = seat_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getOrder_time() {
		return order_time;
	}

	public void setOrder_time(Timestamp order_time) {
		this.order_time = order_time;
	}

	public Timestamp getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Timestamp end_time) {
		this.end_time = end_time;
	}

}
