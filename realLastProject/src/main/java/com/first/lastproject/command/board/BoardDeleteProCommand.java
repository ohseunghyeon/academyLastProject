package com.first.lastproject.command.board;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.first.lastproject.dao.BoardDao;


@Service("boardDeleteProCommand")
public class BoardDeleteProCommand implements BoardCommand {

	@Autowired
	BoardDao dao;
	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap(); 
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String passwd = request.getParameter("passwd");
		
		//BoardDao boardDao = BoardDaoImpl.getInstance();
		//int resultPasswd = dao.check(num, passwd);
		Map<String, Object> map2= new HashMap<String, Object>();
		map2.put("num", num);
		map2.put("passwd", passwd);
		
		int resultPasswd = dao.check(map2);
		
		
		
		//resultPasswd 가 1 이면 비밀번호 일치, 0이면 비밀번호 불일치.
		if(resultPasswd !=0) {
			int result = dao.deleteArticle(num);
			model.addAttribute("result", result);
		} 
		
		model.addAttribute("resultPasswd",resultPasswd);
		model.addAttribute("pageNum",pageNum);
		
		return "board/deletePro";
	}

}
