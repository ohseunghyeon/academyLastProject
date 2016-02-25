package com.first.lastproject.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.first.lastproject.dto.FoodDto;


public interface FoodDao {

	//goods 음식
	public List<FoodDto> listGoods();
	public List<Integer> getIngreNum(int food_code);
	public ArrayList<FoodDto> getStockDessert();
	public int modifyStockFood(Map<String, Integer> map);
	public FoodDto getFood(int food_code);
	public int reduceFoodNum(int food_code);
	
}
