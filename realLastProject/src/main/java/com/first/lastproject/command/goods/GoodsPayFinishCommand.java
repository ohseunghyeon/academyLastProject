package com.first.lastproject.command.goods;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.order.InterfaceOrderDao;
import com.first.lastproject.dao.order.OrderDao;
import com.first.lastproject.dao.seat.InterfaceSeatDao;
import com.first.lastproject.dao.seat.SeatDao;

public class GoodsPayFinishCommand implements GoodsCommand {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String id = (String) request.getSession().getAttribute("id");
		int seat_num = (Integer) request.getSession().getAttribute("seat_num");

		InterfaceOrderDao orderDao = OrderDao.getInstance();
		int orderInsertResult = orderDao.insertOrder(id, seat_num); // p_order에 추가.
		
		int insertOrderMenuError = 0; // 전체 메뉴 삽입 실패했는지 확인하기 위함
		if (orderInsertResult == 1) { // 이제 주문 메뉴 추가 order_code와 food_code로 메뉴
										// 하나씩 추가
			InterfaceSeatDao seatDao = SeatDao.getInstance();
				seatDao.startSeat(seat_num);
			
			String[] foodCodes = request.getParameterValues("food_code");
			String[] foodNums = request.getParameterValues("food_num");

			String order_code = orderDao.getOrder_code(seat_num);

			int insertOrderMenu = 0; // 각 메뉴가 실패했는지 확인하기 위함
			for (int i = 0; i < foodCodes.length; i++) {
				for (int j = 0; j < Integer.parseInt(foodNums[i]); j++) {
					insertOrderMenu = orderDao.insertOrderMenu(order_code, Integer.parseInt(foodCodes[i]));
					if (insertOrderMenu == 0) {
						insertOrderMenuError = 1;
					}
				}
			}
		}
		if (insertOrderMenuError == 1) {
			System.out.println(insertOrderMenuError);
		}
		model.addAttribute("orderInsertResult", orderInsertResult);

		return "guest/payment/paymentFinish";
	}

}
