package com.first.lastproject.dao.food;

import java.util.List;

import com.first.lastproject.dto.GoodsDto;


public interface InterfaceFoodDao {

//goods 음식
	public List<GoodsDto> goods();
	public int modifyFood(GoodsDto dto,int food_code);
	public List<GoodsDto> getDessert();
}
