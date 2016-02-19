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

@Service("memberFindProCommand")
public class MemberFindProCommand implements MemberCommand {
	@Autowired
	MemberDao dao;
	@Override
	public String execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String email = request.getParameter("email");
		String id = request.getParameter("id");
	      
		int idorpass = Integer.parseInt(request.getParameter("idorpass"));
		System.out.println(email);
		System.out.println(idorpass);
		int result = 0;
		MemberDto dto = new MemberDto();
		dto = dao.getId(email);
		if(dto != null) {
			model.addAttribute("result", 1);
			model.addAttribute("dto", dto);
			model.addAttribute("idorpass", idorpass);
			return "member/memberFindPro";
		} else {
			model.addAttribute("result", 0);
			return "member/memberFindPro";
		}
		
		
	}

}
