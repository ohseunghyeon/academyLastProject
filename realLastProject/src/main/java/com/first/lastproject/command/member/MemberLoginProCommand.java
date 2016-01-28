package com.first.lastproject.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.member.InterfaceMemberDao;
import com.first.lastproject.dao.member.MemberDao;

public class MemberLoginProCommand implements MemberCommand {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		int memCode = Integer.parseInt(request.getParameter("memCode"));
		InterfaceMemberDao dao = MemberDao.getInstance();
		int result = dao.checkmember(id, passwd);
		if(result == 1) {
			request.getSession().setAttribute("id", id);
			model.addAttribute("result", result);
			memCode = 1;
			model.addAttribute("memCode", memCode);
			return "redirect:/seatList";

		} else if(result == -1) {
			model.addAttribute("result", result);
			return "member/memberLoginForm";
		} else {
			model.addAttribute("result", result);
			return "member/memberLoginForm";
		}
		
	}
}