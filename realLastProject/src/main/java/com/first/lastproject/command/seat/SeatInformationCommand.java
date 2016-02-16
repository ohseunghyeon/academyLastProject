package com.first.lastproject.command.seat;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.seat.InterfaceSeatDao;
import com.first.lastproject.dao.seat.SeatDao;
import com.first.lastproject.dto.OrderDto;


public class SeatInformationCommand implements SeatCommand {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		InterfaceSeatDao seatDao = SeatDao.getInstance();
		OrderDto orderDto = new OrderDto();
		int seat_num = Integer.parseInt(request.getParameter("seat_num"));
		orderDto = seatDao.seatInformation(seat_num);
		
		
		model.addAttribute("seatDao", seatDao);
		model.addAttribute("orderDto", orderDto);
		System.out.println(seat_num +"번");
		System.out.println(orderDto.getSeat_num());
		System.out.println(orderDto.getId());
		System.out.println(orderDto.getOrder_id());
		System.out.println(orderDto.getOrder_time());
		System.out.println(orderDto.getEnd_time());
		return "host/seat/seatInformation";
	}

}
