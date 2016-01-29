package com.first.lastproject.dao.food;

import java.util.List;
import java.util.Map;

import com.first.lastproject.dto.FoodDto;


public interface InterfaceFoodDao {

	//goods 음식
	public List<FoodDto> listGoods();
	public List<FoodDto> getStockDessert();
	public int modifyStockFood(int food_code, int food_num);
	public FoodDto getFood(int food_code);
}
