package com.first.lastproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.first.lastproject.command.hostOrder.*;
import com.first.lastproject.command.seat.*;

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
	public String seatSelectConfirmForm(HttpServletRequest request, Model model){
		System.out.println("seatConfirm()");
		model.addAttribute("request", request);
		SeatCommand command = new SeatSelectConfirmFormCommand(); 
		String viewName = command.execute(model);
		
		return viewName;
		
	}
	@RequestMapping("/seatSelectConfirmPro")
	public String seatSelectConfirmPro(HttpServletRequest request, Model model){
		System.out.println("selectSeats()");
		model.addAttribute("request", request);
		SeatCommand command = new SeatSelectConfirmProCommand();
		String viewName= command.execute(model);
		
		return viewName;
		
	}
	@RequestMapping("/seatInformation")
	public String seatInfomation(HttpServletRequest request, Model model){
		System.out.println("seatInformation()");
		model.addAttribute("request", request);
		SeatCommand command = new SeatInformationCommand();
		String viewName=command.execute(model);
		
		return viewName;
	}
	@RequestMapping("/hostOrderList")
	public String hostOrderList(HttpServletRequest request, Model model){
		System.out.println("HostOrderList()");
		model.addAttribute("request", request);
		HostOrderCommand command = new HostOrderListCommand();
		String viewName = command.execute(model);
		
		return viewName;
	}
	
	@RequestMapping("/seatFinish")
	public String guestSeatFinish(HttpServletRequest request, Model model){
		System.out.println("seatFinish()");
		model.addAttribute("request", request);
		SeatCommand command = new SeatFinishCommand();
		String viewName = command.execute(model);
		
		return viewName;
	}
	
	@RequestMapping("/makeOrderDone")
	public String makeOrderDone(HttpServletRequest request, Model model){
		System.out.println("makeOrderDone()");
		model.addAttribute("request", request);
		HostOrderCommand command = new HostOrderDoneCommand();
		String viewName = command.execute(model);
		
		return viewName;
	}
}

