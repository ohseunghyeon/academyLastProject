package com.first.lastproject.dao.order;

import java.util.ArrayList;

import com.first.lastproject.dto.OrderDto;

public interface InterfaceOrderDao {
//주문
	public int insertOrder(String id, int seat_num);
	public int insertOrderMenu(String order_code, int food_code);
	public int useCoupon(int coupon_num); // 쿠폰 사용
	public String getOrder_code(int seat_num);
	public int updateOrderSeatEndTime(String order_id);
	public int makeOrderDone(String order_id);
//host 접속시 orderList 보기
	public String concatFoodName(String order_id);
	public ArrayList<OrderDto> getUndoneOrder();
}
