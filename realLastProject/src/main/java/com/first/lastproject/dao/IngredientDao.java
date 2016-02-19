package com.first.lastproject.dao;

import java.util.List;
import java.util.Map;

import com.first.lastproject.dto.IngredientDto;

public interface IngredientDao {

//ingredient 재료
	public int getIngredient();
	public List<IngredientDto> listIngredient();
	public int modifyIngredient(Map<String, Integer> map);
	public int reduceIngredient(int food_code);
}
