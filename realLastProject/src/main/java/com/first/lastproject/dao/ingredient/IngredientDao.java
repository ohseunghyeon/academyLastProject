package com.first.lastproject.dao.ingredient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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

}
