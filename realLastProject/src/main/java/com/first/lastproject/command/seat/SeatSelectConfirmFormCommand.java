package com.first.lastproject.command.seat;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class SeatSelectConfirmFormCommand implements SeatCommand {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int seat_num = Integer.parseInt(request.getParameter("seat_num"));

		model.addAttribute("seat_num", seat_num);

		System.out.println(seat_num);
		return "/seat/seatConfirm";

	}
}
