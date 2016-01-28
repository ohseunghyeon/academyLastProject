package com.first.lastproject.command.stock;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.food.FoodDao;
import com.first.lastproject.dao.ingredient.IngredientDao;
import com.first.lastproject.dto.GoodsDto;
import com.first.lastproject.dto.IngredientDto;



public class StockListCommand implements StockCommand {

	@Override
	public String execute(Model model) {
		
		
		IngredientDao dao = IngredientDao.getInstance();
		FoodDao daofood = FoodDao.getInstance();
		List<IngredientDto>ingredientList = dao.listingredient();
		List<GoodsDto>goodslist=daofood.goods();
		
		model.addAttribute("ingredientList",ingredientList);
		model.addAttribute("goodslist",goodslist);
		
		
		return "/p_ingredient/ingredient";
	}

}
