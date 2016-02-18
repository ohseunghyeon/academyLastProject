package com.first.lastproject.command.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.BoardDao;
import com.first.lastproject.dao.BoardDaoImpl;
import com.first.lastproject.dto.BoardDto;


public class BoardModifyViewCommand implements BoardCommand {

	@Override
	public String execute(Model model) {
		
		Map<String, Object> map = model.asMap(); 
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String passwd = request.getParameter("passwd");
		
		BoardDao dao = BoardDaoImpl.getInstance();
		int result = dao.check(num, passwd);
		
		if(result !=0) {
			BoardDto dto= dao.getArticle(num);
			
			model.addAttribute("dto", dto);
		} 
		model.addAttribute("result",result);
		model.addAttribute("num",num);
		model.addAttribute("pageNum",pageNum);

	
		return "board/boardModifyView";
	}

}
