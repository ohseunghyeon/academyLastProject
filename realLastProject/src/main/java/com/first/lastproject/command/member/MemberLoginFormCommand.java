package com.first.lastproject.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service("memberLoginFormCommand")
public class MemberLoginFormCommand implements MemberCommand {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		int result = Integer.parseInt(request.getParameter("result"));
		request.setAttribute("result", result); 
		return "member/memberLoginForm";
	}

}
