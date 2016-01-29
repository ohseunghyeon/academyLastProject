package com.first.lastproject.dto;

import java.sql.Timestamp;

public class AccountDto {

	private String order_id;
	private int seat_num;
	private Timestamp order_time;
	private Timestamp end_time;
	private int price;
	private Timestamp used_time;
	private Timestamp total_time;
	private int total_price;
	
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Timestamp getUsed_time() {
		return used_time;
	}
	public void setUsed_time(Timestamp used_time) {
		this.used_time = used_time;
	}
	public Timestamp getTotal_time() {
		return total_time;
	}
	public void setTotal_time(Timestamp total_time) {
		this.total_time = total_time;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
}
