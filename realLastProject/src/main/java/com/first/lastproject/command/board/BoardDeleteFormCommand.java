package com.first.lastproject.command.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.first.lastproject.dao.BoardDao;

@Service("boardDeleteFormCommand")
public class BoardDeleteFormCommand implements BoardCommand {

	@Autowired
	BoardDao dao;
	@Override
	public String execute(Model model) {
	
		Map<String, Object> map = model.asMap(); 
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		model.addAttribute("num", num);
		model.addAttribute("pageNum",pageNum);
		System.out.println(request.getSession().getAttribute("id"));
		if (request.getSession().getAttribute("id").equals("host")) { // 호스트에게 삭제 무소불위 권력을 주겠노라
			//BoardDao boardDao = BoardDaoImpl.getInstance();
			dao.deleteArticle(num);
			return "redirect:/boardList";
		}
		
		return "board/deleteForm" ;
	}

}
