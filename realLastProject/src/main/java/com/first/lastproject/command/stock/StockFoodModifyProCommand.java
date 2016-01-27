package com.first.lastproject.command.stock;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.food.FoodDao;
import com.first.lastproject.dao.food.InterfaceFoodDao;


import com.first.lastproject.dto.GoodsDto;


public class StockFoodModifyProCommand implements StockCommand {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap(); //model 을 Map 으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		GoodsDto dto = new GoodsDto();
		
		dto.setFood_code(Integer.parseInt(request.getParameter("food_code")));
		dto.setFood_num(Integer.parseInt(request.getParameter("food_num")));
		
		
		InterfaceFoodDao dao = FoodDao.getInstance();
		int result = dao.modifyFood(dto,Integer.parseInt(request.getParameter("food_code")));
		model.addAttribute("result", result);

		return "/p_ingredient/modifyPro";
	
	}


}
