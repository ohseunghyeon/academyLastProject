package com.first.lastproject.dao.order;

public interface InterfaceOrderDao {
//주문
	public int insertOrder(String id, int seat_code);
	public int insertOrderMenu(String order_code, int food_code);
	public String getOrder_code(int seat_num);
}
