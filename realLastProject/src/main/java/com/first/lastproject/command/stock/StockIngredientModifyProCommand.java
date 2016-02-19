package com.first.lastproject.command.stock;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.first.lastproject.dao.IngredientDao;

@Service("stockIngredientModifyProCommand")
public class StockIngredientModifyProCommand implements StockCommand {

	@Autowired
	IngredientDao dao;
	@Override
	public String execute(Model model) {
		
		Map<String, Object> map = model.asMap(); //model 을 Map 으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int ingredient_code = Integer.parseInt(request.getParameter("ingredient_code"));
		int ingre_num = Integer.parseInt(request.getParameter("ingre_num"));
		
		//IngredientDao dao = IngredientDaoImpl.getInstance();
		//int result = dao.modifyIngredient(ingredient_code, ingre_num);
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		map2.put("ingredient_code", ingredient_code);
		map2.put("ingre_num", ingre_num);
		int result = dao.modifyIngredient(map2);
		model.addAttribute("ingredientModifyResult", result);

		return "host/stock/ingredientModifyPro";
	}
}
