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
		InterfaceMemberDao dao = MemberDao.getInstance();
		int result = dao.checkmember(id, passwd);
		model.addAttribute("result", result);
		if(result == 1) {
			request.getSession().setAttribute("id", id);
			return "member/memberMain";
		} else if(result == -1) {
			return "member/memberLoginForm";
		} else {
			return "member/memberLoginForm";
		}
		
	}
}
