package com.first.lastproject.dao.board;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import spring.mvc.board.dto.BDto;

public class BDao implements BoardDao {
	DataSource dataSource;
	
	private static BDao instance;
	
	public static BDao getInstance() {
		if (instance == null) {
			instance = new BDao();
		}
		return instance;
	}
	
	private BDao() {
		try {
			// Servers/context.xml에 정의한 커넥션 풀을 가져와서 쓰겠다.
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getCount() {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "select count(*) from mvc_board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
		return count;
	}

	@Override
	public ArrayList<BDto> getArticles(int start, int end) {
		ArrayList<BDto> dtos = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			/*String sql = "select num, writer, email, subject, passwd,";
			sql += "reg_date, ref, re_step, re_level, content, ip, readcount, r ";
			sql += "from (select num, writer, email, subject, passwd, reg_date, ref, re_step,";
			sql += "re_level, content, ip, readcount, rownum r from ";
			sql += "(select num, writer, email, subject, passwd, reg_date, ref, re_step,";
			sql += "re_level, content, ip, readcount from mvc_board order by ref desc, re_step asc) ";
			sql += "order by ref desc, re_step asc) where r >= ? and r <= ?";*/
			
			String sql = "select * from "
					+ "(select num, writer, email, subject, passwd, reg_date, ref, re_step,"
					+ "re_level, content, ip, readcount, rownum rnum from "
					+ "(select * from mvc_board order by ref desc, re_step asc)) where rnum >= ? and rnum <= ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dtos = new ArrayList<BDto> (end - start + 1);
				
				do {
					BDto dto = new BDto();
					dto.setNum(rs.getInt("num"));
					dto.setWriter(rs.getString("writer"));
					dto.setEmail(rs.getString("email"));
					dto.setSubject(rs.getString("subject"));
					dto.setPasswd(rs.getString("passwd"));
					dto.setReg_date(rs.getTimestamp("reg_date"));
					dto.setReadcount(rs.getInt("readcount"));
					dto.setRef(rs.getInt("ref"));
					dto.setRe_step(rs.getInt("re_step"));
					dto.setRe_level(rs.getInt("re_level"));
					dto.setContent(rs.getString("content"));
					dto.setIp(rs.getString("ip"));
					dtos.add(dto);
				} while(rs.next());
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return dtos;
	}

	@Override
	public int insertArticle(BDto dto) {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			int num = dto.getNum();
			int ref = dto.getRef();
			int re_step = dto.getRe_step();
			int re_level = dto.getRe_level();
			String sql = null;
			if (num == 0) {	//제목글인 경우
				sql = "select max(num) from mvc_board";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					// 글이 있는 경우
					ref = rs.getInt(1) + 1; //그룹화 아이디 = 글번호 최대값 + 1;
				} else {
					// 글이 없는 경우
					ref = 1;
				}
				re_step = 0;
				re_level = 0;
			} else {
				//답변글인 경우
				sql = "update mvc_board set re_step = re_step + 1 where ref=? and re_step>?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				pstmt.executeUpdate();
				
				re_step++;
				re_level++;
			}
			
			
			
			sql = "insert into mvc_board (num, writer, email, subject, passwd, reg_date, "
					+ "ref, re_step, re_level, content, ip) values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt.close();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getPasswd());
			pstmt.setTimestamp(5, dto.getReg_date());
			pstmt.setInt(6, ref);
			pstmt.setInt(7, re_step);
			pstmt.setInt(8, re_level);
			pstmt.setString(9, dto.getContent());
			pstmt.setString(10, dto.getIp());
			count = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	@Override
	public BDto getArticle(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BDto dto = null;
		try {
			con = dataSource.getConnection();
			String sql = "select * from mvc_board where num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new BDto();
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setRef(rs.getInt("ref"));
				dto.setRe_step(rs.getInt("re_step"));
				dto.setRe_level(rs.getInt("re_level"));
				dto.setEmail(rs.getString("email"));
				dto.setReg_date(rs.getTimestamp("reg_date"));
				dto.setIp(rs.getString("ip"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	@Override
	public int addCount(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			con = dataSource.getConnection();
			String sql = "update mvc_board set readcount = readcount + 1 where num = ?";
			pstmt = con.prepareStatement(sql);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
}
