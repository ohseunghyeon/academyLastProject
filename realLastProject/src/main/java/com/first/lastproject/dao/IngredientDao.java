package com.first.lastproject.dao;

import java.util.List;
import java.util.Map;

import com.first.lastproject.dto.IngredientDto;

public interface IngredientDao {

//ingredient 재료
	public int getIngredient();
	public List<IngredientDto> listIngredient();
	public int modifyIngredient(Map<String, Integer> map);
	
	//결제 부분에서 재료를 가져와서 삭제하는 부분
	public List<IngredientDto> getIngredientForFood(int food_code);
	public int reduceIngredient(int ingredient_code);
}
