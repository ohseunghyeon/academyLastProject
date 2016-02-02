package com.first.lastproject.command.stock;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.ingredient.IngredientDao;
import com.first.lastproject.dao.ingredient.InterfaceIngredientDao;


public class StockIngredientModifyProCommand implements StockCommand {

	@Override
	public String execute(Model model) {
		
		Map<String, Object> map = model.asMap(); //model 을 Map 으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int ingredient_code = Integer.parseInt(request.getParameter("ingredient_code"));
		int ingre_num = Integer.parseInt(request.getParameter("ingre_num"));
		
		InterfaceIngredientDao dao = IngredientDao.getInstance();
		int result = dao.modifyIngredient(ingredient_code, ingre_num);
		
		model.addAttribute("ingredientModifyResult", result);

		return "host/stock/ingredientModifyPro";
	}
}
