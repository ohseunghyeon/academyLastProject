package com.first.lastproject.command.hostOrder;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.first.lastproject.dao.OrderDao;
import com.first.lastproject.dao.OrderDaoImpl;
import com.first.lastproject.dao.SeatDao;

@Service("hostOrderDoneCommand")

public class HostOrderDoneCommand implements HostOrderCommand {
	@Autowired
	OrderDao orderDao;
	
	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String order_id = request.getParameter("order_id");
		int orderDoneResult = orderDao.makeOrderDone(order_id);
		
		model.addAttribute("orderDoneResult", orderDoneResult);
		return "redirect:/hostOrderList";
	}
}
