package com.first.lastproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.first.lastproject.dto.FoodDto;

@Repository
public class FoodDaoImpl implements FoodDao {
	DataSource dataSource;

	@Autowired
	private SqlSession sqlSession;
	/*
	private static FoodDaoImpl instance;

	public static FoodDaoImpl getInstance() {
		if (instance == null) {
			instance = new FoodDaoImpl();
		}
		return instance;
	}

	private FoodDaoImpl() {
		try {
			// Servers/context.xml에 정의한 커넥션 풀을 가져와서 쓰겠다.
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	@Override
	public List<FoodDto> listGoods() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
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
				goods.setFood_code(rs.getInt("food_code"));
				goods.setFood_name(rs.getString("food_name"));
				goods.setPrice(rs.getInt("price"));
				goods.setFood_num(rs.getInt("food_num"));
				goods.setImage_name(rs.getString("image_name"));
				goods.setSold_out(0); // 매진 아님
				if (rs.getInt("food_num") < 0) { // 생산품의 경우
					//음료만 지나오는 거 확인.
					sql = "SELECT ingre_num FROM p_food f, p_recipe r, p_ingredient i where f.FOOD_CODE = r.FOOD_CODE and r.INGREDIENT_CODE = i.INGREDIENT_CODE and f.food_code = ? order by f.food_code";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, goods.getFood_code());
					rs2 = pstmt.executeQuery();
					while (rs2.next()) {						
						/* if (rs2.getInt("ingre_num") == 1) { 주의 !!! 원래는 == 0이 와야한다. 재료가 0개 미만이 될 수 없으니까. 근데 매진된 상품의 구매를 막는 로직이 아직 없어 임시로 도입한다! */
						if (rs2.getInt("ingre_num") < 1) {
							goods.setSold_out(1);
						}
					}
				} else { // 이미 생산된 디저트 종류의 경우
					if (goods.getFood_num() == 0) { // 수량이 없는 경우
						goods.setSold_out(1); // 매진
					}
				}
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
	public ArrayList<FoodDto> getStockDessert() {
		//Connection con = null;
		//PreparedStatement pstmt = null;
		//ResultSet rs = null;
		ArrayList<FoodDto> goodsList = null;
		FoodDao dao = this.sqlSession.getMapper(FoodDao.class);
		goodsList= dao.getStockDessert();
		return goodsList;
	/*	

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
		return goodsList; */
	}

	public int modifyStockFood(Map<String, Integer> map) {
		int count = 0;
		//Connection con = null;
		//PreparedStatement pstmt = null;
		FoodDao dao = this.sqlSession.getMapper(FoodDao.class);
		count= dao.modifyStockFood(map);
		return count;
/*		
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
		return count;*/

	}

	@Override
	public FoodDto getFood(int food_code) {
		FoodDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection(); // 컨넥션풀에서 connection객체 가져온다.
			String sql = "select * from p_food where food_code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, food_code);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println(rs.getString("food_name") + rs.getInt("food_num"));
				if (dto == null) {
					dto = new FoodDto();
				}
				dto.setFood_code(rs.getInt("food_code"));
				dto.setFood_name(rs.getString("food_name"));
				dto.setPrice(rs.getInt("price"));
				dto.setFood_num(rs.getInt("food_num"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}

	@Override
	public int reduceFoodNum(int food_code) {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "UPDATE p_food SET food_num = food_num - 1 WHERE food_code = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, food_code);
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
}
