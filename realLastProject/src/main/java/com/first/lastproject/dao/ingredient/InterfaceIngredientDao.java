package com.first.lastproject.dao.ingredient;

import java.util.List;

import com.first.lastproject.dto.IngredientDto;

public interface InterfaceIngredientDao {

//ingredient 재료
	public int getIngredient();
	public List<IngredientDto> listIngredient();
	public int modifyIngredient(int ingredient_code, int ingre_num);
	public int reduceIngredient(int food_code);
}
