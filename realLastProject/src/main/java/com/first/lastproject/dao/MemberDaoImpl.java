package com.first.lastproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;


import com.first.lastproject.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {
	DataSource dataSource;

	@Autowired
	private SqlSession sqlSession;
	/*
	private static MemberDaoImpl instance;

	public static MemberDaoImpl getInstance() {
		if (instance == null) {
			instance = new MemberDaoImpl();
		}
		return instance;
	}

	private MemberDaoImpl() {
		try {
			// Servers/context.xml에 정의한 커넥션 풀을 가져와서 쓰겠다.
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/


	@Override
	public int addMember(MemberDto dto) {
		
		int result = 0;
		MemberDao memberDao = this.sqlSession.getMapper(MemberDao.class);
		result = memberDao.addMember(dto);
		
			/*String sql = "INSERT INTO p_user VALUES (?,?,0,?,?,0,0)"; // 아이디,
																		// 비밀번호,
																		// 마일리지,
																		// 전번,
																		// 이메일,
																		// 게스트,
																		// 쿠폰
*/		
		return result;
	}

	public int check(String id) {
		int result = 0;
		MemberDao memberDao = this.sqlSession.getMapper(MemberDao.class);
		result = memberDao.check(id);
			//String sql = "SELECT id FROM p_user WHERE id=?";
			
		return result;
	}
	
	@Override
	public int findId(String email) {
		
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT email FROM p_user WHERE email= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (email.equals(rs.getString("email"))) {
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
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int findPasswd(String id, String email) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT id,email FROM p_user WHERE id = ? AND email = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (id.equals(rs.getString("id")) && email.equals(rs.getString("email"))) {
					result = 1;
				} else {
					result = -1;
				}
			} 
			System.out.println("resulta = " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int checkMember(Map<String, String> map2) { //아이디/비밀번호 일치 여부 판단

		int result = 0;
		int idCheck = this.sqlSession.selectOne("com.first.lastproject.dao.MemberDao.checkMember", map2);
		if(idCheck == 1) {
			result = 1;
		} else {
			result = 0;
		}
			//String sql = "SELECT * FROM p_user WHERE id = ?";//p_user 테이블에서 id에 일치하는 데이터 찾음.
		
		return result;
	}
	

	@Override
	public MemberDto getMember(String id) {//회원의 정보를 가져옴.
		MemberDto dto = new MemberDto();
		MemberDao dao = this.sqlSession.getMapper(MemberDao.class);
		dto=dao.getMember(id);
		return dto;
		/*
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT * FROM p_user WHERE ID = ?";//p_user 테이블에서 id와 일치하는 데이터 찾음.
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {//rs에 다음 데이터가 있는 한, dto에 각 데이터를 입력함.
				dto.setId(rs.getString("id"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setPhone_number(rs.getString("phone_number"));
				dto.setEmail(rs.getString("email"));
				dto.setMileage(rs.getInt("mileage"));
				dto.setGet_coupon(rs.getInt("get_coupon"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return dto; */
	
			//String sql = "SELECT * FROM p_user WHERE ID = ?";//p_user 테이블에서 id와 일치하는 데이터 찾음.
	}
	
	public MemberDto getId(String email) {
		MemberDto dto = new MemberDto();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT id FROM p_user WHERE email = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setId(rs.getString("id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return dto;
	}
	
	public MemberDto getPasswd(String id, String email) {
		MemberDto dto = new MemberDto();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT passwd FROM p_user WHERE id = ? AND email = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setPasswd(rs.getString("passwd"));	
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
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
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return result;
	}

	public int getCoupons(String id) {
		int count = 0;
		MemberDao dao = this.sqlSession.getMapper(MemberDao.class);
		count =dao.getCoupons(id);
		return count;
		
	}
	public int makeCoupon(String id) {
		
		//Connection con = null;
		//PreparedStatement pstmt = null;
		int count = 0;
		MemberDao dao = this.sqlSession.getMapper(MemberDao.class);
		count = dao.makeCoupon(id);
		if(count ==1) {
			count= dao.getCoupons(id);
		}
		return count;

		/*
		try {
			con = dataSource.getConnection();
			String sql = "INSERT INTO p_coupon VALUES (seq_coupon_num.nextval,?,sysdate+180)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			count = pstmt.executeUpdate();
			if (count == 1) {
				sql = "UPDATE p_user SET get_coupon = 1 WHERE id = ?";
				pstmt.close();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				count = pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count; */
	}

	public int getCoupon(String id) {
		//Connection con = null;
		//PreparedStatement pstmt = null;
		//ResultSet rs = null;
		int coupon_code = 0;
		MemberDao dao = this.sqlSession.getMapper(MemberDao.class);
		coupon_code = dao.getCoupon(id);

		return coupon_code;
		/*
		try {
			con = dataSource.getConnection();
			String sql = "SELECT coupon_num FROM p_coupon WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				coupon_code = rs.getInt("coupon_num");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return coupon_code;*/
	}

	@Override
	public int addMileage(int food_code, String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		int result = 0;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT price FROM p_food WHERE food_code = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, food_code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				sql = "UPDATE p_user SET mileage = mileage + ? WHERE id = ?";
				pstmt2 = con.prepareStatement(sql);
				pstmt2.setInt(1, (int) Math.round((rs.getInt("price") * 0.05)));
				pstmt2.setString(2, id);
				result = pstmt2.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (pstmt2 != null)
					pstmt2.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int useMileage(String id, int mileage){
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			
			con = dataSource.getConnection();
			String sql = "UPDATE p_user SET mileage = mileage - ? WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mileage);
			pstmt.setString(2, id);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
}
