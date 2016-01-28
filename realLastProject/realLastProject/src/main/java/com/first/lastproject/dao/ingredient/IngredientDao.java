package com.first.lastproject.dao.ingredient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.first.lastproject.dto.IngredientDto;


public class IngredientDao implements InterfaceIngredientDao {
	DataSource dataSource;
	
	private static IngredientDao instance;
	
	public static IngredientDao getInstance() {
		if (instance == null) {
			instance = new IngredientDao();
		}
		return instance;
	}
	
	private IngredientDao() {
		try {
			// Servers/context.xml에 정의한 커넥션 풀을 가져와서 쓰겠다.
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int getIngredient() {
		return 0;
	}
	public List<IngredientDto> listingredient() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<IngredientDto> ingredientList = null;
		IngredientDto dto= null;
		try {
			con = dataSource.getConnection();
			String sql = "select ingredient,ingre_num from p_ingredient";
			pstmt = con.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			
			while(rs.next()) {
				if(ingredientList == null) {
					ingredientList = new ArrayList<IngredientDto>();
				}
				dto = new IngredientDto();
				dto.setIngredient(rs.getString("ingredient"));
				dto.setIngre_num(rs.getInt("ingre_num"));
			
				ingredientList.add(dto);
		
			}
		}  catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(SQLException ex) {
				ex.printStackTrace(); }
		}
		return ingredientList;
	}

}
