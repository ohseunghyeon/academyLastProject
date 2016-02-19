package com.first.lastproject.command.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.first.lastproject.dao.BoardDao;
import com.first.lastproject.dto.BoardDto;


@Service("boardModifyProCommand")
public class BoardModifyProCommand implements BoardCommand {

	@Autowired
	BoardDao dao;
	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap(); 
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String pageNum = request.getParameter("pageNum");
		BoardDto dto = new BoardDto();
		dto.setNum(Integer.parseInt(request.getParameter("num")));
		dto.setEmail(request.getParameter("email"));
		dto.setSubject(request.getParameter("subject"));
		dto.setContent(request.getParameter("content"));
		dto.setPasswd(request.getParameter("passwd"));

		
		//BoardDao dao = BoardDaoImpl.getInstance();
		int result = dao.updateArticle(dto);
		
		model.addAttribute("result",result);
		model.addAttribute("pageNum",pageNum);

		
		return "board/boardModifyPro";
	}

}
