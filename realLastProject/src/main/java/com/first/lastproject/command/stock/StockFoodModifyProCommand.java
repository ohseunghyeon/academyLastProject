package com.first.lastproject.command.stock;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.first.lastproject.dao.FoodDao;

@Service("stockFoodModifyProCommand")
public class StockFoodModifyProCommand implements StockCommand {

	@Autowired
	FoodDao foodDao;
	
	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap(); //model 을 Map 으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int food_code = Integer.parseInt(request.getParameter("food_code"));
		int food_num = Integer.parseInt(request.getParameter("food_num"));
		
		//FoodDao dao = FoodDaoImpl.getInstance();
		//int result = foodDao.modifyStockFood(food_code, food_num);
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		map2.put("food_code", food_code);
		map2.put("food_num", food_num);
		int result = foodDao.modifyStockFood(map2);
		
		model.addAttribute("foodModifyResult", result);
		return "host/stock/foodModifyPro";
	
	}


}
