package com.first.lastproject.dao.food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.first.lastproject.dto.FoodDto;


public class FoodDao implements InterfaceFoodDao {
	DataSource dataSource;

	private static FoodDao instance;

	public static FoodDao getInstance() {
		if (instance == null) {
			instance = new FoodDao();
		}
		return instance;
	}

	private FoodDao() {
		try {
			// Servers/context.xml에 정의한 커넥션 풀을 가져와서 쓰겠다.
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<FoodDto> listGoods() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<FoodDto> goodsList = null;

		try {
			con = dataSource.getConnection(); // 컨넥션풀에서 connection객체 가져온다.
			String sql = "SELECT * FROM p_food";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (goodsList == null) {
					goodsList = new ArrayList<FoodDto>();
				}
				FoodDto goods = new FoodDto();
				goods.setFood_code(rs.getInt(1));
				goods.setFood_name(rs.getString(2));
				goods.setPrice(rs.getInt(3));
				goods.setFood_num(rs.getInt(4));
				goodsList.add(goods);
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
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return goodsList;
	}

	@Override
	public List<FoodDto> getStockDessert() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<FoodDto> goodsList = null;

		try {

			con = dataSource.getConnection(); // 컨넥션풀에서 connection객체 가져온다.
			String sql = "SELECT * FROM p_food WHERE food_num >= 0";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				if (goodsList == null) {
					goodsList = new ArrayList<FoodDto>();
				}

				FoodDto goods = new FoodDto();
				goods.setFood_code(rs.getInt(1));
				goods.setFood_name(rs.getString(2));
				goods.setPrice(rs.getInt(3));
				goods.setFood_num(rs.getInt(4));
				goodsList.add(goods);
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
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return goodsList;
	}

	public int modifyStockFood(int food_code, int food_num) {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection();
			String sql = "UPDATE p_food SET food_num=? WHERE food_code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, food_num);
			pstmt.setInt(2, food_code);

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return count;

	}

	@Override
	public FoodDto getFood(int food_code) {
		FoodDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection(); //컨넥션풀에서 connection객체 가져온다.
			String sql = "select * from p_food where food_code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, food_code);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if (dto == null) {
					dto = new FoodDto();
				}
			dto.setFood_code(rs.getInt(1));
			dto.setFood_name(rs.getString(2));
			dto.setPrice(rs.getInt(3));
			dto.setFood_num(4);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	
}
