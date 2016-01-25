package com.first.lastproject.command.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class BoardWriteFormCommand implements BCommand {

	@Override
	public String execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		// 제목글
		int num = 0;		//
		int ref = 1;		//그룹화 아이디
		int re_step = 0;	//
		int re_level = 0;	
		
		// 답변글
		if (request.getParameter("num") != null) {
			 num = Integer.parseInt(request.getParameter("num"));
			 ref = Integer.parseInt(request.getParameter("ref"));
			 re_step = Integer.parseInt(request.getParameter("re_step"));
			 re_level = Integer.parseInt(request.getParameter("re_level"));
		}
		
		model.addAttribute("num", num);
		model.addAttribute("ref", ref);
		model.addAttribute("re_step", re_step);
		model.addAttribute("re_level", re_level);
		
		return "board/writeForm";
	}

}
