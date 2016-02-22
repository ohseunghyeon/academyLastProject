package com.first.lastproject.dao;

import java.util.ArrayList;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.first.lastproject.dto.FoodDto;
import com.first.lastproject.dto.OrderDto;
@Repository
public class OrderDaoImpl implements OrderDao {
	DataSource dataSource;
	
	@Autowired
	private SqlSession sqlSession;

	
	public int insertOrder(Map<String, Object> map) {
		int count = 0;
		OrderDao orderDao = this.sqlSession.getMapper(OrderDao.class);
		count = orderDao.insertOrder(map);
		return count;
	}
	
	public int useCoupon(int coupon_num) {
		int count = 0;
		OrderDao orderDao = this.sqlSession.getMapper(OrderDao.class);
		count = orderDao.useCoupon(coupon_num);
		return count;
	}
		
	public int insertOrderMenu(Map<String, Object> map) {// 손님이 주문한 메뉴 추가.
		int count = 0;
		OrderDao dao = this.sqlSession.getMapper(OrderDao.class);
		count = dao.insertOrderMenu(map);
		return count;
	}

	@Override
	public String getOrder_code(int seat_num) {
		String order_code = null;
		OrderDao orderDao = this.sqlSession.getMapper(OrderDao.class);
		order_code = orderDao.getOrder_code(seat_num);
		return order_code;
	}

	public ArrayList<FoodDto> concatFoodName(String order_id) {
		OrderDao orderDao = this.sqlSession.getMapper(OrderDao.class);
		ArrayList<FoodDto> foodList = orderDao.concatFoodName(order_id);
		return foodList;
	}

	public ArrayList<OrderDto> getUndoneOrder() {
	ArrayList<OrderDto> orderUndoneList =  new ArrayList<OrderDto>();
	OrderDao orderDao = this.sqlSession.getMapper(OrderDao.class);
	orderUndoneList=orderDao.getUndoneOrder();
	return orderUndoneList;
	
	}

	@Override
	public int updateOrderSeatEndTime(String order_id) {
		int count = 0;
		OrderDao orderDao = this.sqlSession.getMapper(OrderDao.class);
		count = orderDao.updateOrderSeatEndTime(order_id);
		return count;
	}

	@Override
	public int makeOrderDone(String order_id) {
		int count=0;
		OrderDao orderDao = this.sqlSession.getMapper(OrderDao.class);
		count = orderDao.makeOrderDone(order_id);
		return count;
	}
}
