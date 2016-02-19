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

@Service("memberModifyViewCommand")
public class MemberModifyViewCommand implements MemberCommand {

	@Autowired
	MemberDao dao;
	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String id = (String)request.getSession().getAttribute("id");
		String passwd = request.getParameter("passwd");
		MemberDto dto = new MemberDto();
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("id", id);
		map2.put("passwd", passwd);
		int result = dao.checkMember(map2);
		if(result == 1) {
			dto = dao.getMember(id);
			model.addAttribute("dto", dto);
		}
		return "member/memberModifyView";
	}

}
