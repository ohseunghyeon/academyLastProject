package com.first.lastproject.command.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.first.lastproject.dao.MemberDao;
import com.first.lastproject.dao.MemberDaoImpl;

@Service("noMemberLoginProCommand")
public class NoMemberLoginProCommand implements MemberCommand {

	@Autowired
	MemberDao dao;
	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("id", "nomember");
		map2.put("passwd", "nomember");
		int result = dao.checkMember(map2);
		
		System.out.println("비회원 로그인 결과 " + result);
		if(result == 1) {
			request.getSession().setAttribute("id", "nomember");
			model.addAttribute("result", result);
		}
		return "redirect:/seatList";
	}
}
