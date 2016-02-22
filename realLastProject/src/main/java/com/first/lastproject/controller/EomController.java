package com.first.lastproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.first.lastproject.command.goods.GoodsCommand;
import com.first.lastproject.command.goods.GoodsListCommand;
import com.first.lastproject.command.goods.GoodsListProCommand;
import com.first.lastproject.command.goods.GoodsPayFinishCommand;

@Controller
public class EomController {
	
	@Autowired
	GoodsListCommand goodsListCommand;
	
	@RequestMapping("/goodsList")
	public String goodsList(HttpServletRequest request, Model model) {
		System.out.println("goodsList()");
		model.addAttribute("request", request);	
		String viewName = goodsListCommand.execute(model);
		
		return viewName;
	}
	
	@Autowired
	GoodsListProCommand goodsListProCommand;
	
	@RequestMapping("/goodsListPro")
	public String goodsListPro(HttpServletRequest request, Model model) {
		System.out.println("goodsListPro");
		model.addAttribute("request", request);	
		String viewName = goodsListProCommand.execute(model);
		
		return viewName;
	}
	
	@Autowired
	GoodsPayFinishCommand goodsPayFinishCommand;
	
	@RequestMapping("/paymentFinish")
	public String paymentFinish(HttpServletRequest request, Model model) {
		System.out.println("paymentFinish()");
		model.addAttribute("request", request);	
		String viewName = goodsPayFinishCommand.execute(model);
		
		return viewName;
	}

}
