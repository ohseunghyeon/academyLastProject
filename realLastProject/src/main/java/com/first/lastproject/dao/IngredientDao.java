package com.first.lastproject.dao;

import java.util.List;

import com.first.lastproject.dto.IngredientDto;

public interface IngredientDao {

//ingredient 재료
	public int getIngredient();
	public List<IngredientDto> listIngredient();
	public int modifyIngredient(int ingredient_code, int ingre_num);
	public int reduceIngredient(int food_code);
}
