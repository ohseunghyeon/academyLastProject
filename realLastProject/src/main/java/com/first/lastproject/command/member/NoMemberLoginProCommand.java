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
		int memCode = 0;
		String nomember = "nomember";
		InterfaceMemberDao dao = MemberDao.getInstance();
		int result = dao.checkmember(nomember, nomember);
		System.out.println(result);
		if(result == 1) {
			request.getSession().setAttribute("id", nomember);
			model.addAttribute("result", result);
			model.addAttribute("memCode", memCode);
		}
		return "redirect:/seatList";
	}
}
