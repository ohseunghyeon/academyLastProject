package com.first.lastproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.first.lastproject.command.stock.StockCommand;
import com.first.lastproject.command.stock.StockFoodModifyProCommand;
import com.first.lastproject.command.stock.StockListCommand;
import com.first.lastproject.command.stock.StockModifyProCommand;


/**
 * Handles requests for the application home page.
 */
@Controller
public class SJController {
	@RequestMapping("/ingredient")
	public String ingredient(HttpServletRequest request, Model model) {
		System.out.println("ingredient()");
		
		model.addAttribute("request", request);
		StockCommand command = new StockListCommand();    
	    String viewname = command.execute(model);
	      
	    return viewname;
	}
	
	@RequestMapping("/modifyForm")
	public String modifyForm(Model model) {
		return "/p_ingredient/modifyForm";
	}
	
	@RequestMapping("/modifyPro")
	public String modifyPro(HttpServletRequest request, Model model) {
		System.out.println("modifyPro()");
		
		model.addAttribute("request", request);
		StockCommand command = new StockModifyProCommand();    
	    String viewname = command.execute(model);
	      
	    return viewname;
	}
	@RequestMapping("/foodmodifyForm")
	public String foodmodifyForm(Model model) {
		return "/p_ingredient/foodmodifyForm";
	}
	
	@RequestMapping("/foodmodifyPro")
	public String foodmodifyPro(HttpServletRequest request, Model model) {
		System.out.println("foodmodifyPro()");
		
		model.addAttribute("request", request);
		StockCommand command = new StockFoodModifyProCommand();    
	    String viewname = command.execute(model);
	      
	    return viewname;
	}
	



}
