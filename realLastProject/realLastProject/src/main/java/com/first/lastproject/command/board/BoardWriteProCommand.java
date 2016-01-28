package com.first.lastproject.command.board;

import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.board.BoardDao;
import com.first.lastproject.dao.board.InterfaceBoardDao;
import com.first.lastproject.dto.BoardDto;

public class BoardWriteProCommand implements BoardCommand {

	@Override
	public String execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		BoardDto dto = new BoardDto();
		dto.setWriter(request.getParameter("writer"));
		dto.setEmail(request.getParameter("email"));
		dto.setSubject(request.getParameter("subject"));
		dto.setContent(request.getParameter("content"));
		dto.setPasswd(request.getParameter("passwd"));
		dto.setNum(Integer.parseInt(request.getParameter("num")));
		dto.setRef(Integer.parseInt(request.getParameter("ref")));
		dto.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		dto.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		dto.setReg_date(new Timestamp(System.currentTimeMillis()));
		dto.setIp(request.getRemoteAddr());
		
		InterfaceBoardDao dao = BoardDao.getInstance();
		int result = dao.writeArticle(dto);
		
		
		model.addAttribute("result", result);
		
		return "board/writePro";
	}

}
