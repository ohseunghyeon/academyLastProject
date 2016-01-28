package com.first.lastproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.first.lastproject.command.goods.GoodsCommand;
import com.first.lastproject.command.goods.GoodsListCommand;

@Controller
public class EomController {
	
	@RequestMapping("/GoodsList")
	public String GoodsList(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		GoodsCommand command = new GoodsListCommand();
		
		String viewName = command.execute(model);
		
		return viewName;
	}
}
