package com.first.lastproject.command.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.first.lastproject.dao.MemberDao;
import com.first.lastproject.dao.MemberDaoImpl;
import com.first.lastproject.dto.MemberDto;

@Service("memberLoginProCommand")
public class MemberLoginProCommand implements MemberCommand {

	@Autowired
	MemberDao memberDao;
	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		Map<String,String> map2 = new HashMap<String,String>();
		map2.put("id", id);
		map2.put("passwd", passwd);
		int result = memberDao.checkMember(map2);
		if(result == 1) {
			request.getSession().setAttribute("id", id);
			MemberDto memberDto = memberDao.getMember(id);
			System.out.println(memberDto);
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
