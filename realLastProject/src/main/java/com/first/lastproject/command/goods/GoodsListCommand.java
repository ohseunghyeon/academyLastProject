package com.first.lastproject.command.goods;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.food.FoodDao;
import com.first.lastproject.dao.food.InterfaceFoodDao;
import com.first.lastproject.dto.FoodDto;

public class GoodsListCommand implements GoodsCommand {

	@Override
	public String execute(Model model) {
		/*Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");*/
		
/*		if (request.getSession().getAttribute("shoppingBag") != null) {
			String[] shoppingBag = (String[]) request.getSession().getAttribute("shoppingBag");
			model.addAttribute("shoppingBag", shoppingBag);
		} 다른 페이지 갔다가 세션에서 장바구니 받아오는 로직 */
		
		InterfaceFoodDao foodDao = FoodDao.getInstance();
		List<FoodDto> goodslist = foodDao.listGoods();	//메뉴 불러옴
		
		model.addAttribute("goodslist", goodslist);
		
		return "guest/goods/goodsList";
	}

}
