package com.first.lastproject.command.stock;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.ingredient.IngredientDao;
import com.first.lastproject.dto.IngredientDto;



public class StockListCommand implements StockCommand {

	@Override
	public String execute(Model model) {
		
		
		IngredientDao dao = IngredientDao.getInstance();
		List<IngredientDto>ingredientList = dao.listingredient();
		
		model.addAttribute("ingredientList",ingredientList);
		
		
		return "/p_ingredient/ingredient";
	}

}
