package com.first.lastproject.dao.food;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.first.lastproject.dto.GoodsDto;

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
	public GoodsDto getGoods() {
		// TODO 자동 생성된 메소드 스텁
		return new GoodsDto();
	}

}
