package com.first.lastproject.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.first.lastproject.command.goods.GoodsCommand;
import com.first.lastproject.command.goods.GoodsShoppingBagCommand;
import com.first.lastproject.command.member.MemberCommand;
import com.first.lastproject.command.member.MemberConfirmIdCommand;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("shoppingBag")
	public String shoppingBag(HttpServletRequest request, Model model) {
		System.out.println("shoppingBag()");
		model.addAttribute("request", request);
		
		GoodsCommand command = new GoodsShoppingBagCommand();
		String viewName = command.execute(model);
		return viewName;
	}
	
	@RequestMapping("confirmId")
	public String confirmId(HttpServletRequest request, Model model) {
		System.out.println("confirmId()");
		model.addAttribute("request", request);
		
		MemberCommand command = new MemberConfirmIdCommand();
		String viewName = command.execute(model);
		return viewName;
	}
	
}
