package com.idongtravel.portfolio;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("home");
		return mv;
	}
	
}
