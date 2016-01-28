package com.first.lastproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.first.lastproject.command.member.MemberCommand;
import com.first.lastproject.command.member.MemberLoginFormCommand;
import com.first.lastproject.command.member.MemberLoginProCommand;
import com.first.lastproject.command.member.MemberLogoutCommand;
import com.first.lastproject.command.member.MemberModifyProCommand;
import com.first.lastproject.command.member.MemberModifyViewCommand;
import com.first.lastproject.command.member.MemberRegisterProCommand;

@Controller
public class JNController {
	
	@RequestMapping("/index")
	public String index(Model model) {
		return "/index";
	}

	@RequestMapping("/memberRegister")
	public String memberRegister(Model model) {
		return "member/memberRegister";
	}	
		
	@RequestMapping("/memberRegisterPro")	
	public String memberRegisterPro(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		MemberCommand command = new MemberRegisterProCommand();
		String viewname = command.execute(model);
		return viewname;
	}
	
	@RequestMapping("/memberLoginForm")	
	public String memberLoginForm(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		MemberCommand command = new MemberLoginFormCommand();
		String viewname = command.execute(model);
		return viewname;
	}
	
	@RequestMapping("/memberLoginPro")	
	public String memberLoginPro(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		MemberCommand command = new MemberLoginProCommand();
		String viewname = command.execute(model);
		return viewname;
	}
	
	@RequestMapping("/memberLogout")	
	public String memberLogout(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		MemberCommand command = new MemberLogoutCommand();
		String viewname = command.execute(model);
		return viewname;
	}
	
	@RequestMapping("/memberMain")
	public String memberMain(Model model) {
		return "member/memberMain";
	}
	
	@RequestMapping("/memberModifyForm")
	public String memberModifyForm(Model model) {
		return "member/memberModifyForm";
	}
	
	@RequestMapping("/memberModifyView")
	public String memberModifyView(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		MemberCommand command = new MemberModifyViewCommand();
		String viewname = command.execute(model);
		return viewname;
	}

	@RequestMapping("/memberModifyPro")	
	public String memberModifyPro(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		MemberCommand command = new MemberModifyProCommand();
		String viewname = command.execute(model);
		return viewname;
	}
}
