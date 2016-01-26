package com.first.lastproject.dao.goods;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.first.lastproject.dto.GoodsDto;

public class GoodsDao implements InterfaceGoodsDao {
	DataSource dataSource;
	
	private static GoodsDao instance;
	
	public static GoodsDao getInstance() {
		if (instance == null) {
			instance = new GoodsDao();
		}
		return instance;
	}
	
	private GoodsDao() {
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
