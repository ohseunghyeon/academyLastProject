package com.first.lastproject.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.member.InterfaceMemberDao;
import com.first.lastproject.dao.member.MemberDao;
import com.first.lastproject.dto.MemberDto;


public class MemberModifyViewCommand implements MemberCommand {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String id = (String)request.getSession().getAttribute("id");
		String passwd = request.getParameter("passwd");
		InterfaceMemberDao dao = MemberDao.getInstance();
		MemberDto dto = new MemberDto();
		int result = dao.checkmember(id, passwd);
		if(result == 1) {
			dto = dao.getMember(id);
			model.addAttribute("dto", dto);
		}
		return "member/memberModifyView";
	}

}
