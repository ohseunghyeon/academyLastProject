package com.first.lastproject.command.goods;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.order.InterfaceOrderDao;
import com.first.lastproject.dao.order.OrderDao;

public class GoodsPayFinishCommand implements GoodsCommand {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		/*String id = (String) request.getSession().getAttribute("id");
		int seat_num = (Integer) request.getSession().getAttribute("seat_num");
		
		String[] shoppingBag = request.getParameterValues("food_code");
		
		InterfaceOrderDao orderDao = OrderDao.getInstance();
		int result = orderDao.insertOrder(id, seat_num);
		if (result == 1) {
			String order_id = orderDao.getOrder_code(seat_num);
			
			int insertOrderMenu = 0; 
			for (String food_code : shoppingBag) {
				insertOrderMenu = orderDao.insertOrderMenu(order_id, Integer.parseInt(food_code));
			}
		}*/
		
		
		
		return "guest/payment/paymentFinish";
	}

}
