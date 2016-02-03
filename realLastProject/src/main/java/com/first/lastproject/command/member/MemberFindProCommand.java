package com.first.lastproject.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.member.InterfaceMemberDao;
import com.first.lastproject.dao.member.MemberDao;
import com.first.lastproject.dto.MemberDto;

public class MemberFindProCommand implements MemberCommand {

	@Override
	public String execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String email = request.getParameter("email");
		String id = request.getParameter("id");
		int idorpass = Integer.parseInt(request.getParameter("idorpass"));
		System.out.println(email);
		System.out.println(id);
		System.out.println(idorpass);
		int result = 0;
		InterfaceMemberDao dao = MemberDao.getInstance();
		MemberDto dto = new MemberDto();
		if(idorpass == 0) {
		result = dao.findId(email);
		} else {
		result = dao.findPasswd(id,email);
		}
		System.out.println("result1 = " + result);
		if(result == 1) {
			if(idorpass == 0) {
			dto = dao.getId(email);
			model.addAttribute("result", result);
			model.addAttribute("dto", dto);
			model.addAttribute("idorpass", idorpass);
			} else if(idorpass == 1) {
			dto = dao.getPasswd(id, email);
			model.addAttribute("result", result);
			model.addAttribute("dto", dto);
			model.addAttribute("idorpass", idorpass);
			System.out.println("result2 = " + result);
			System.out.println("dto = " + dto);
			System.out.println("idorpass = " + idorpass);
			}
			return "member/memberFindPro";
		} else if(result == -1) {
			model.addAttribute("result", result);
			return "member/memberFindPro";
		} else {
			model.addAttribute("result", result);
			return "member/memberFindPro";
		}
		
		
	}

}
