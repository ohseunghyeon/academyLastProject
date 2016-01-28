package com.first.lastproject.command.goods;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.food.FoodDao;
import com.first.lastproject.dao.food.InterfaceFoodDao;
import com.first.lastproject.dto.FoodDto;

public class GoodsPayFormCommand implements GoodsCommand {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String[] shoppingBag = (String[]) request.getSession().getAttribute("shoppingBag");
		
		InterfaceFoodDao dao = FoodDao.getInstance();
		ArrayList<FoodDto> foodList = new ArrayList<FoodDto>();
		
		for(String food_code : shoppingBag) {
			FoodDto foodDto = dao.getFood(Integer.parseInt(food_code));
			foodList.add(foodDto);
		}
		
		model.addAttribute("foodList", foodList);
		
		return "guest/payment/paymentForm";
	}

}
