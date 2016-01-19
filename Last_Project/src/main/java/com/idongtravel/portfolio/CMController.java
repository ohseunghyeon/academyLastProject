package com.idongtravel.portfolio;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CMController {
	
	@RequestMapping("/companyIntro")
	public String companyIntro(HttpServletRequest request) {
		return "companyIntro/companyIntro";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		System.out.println("login()");
		return "login/login";
	}
	@RequestMapping("/findidForm")
	public String findidForm(HttpServletRequest request) {
		return "login/findidForm";
	}
	@RequestMapping("/findidView")
	public String findidView(HttpServletRequest request) {
		return "login/findidView";
	}
	@RequestMapping("/findPasswdForm")
	public String findPasswdForm(HttpServletRequest request) {
		return "login/findPasswdForm";
	}
	@RequestMapping("/findPasswdView")
	public String findPasswdView(HttpServletRequest request) {
		return "login/findPasswdView";
	}
	@RequestMapping("/inputForm")
	public String inputForm(HttpServletRequest request) {
		return "login/inputForm";
	}	

}
