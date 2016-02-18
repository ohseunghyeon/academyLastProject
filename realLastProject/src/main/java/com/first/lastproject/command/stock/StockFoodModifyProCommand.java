package com.first.lastproject.command.stock;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.FoodDao;
import com.first.lastproject.dao.FoodDaoImpl;

public class StockFoodModifyProCommand implements StockCommand {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap(); //model 을 Map 으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int food_code = Integer.parseInt(request.getParameter("food_code"));
		int food_num = Integer.parseInt(request.getParameter("food_num"));
		
		FoodDao dao = FoodDaoImpl.getInstance();
		int result = dao.modifyStockFood(food_code, food_num);
		
		model.addAttribute("foodModifyResult", result);
		return "host/stock/foodModifyPro";
	
	}


}
