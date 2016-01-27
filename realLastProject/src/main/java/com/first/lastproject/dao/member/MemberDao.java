package com.first.lastproject.dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.first.lastproject.dto.MemberDto;

public class MemberDao implements InterfaceMemberDao {
DataSource dataSource;
	
	private static MemberDao instance;
	
	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	
	private MemberDao() {
		try {
			// Servers/context.xml에 정의한 커넥션 풀을 가져와서 쓰겠다.
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public int addMember(MemberDto dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			con = dataSource.getConnection();
			String sql = "INSERT INTO p_user VALUES (?,?,500,?,?,0,0)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPasswd());
			pstmt.setString(3, dto.getPhone_number());
			pstmt.setString(4, dto.getEmail());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}


	@Override
	public int checkmember(String id, String passwd) {
		 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			con = dataSource.getConnection(); 
			String sql = "SELECT * FROM p_user WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
	
			if(rs.next()) {
				if(passwd.equals(rs.getString("passwd"))) {
					result = 1;
				} else {
					result = -1;
				}
			} else {
				result = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public MemberDto getMember(String id) {
		MemberDto dto = new MemberDto();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT * FROM p_user WHERE ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setPhone_number(rs.getString("phone_number"));
				dto.setEmail(rs.getString("email"));
				dto.setMileage(rs.getInt("mileage"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		return dto;
	}

	@Override
	public int modifyMember(MemberDto dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			con = dataSource.getConnection();
			String sql = "UPDATE p_user SET passwd = ?, phone_number = ?, email= ? WHERE id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getPasswd());
			pstmt.setString(2, dto.getPhone_number());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getId());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return result;
	}

}
