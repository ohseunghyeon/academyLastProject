package com.first.lastproject.dto;

public class IngredientDto{
	private int ingredient_code;
	private String ingredient;
	private int ingre_num;
	
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	public int getIngre_num() {
		return ingre_num;
	}
	public void setIngre_num(int ingre_num) {
		this.ingre_num = ingre_num;
	}
	public int getIngredient_code() {
		return ingredient_code;
	}
	public void setIngredient_code(int ingredient_code) {
		this.ingredient_code = ingredient_code;
	}
	
}
