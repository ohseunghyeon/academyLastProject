package com.first.lastproject.dao.order;

import java.util.ArrayList;

import com.first.lastproject.dto.HostOrderListDto;

public interface InterfaceOrderDao {
//주문
	public int insertOrder(String id, int seat_num);
	public int insertOrderMenu(String order_code, int food_code);
	public String getOrder_code(int seat_num);
	
//host 접속시 orderList 보기
	public String getOrderList(String order_id);
}
