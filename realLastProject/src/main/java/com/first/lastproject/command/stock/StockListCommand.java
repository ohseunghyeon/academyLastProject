package com.first.lastproject.command.stock;

import java.util.List;

import org.springframework.ui.Model;

import com.first.lastproject.dao.food.FoodDao;
import com.first.lastproject.dao.food.InterfaceFoodDao;
import com.first.lastproject.dao.ingredient.IngredientDao;
import com.first.lastproject.dao.ingredient.InterfaceIngredientDao;
import com.first.lastproject.dto.FoodDto;
import com.first.lastproject.dto.IngredientDto;

public class StockListCommand implements StockCommand {

	@Override
	public String execute(Model model) {

		InterfaceIngredientDao dao = IngredientDao.getInstance();
		InterfaceFoodDao foodDao = FoodDao.getInstance();

		List<IngredientDto> ingredientList = dao.listIngredient();
		List<FoodDto> goodsList = foodDao.getStockDessert();

		model.addAttribute("ingredientList", ingredientList);
		model.addAttribute("goodsList", goodsList);

		return "host/stock/ingredient";
	}

}
