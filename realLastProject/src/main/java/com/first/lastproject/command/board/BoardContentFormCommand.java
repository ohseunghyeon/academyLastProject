package com.first.lastproject.command.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.board.BoardDao;
import com.first.lastproject.dao.board.InterfaceBoardDao;
import com.first.lastproject.dto.BoardDto;


public class BoardContentFormCommand implements BoardCommand {

	@Override
	public String execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int num = Integer.parseInt(request.getParameter("num"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		int number = Integer.parseInt(request.getParameter("number"));
		
		InterfaceBoardDao dao = BoardDao.getInstance();
		BoardDto dto = dao.getArticle(num);
		
		// 내가 쓴 글이 아닌 것만 조회수 증가
		if (!request.getRemoteAddr().equals(dto.getIp())) {
			int result = dao.addCount(num);
			model.addAttribute("addReadCountResult", result);
			System.out.println(result);
		}
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("number", number);
		model.addAttribute("dto", dto);
		
		
		return "board/contentForm";
	}

}
