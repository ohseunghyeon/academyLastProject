package com.first.lastproject.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.member.InterfaceMemberDao;
import com.first.lastproject.dao.member.MemberDao;

public class HostLoginProCommand implements MemberCommand {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String id = "host";
		String passwd = request.getParameter("passwd");
		int memCode = Integer.parseInt(request.getParameter("memCode"));
	
		InterfaceMemberDao dao = MemberDao.getInstance();
		int result = dao.checkmember(id, passwd);
		if(result == 1) {
			request.getSession().setAttribute("id", id);
			memCode = 2;
			model.addAttribute("result", result);
			model.addAttribute("memCode", memCode);
			return "redirect:/seatList";

		} else {
			model.addAttribute("result", result);
			return "member/hostLoginForm";
		}
		
	}
		

}
