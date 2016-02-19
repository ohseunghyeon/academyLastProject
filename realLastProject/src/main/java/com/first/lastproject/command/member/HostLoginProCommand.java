package com.first.lastproject.command.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.first.lastproject.dao.MemberDao;
import com.first.lastproject.dao.MemberDaoImpl;

@Service("hostLoginProCommand")
public class HostLoginProCommand implements MemberCommand {

	@Autowired
	MemberDao dao;
	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String id = "host";
		String passwd = request.getParameter("passwd");
		int memCode = Integer.parseInt(request.getParameter("memCode"));
		Map <String, String> map2 = new HashMap<String, String>();
		map2.put("id", id);
		map2.put("passwd", passwd);
		int result = dao.checkMember(map2);
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
