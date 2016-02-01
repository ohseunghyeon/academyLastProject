package com.first.lastproject.command.goods;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.food.FoodDao;

public class GoodsShoppingBagCommand implements GoodsCommand {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int food_code = Integer.parseInt(request.getParameter("food_code"));
		
		model.addAttribute("foodDto", FoodDao.getInstance().getFood(food_code));
		return "guest/goods/shoppingBag";
	}

}
