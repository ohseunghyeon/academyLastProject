package com.first.lastproject.command.stock;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.ingredient.IngredientDao;
import com.first.lastproject.dao.ingredient.InterfaceIngredientDao;
import com.first.lastproject.dto.IngredientDto;


public class StockModifyProCommand implements StockCommand {

	@Override
	public String execute(Model model) {
		
		Map<String, Object> map = model.asMap(); //model 을 Map 으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		IngredientDto dto = new IngredientDto();
		
		dto.setIngredient_code(Integer.parseInt(request.getParameter("ingredient_code")));
		dto.setIngre_num(Integer.parseInt(request.getParameter("ingre_num")));
		
		
		InterfaceIngredientDao dao = IngredientDao.getInstance();
		int result = dao.modifyingredient(dto,Integer.parseInt(request.getParameter("ingredient_code")));
		
		model.addAttribute("result", result);

		return "/p_ingredient/modifyPro";
	
	}

}
