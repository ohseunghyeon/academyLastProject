package com.first.lastproject.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.first.lastproject.dao.MemberDao;
import com.first.lastproject.dao.MemberDaoImpl;
import com.first.lastproject.dto.MemberDto;

@Service("memberModifyProCommand")
public class MemberModifyProCommand implements MemberCommand {

	@Autowired
	MemberDao dao;
	@Override
	public String execute(Model model) {
	Map<String, Object> map = model.asMap();
	HttpServletRequest request = (HttpServletRequest)map.get("request");
	MemberDto dto = new MemberDto();
	dto.setId((String)request.getSession().getAttribute("id"));
	dto.setPasswd(request.getParameter("passwd"));
	dto.setPhone_number(request.getParameter("phone_number"));
	dto.setEmail(request.getParameter("email"));
	System.out.println(dto.getEmail());
	System.out.println(dto.getPhone_number());
	int result = dao.modifyMember(dto);
	model.addAttribute("result", result);
		return "member/memberModifyPro";
	}
}
