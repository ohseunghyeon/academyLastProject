package com.first.lastproject.command.board;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.first.lastproject.dao.BoardDao;
import com.first.lastproject.dto.BoardDto;

@Service("boardModifyViewCommand")
public class BoardModifyViewCommand implements BoardCommand {

	@Autowired
	BoardDao dao;
	@Override
	public String execute(Model model) {
		
		Map<String, Object> map = model.asMap(); 
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String passwd = request.getParameter("passwd");
		
		//BoardDao dao = BoardDaoImpl.getInstance();
		Map<String, Object> map2= new HashMap<String, Object>();
		map2.put("num", num);
		map2.put("passwd", passwd);
		int result = dao.check(map2);
		
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
