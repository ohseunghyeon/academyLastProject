package com.first.lastproject.dao;

import java.util.List;
import com.first.lastproject.dto.FoodDto;


public interface FoodDao {

	//goods 음식
	public List<FoodDto> listGoods();
	public List<FoodDto> getStockDessert();
	public int modifyStockFood(int food_code, int food_num);
	public FoodDto getFood(int food_code);
	public int reduceFoodNum(int food_code);
}
