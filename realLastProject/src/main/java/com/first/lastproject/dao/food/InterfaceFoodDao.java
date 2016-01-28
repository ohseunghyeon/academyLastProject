package com.first.lastproject.dao.food;

import java.util.List;

import com.first.lastproject.dto.GoodsDto;


public interface InterfaceFoodDao {

	//goods 음식
	public List<GoodsDto> listGoods();
	public List<GoodsDto> getStockDessert();
	public int modifyStockFood(int food_code, int food_num);
}
