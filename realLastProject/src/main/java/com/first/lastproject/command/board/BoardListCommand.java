package com.first.lastproject.command.board;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.board.BoardDao;
import com.first.lastproject.dao.board.InterfaceBoardDao;
import com.first.lastproject.dto.BoardDto;

public class BoardListCommand implements BoardCommand {
	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int pageSize = 10;	//한 페이지당 출력할 글 수
		int pageBlock = 3; 	//출력할 페이지 개수
		
		int count = 0;	//글 개수
		int start = 0;	//현재 페이지 시작
		int end = 0;	//현재 페이지 끗
		int number = 0;	//출력할 글 번호
		String pageNum = null;	//현재 페이지
		int currentPage = 0;	//현재 페이지
		
		int pageCount = 0;	//페이지 개수
		int startPage = 0;	//시작 페이지
		int endPage = 0;	//끝 페이지
		
		InterfaceBoardDao dao = BoardDao.getInstance();
		//글개수 구하기
		count = dao.getCount();
		
		pageNum = request.getParameter("pageNum");
		
		if (pageNum == null) {
			pageNum = "1";
		}
		
		//마지막 페이지에서 1개 남은 경우 에러 안 나게 처리. pageNum=6이지만 1개 삭제 후 페이지는 5페이지로 이동
		currentPage = Integer.parseInt(pageNum);
		pageCount = (count / pageSize) + (count % pageSize > 0 ? 1 : 0);
		if (currentPage > pageCount) currentPage = pageCount;
		
		start = (currentPage - 1) * pageSize + 1; // (5-1) * 10 + 1 = 41
		end = start + pageSize - 1;	//41 + 10 - 1 = 50
		if (end > count) end = count;
		
		number = count - (currentPage - 1) * pageSize;
		if (count > 0) {
			ArrayList<BoardDto> dtos = dao.getArticles(start, end);
			model.addAttribute("list", dtos);
		}
		
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		// (15 / 10) * 10 + 1 = 11
		if (currentPage % pageBlock == 0) startPage -= pageBlock;
		
		endPage = startPage + pageBlock - 1;
		// 11 + 10 - 1 = 20
		if (endPage > pageCount) endPage = pageCount;
		
		model.addAttribute("count", count);
		model.addAttribute("number", number);
		model.addAttribute("pageNum", pageNum);
		
		if (count > 0) {
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("pageCount", pageCount);
			model.addAttribute("pageBlock", pageBlock);
		}
		
		
		return "board/list";
	}
}
