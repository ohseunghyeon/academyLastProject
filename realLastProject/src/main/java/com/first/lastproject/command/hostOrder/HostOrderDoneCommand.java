package com.first.lastproject.command.hostOrder;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.order.InterfaceOrderDao;
import com.first.lastproject.dao.order.OrderDao;

public class HostOrderDoneCommand implements HostOrderCommand {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String order_id = request.getParameter("order_id");
		
		InterfaceOrderDao orderDao = OrderDao.getInstance();
		int orderDoneResult = orderDao.makeOrderDone(order_id);
		
		model.addAttribute("orderDoneResult", orderDoneResult);
		return "redirect:/hostOrderList";
	}
}
