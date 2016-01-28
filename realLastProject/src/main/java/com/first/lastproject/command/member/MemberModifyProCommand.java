package com.first.lastproject.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.member.InterfaceMemberDao;
import com.first.lastproject.dao.member.MemberDao;
import com.first.lastproject.dto.MemberDto;

public class MemberModifyProCommand implements MemberCommand {

	@Override
	public String execute(Model model) {
	Map<String, Object> map = model.asMap();
	HttpServletRequest request = (HttpServletRequest)map.get("request");
	MemberDto dto = new MemberDto();
	InterfaceMemberDao dao = MemberDao.getInstance();
	dto.setId((String)request.getSession().getAttribute("id"));
	dto.setPasswd(request.getParameter("passwd"));
	dto.setPhone_number("phone_number");
	dto.setEmail("email");
	int result = dao.modifyMember(dto);
	model.addAttribute("result", result);
		return "member/memberModifyPro";
	}
}
