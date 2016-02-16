package com.first.lastproject.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.member.InterfaceMemberDao;
import com.first.lastproject.dao.member.MemberDao;

public class NoMemberLoginProCommand implements MemberCommand {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		InterfaceMemberDao dao = MemberDao.getInstance();
		int result = dao.checkMember("nomember", "nomember");
		
		System.out.println("비회원 로그인 결과 " + result);
		if(result == 1) {
			request.getSession().setAttribute("id", "nomember");
			model.addAttribute("result", result);
		}
		return "redirect:/seatList";
	}
}
