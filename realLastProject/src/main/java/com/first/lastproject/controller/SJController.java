package com.first.lastproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.first.lastproject.command.stock.StockCommand;
import com.first.lastproject.command.stock.StockListCommand;


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


}
