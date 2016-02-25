package com.first.lastproject.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.first.lastproject.command.account.AccountCommand;
import com.first.lastproject.command.account.AccountDateSelectCommand;
import com.first.lastproject.command.account.AccountDayCommand;
import com.first.lastproject.command.account.AccountMonthCommand;
import com.first.lastproject.command.email.Email;
import com.first.lastproject.command.email.EmailSender;
import com.first.lastproject.command.member.HostLoginProCommand;
import com.first.lastproject.command.member.MemberConfirmIdCommand;
import com.first.lastproject.command.member.MemberFindProCommand;
import com.first.lastproject.command.member.MemberLoginFormCommand;
import com.first.lastproject.command.member.MemberLoginProCommand;
import com.first.lastproject.command.member.MemberLogoutCommand;
import com.first.lastproject.command.member.MemberModifyProCommand;
import com.first.lastproject.command.member.MemberModifyViewCommand;
import com.first.lastproject.command.member.MemberRegisterProCommand;
import com.first.lastproject.command.member.NoMemberLoginProCommand;
import com.first.lastproject.dao.MemberDao;
import com.first.lastproject.dto.MemberDto;

@Controller
public class JNController {

	@RequestMapping("/index")
	public String index(Model model) {
		return "/index";
	}

	@RequestMapping("/memberMain")
	public String memberMain(Model model) {
		return "/member/memberMain";
	}

	@RequestMapping("/memberRegister")
	public String memberRegister(Model model) {
		return "/member/memberRegister";
	}

	@Autowired
	MemberConfirmIdCommand memberConfirmIdCommand;

	@RequestMapping("/memberConfirmId")
	public String memberConfirmId(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		String viewname = memberConfirmIdCommand.execute(model);
		return viewname;
	}

	@Autowired
	MemberRegisterProCommand memberRegisterProCommand;

	@RequestMapping("/memberRegisterPro")
	public String memberRegisterPro(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		String viewname = memberRegisterProCommand.execute(model);
		return viewname;
	}

	@Autowired
	MemberLoginFormCommand memberLoginFormCommand;

	@RequestMapping("/memberLoginForm")
	public String memberLoginForm(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		String viewname = memberLoginFormCommand.execute(model);
		return viewname;
	}

	@Autowired
	MemberLoginProCommand memberLoginProCommand;

	@RequestMapping("/memberLoginPro")
	public String memberLoginPro(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		String viewname = memberLoginProCommand.execute(model);
		return viewname;
	}

	@Autowired
	NoMemberLoginProCommand noMemberLoginProCommand;

	@RequestMapping("/nomemberLoginPro")
	public String nomemberLoginPro(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		String viewname = noMemberLoginProCommand.execute(model);
		return viewname;
	}

	@RequestMapping("/hostLoginForm")
	public String hostLoginForm(Model model) {
		return "/member/hostLoginForm";
	}

	@Autowired
	HostLoginProCommand hostLoginProCommand;

	@RequestMapping("/hostLoginPro")
	public String hostLoginPro(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		String viewname = hostLoginProCommand.execute(model);
		return viewname;
	}

	@Autowired
	MemberLogoutCommand memberLogoutCommand;

	@RequestMapping("/memberLogout")
	public String memberLogout(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		String viewname = memberLogoutCommand.execute(model);
		return viewname;
	}

	@RequestMapping("/memberFindForm")
	public String memberFindForm(Model model) {
		return "/member/memberFindForm";
	}

	@Autowired
	MemberFindProCommand memberFindProCommand;

	@RequestMapping("/memberFindPro")
	public String memberFindPro(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		String viewname = memberFindProCommand.execute(model);
		return viewname;
	}

	@Autowired
	private EmailSender emailSender;
	@Autowired
	private Email email;
	@Autowired
	MemberDao dao;

	@RequestMapping("/passwdMail")
	public ModelAndView sendEmailAction(@RequestParam Map<String, Object> map, ModelMap model) throws Exception {
		ModelAndView mv;
		String id = (String) map.get("id");
		String emails = (String) map.get("email");
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("id", id);
		map2.put("email", emails);
		System.out.println(id);
		System.out.println(emails);

		// 비밀번호 가져오기
		MemberDto dto = dao.getPasswd(map2);
		String passwd = dto.getPasswd();

		if (passwd != null) {
			email.setContent("비밀번호는 " + passwd + " 입니다.");
			email.setReceiver(emails);
			email.setSubject(id + "님. 사색카페 비밀번호입니다.");
			emailSender.SendEmail(email);
			int idorpass = 1;
			model.addAttribute("id", id);
			model.addAttribute("email", emails);
			model.addAttribute("result", 1);
			model.addAttribute("idorpass", idorpass);
			mv = new ModelAndView("member/memberFindPro");
			return mv;
		} else {
			model.addAttribute("result", 0);
			mv = new ModelAndView("member/memberFindPro");
			return mv;
		}
	}

	@RequestMapping("/memberModifyForm")
	public String memberModifyForm(Model model) {
		return "/member/memberModifyForm";
	}

	@Autowired
	MemberModifyViewCommand memberModifyViewCommand;

	@RequestMapping("/memberModifyView")
	public String memberModifyView(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		String viewname = memberModifyViewCommand.execute(model);
		return viewname;
	}

	@Autowired
	MemberModifyProCommand memberModifyProCommand;

	@RequestMapping("/memberModifyPro")
	public String memberModifyPro(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		String viewname = memberModifyProCommand.execute(model);
		return viewname;
	}

	@Autowired
	AccountDayCommand accountDayCommand;

	@RequestMapping("/accountDay")
	public String accountDay(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		String viewname = accountDayCommand.execute(model);
		return viewname;
	}

	@Autowired
	AccountMonthCommand accountMonthCommand;

	@RequestMapping("/accountMonth")
	public String accountMonth(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		String viewname = accountMonthCommand.execute(model);
		return viewname;
	}

	@Autowired
	AccountDateSelectCommand accountDateSelectCommand;
	
	@RequestMapping("/accountDateSelect")
	public String accountDateSelect(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		String viewname = accountDateSelectCommand.execute(model);
		return viewname;
	}
}
