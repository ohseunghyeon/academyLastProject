package com.first.lastproject.command.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.first.lastproject.dao.FoodDao;
import com.first.lastproject.dto.FoodDto;

@Service("goodsListCommand")
public class GoodsListCommand implements GoodsCommand {

	@Autowired
	FoodDao foodDao;
	
	@Override
	public String execute(Model model) {
		
		//FoodDao foodDao = FoodDaoImpl.getInstance();
		List<FoodDto> goodslist = foodDao.listGoods();	//메뉴 불러옴
		model.addAttribute("goodslist", goodslist);
		
		return "guest/goods/goodsList";
	}

}
