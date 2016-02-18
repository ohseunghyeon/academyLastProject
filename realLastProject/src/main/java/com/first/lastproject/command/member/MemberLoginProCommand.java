package com.first.lastproject.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.MemberDao;
import com.first.lastproject.dao.MemberDaoImpl;
import com.first.lastproject.dto.MemberDto;

public class MemberLoginProCommand implements MemberCommand {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		MemberDao memberDao = MemberDaoImpl.getInstance();
		int result = memberDao.checkMember(id, passwd);
		if(result == 1) {
			request.getSession().setAttribute("id", id);
			MemberDto memberDto = memberDao.getMember(id);
			request.getSession().setAttribute("mileage", memberDto.getMileage());
			request.getSession().setAttribute("coupon", memberDao.getCoupon(id));
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
