package com.first.lastproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.first.lastproject.command.seat.SeatCommand;
import com.first.lastproject.command.seat.SeatListCommand;
import com.first.lastproject.command.seat.SeatSelectConfirmFormCommand;


/**
 * Handles requests for the application home page.
 */
@Controller
public class CMController {
	
	@RequestMapping("/seatList")
	public String getSeats(HttpServletRequest request, Model model){
		System.out.println("getSeats()");
		model.addAttribute("request", request);
		SeatCommand command = new SeatListCommand(); 
		String viewName = command.execute(model);
		
		return viewName;
		
	}
	@RequestMapping("/seatConfirm")
	public String seatConfirm(HttpServletRequest request, Model model){
		System.out.println("getSeats()");
		model.addAttribute("request", request);
		SeatCommand command = new SeatSelectConfirmFormCommand(); 
		String viewName = command.execute(model);
		
		return viewName;
		
	}
}

