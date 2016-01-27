package com.first.lastproject.command.goods;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.food.FoodDao;
import com.first.lastproject.dao.food.InterfaceFoodDao;
import com.first.lastproject.dto.GoodsDto;

public class GoodsListCommand implements GoodsCommand {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		InterfaceFoodDao dao = FoodDao.getInstance();
		List<GoodsDto> goodslist = new ArrayList<GoodsDto>();
		goodslist = dao.goods();
		
		request.setAttribute("goodslist", goodslist);
		
		return "/goods/GoodsList";
	}

}
