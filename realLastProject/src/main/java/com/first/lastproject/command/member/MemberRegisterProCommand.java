package com.first.lastproject.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.first.lastproject.dao.MemberDao;
import com.first.lastproject.dto.MemberDto;

@Service("memberRegisterProCommand")
public class MemberRegisterProCommand implements MemberCommand {

	@Autowired
	MemberDao dao;
	
	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		//data from memberRegister.jsp
		MemberDto dto = new MemberDto();
		dto.setId(request.getParameter("id"));
		dto.setPasswd(request.getParameter("passwd"));
		dto.setPhone_number(request.getParameter("phone_number"));
		dto.setEmail(request.getParameter("email"));
		
		int result = dao.addMember(dto);
		model.addAttribute("result", result);
		
		return "member/memberRegisterPro";
	}

}
