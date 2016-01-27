package com.first.lastproject.dao.board;

import java.util.ArrayList;

import com.first.lastproject.dto.BoardDto;

public interface InterfaceBoardDao {
//board 게시판
	public int getCount();
	public int writeArticle(BoardDto dto);
	public ArrayList<BoardDto> getArticles(int start, int end);
	public BoardDto getArticle(int num);
	public int addCount(int num);
	public int check(int num , String passwd);
	public int deleteArticle(int num);
	public int updateArticle(BoardDto dto);
}
