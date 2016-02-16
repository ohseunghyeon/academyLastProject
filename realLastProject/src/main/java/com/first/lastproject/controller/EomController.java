package com.first.lastproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.first.lastproject.command.goods.GoodsCommand;
import com.first.lastproject.command.goods.GoodsListCommand;
import com.first.lastproject.command.goods.GoodsListProCommand;
import com.first.lastproject.command.goods.GoodsPayFinishCommand;

@Controller
public class EomController {
	
	@RequestMapping("/goodsList")
	public String goodsList(HttpServletRequest request, Model model) {
		System.out.println("goodsList()");
		model.addAttribute("request", request);	
		GoodsCommand command = new GoodsListCommand();
		
		String viewName = command.execute(model);
		return viewName;
	}
	
	@RequestMapping("/goodsListPro")
	public String goodsListPro(HttpServletRequest request, Model model) {
		System.out.println("goodsListPro");
		model.addAttribute("request", request);	
		GoodsCommand command = new GoodsListProCommand();
		
		String viewName = command.execute(model);
		return viewName;
	}
	
	@RequestMapping("/paymentFinish")
	public String paymentFinish(HttpServletRequest request, Model model) {
		System.out.println("paymentFinish()");
		model.addAttribute("request", request);	
		GoodsCommand command = new GoodsPayFinishCommand();
		
		String viewName = command.execute(model);
		return viewName;
	}

}
