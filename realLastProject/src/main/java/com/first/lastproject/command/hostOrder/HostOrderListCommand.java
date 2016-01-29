package com.first.lastproject.command.hostOrder;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.order.OrderDao;
import com.first.lastproject.dto.HostOrderListDto;

public class HostOrderListCommand implements HostOrderCommand {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		OrderDao orderDao = OrderDao.getInstance();
		ArrayList<HostOrderListDto> orderList = orderDao.getOrderList();
		
		
		model.addAttribute("orderList", orderList);
		
		
		
		
		return "host/order/orderList";
	}

}
