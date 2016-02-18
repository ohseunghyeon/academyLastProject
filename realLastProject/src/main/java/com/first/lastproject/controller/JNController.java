package com.first.lastproject.controller;

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
import com.first.lastproject.command.member.MemberCommand;
import com.first.lastproject.command.member.MemberFindProCommand;
import com.first.lastproject.command.member.MemberLoginFormCommand;
import com.first.lastproject.command.member.MemberLoginProCommand;
import com.first.lastproject.command.member.MemberLogoutCommand;
import com.first.lastproject.command.member.MemberModifyProCommand;
import com.first.lastproject.command.member.MemberModifyViewCommand;
import com.first.lastproject.command.member.MemberRegisterProCommand;
import com.first.lastproject.command.member.NoMemberLoginProCommand;
import com.first.lastproject.dao.MemberDao;
import com.first.lastproject.dao.MemberDaoImpl;
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
	
	@RequestMapping("/nomemberLoginPro")	
	public String nomemberLoginPro(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		MemberCommand command = new NoMemberLoginProCommand();
		String viewname = command.execute(model);
		return viewname;
	}
	
	@RequestMapping("/hostLoginForm")	
	public String hostLoginForm(Model model) {
		return "/member/hostLoginForm";
	}
	
	@RequestMapping("/hostLoginPro")	
	public String hostLoginPro(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		MemberCommand command = new HostLoginProCommand();
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
	
	@RequestMapping("/memberFindForm")
	public String memberFindForm(Model model) {
		return "/member/memberFindForm";
	}
	
	@RequestMapping("/memberFindPro")
	public String memberFindPro(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		MemberCommand command = new MemberFindProCommand();
		String viewname = command.execute(model);
		return viewname;
	}
	
	  @Autowired
      private EmailSender emailSender;
      @Autowired
      private Email email;
       @RequestMapping("/passwdMail")
       public ModelAndView sendEmailAction (@RequestParam Map<String, Object> map, ModelMap model) throws Exception {
           ModelAndView mv;
           String id=(String)map.get("id");
           String emails=(String) map.get("email");
           System.out.println(id);
           System.out.println(emails);
           
           //비밀번호 가져오기
           MemberDao dao = MemberDaoImpl.getInstance();
           MemberDto dto = dao.getPasswd(id,emails);
           String passwd = dto.getPasswd();
           
           if(passwd!=null) {
               email.setContent("비밀번호는 "+passwd+" 입니다.");
               email.setReceiver(emails);
               email.setSubject(id+"님 비밀번호 찾기 메일입니다.");
               emailSender.SendEmail(email);
               int idorpass = 1;
               model.addAttribute("id", id);
               model.addAttribute("email", emails);
               model.addAttribute("result", 1);
               model.addAttribute("idorpass", idorpass);
               mv= new ModelAndView("member/memberFindPro");
               return mv;
           }else {
               model.addAttribute("result", 0);
               mv=new ModelAndView("member/memberFindPro");
               return mv;
           }
       }

	
	@RequestMapping("/memberModifyForm")
	public String memberModifyForm(Model model) {
		return "/member/memberModifyForm";
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
	
	@RequestMapping("/accountDay")
	public String accountDay(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		AccountCommand command = new AccountDayCommand();
		String viewname = command.execute(model);
		return viewname;
	}
	
	@RequestMapping("/accountMonth")
	public String accountMonth(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		AccountCommand command = new AccountMonthCommand();
		String viewname = command.execute(model);
		return viewname;
	}
	
	@RequestMapping("/accountDateSelect")
	public String accountDateSelect(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		AccountCommand command = new AccountDateSelectCommand();
		String viewname = command.execute(model);
		return viewname;
	}
}
