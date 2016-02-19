package com.first.lastproject.dao;

import java.util.ArrayList;
import java.util.Map;

import com.first.lastproject.dto.BoardDto;

public interface BoardDao {
//board 게시판
	public int getCount();
	public int getMaxNum();
	public void updateReply(BoardDto dto);
	public int getSeachSubjectCount(String subject);
	public int getSeachWriterCount(String writer);
	public int writeArticle(BoardDto dto);
	public ArrayList<BoardDto> getArticles(Map<String, Integer> map);
	public BoardDto getArticle(int num);
	public int addCount(int num);
	public int check(Map<String, Object> map);
	public int checkReply(BoardDto dto);
	public int deleteArticle(int num);
	public int updateArticle(BoardDto dto);
	public ArrayList<BoardDto> searchWriter(String searchinput);
	public ArrayList<BoardDto> searchSubject(String searchinput);
	
}
