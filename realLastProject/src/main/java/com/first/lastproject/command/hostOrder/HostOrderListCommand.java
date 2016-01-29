package com.first.lastproject.command.hostOrder;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.order.OrderDao;
import com.first.lastproject.dto.HostOrderListDto;
import com.first.lastproject.dto.OrderDto;

public class HostOrderListCommand implements HostOrderCommand {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		
		OrderDao orderDao = OrderDao.getInstance();
		
		ArrayList<OrderDto> order_done =orderDao.getOrder_done();
		for(int i=0; i<order_done.size(); i++){
			OrderDto dto = new OrderDto();

		}
		System.out.println(order_done);
		
		ArrayList<HostOrderListDto> holDtoArray = new ArrayList<HostOrderListDto>();
		ArrayList<String> foodNameArray = new ArrayList<String>();
		for (int i = 0; i <order_done.size(); i++) {
			String food_name =orderDao.getOrderList(order_done.get(i).getOrder_id());
			
			foodNameArray.add(food_name);
		}
		for (int i = 0; i < order_done.size(); i++) {
			HostOrderListDto holDto = new HostOrderListDto();
			holDto.setFood_name(foodNameArray.get(i));
			holDto.setOrder_id(order_done.get(i).getOrder_id());
			holDto.setSeat_num(order_done.get(i).getSeat_num());
			holDtoArray.add(holDto);
		}
		
		String orderList = orderDao.getOrderList("order_id");
					
		model.addAttribute("holDtoArray", holDtoArray);
		
		return "host/order/orderList";
	}

	
	}


