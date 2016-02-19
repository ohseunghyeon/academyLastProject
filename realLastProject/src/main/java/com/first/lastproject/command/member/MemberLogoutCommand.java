package com.first.lastproject.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service("memberLogoutCommand")
public class MemberLogoutCommand implements MemberCommand {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		request.getSession().invalidate();
		return "redirect:/index";
	}

}
