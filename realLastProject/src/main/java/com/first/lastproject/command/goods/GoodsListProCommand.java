package com.first.lastproject.command.goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

import com.first.lastproject.dao.food.FoodDao;
import com.first.lastproject.dao.food.InterfaceFoodDao;
import com.first.lastproject.dto.FoodDto;

public class GoodsListProCommand implements GoodsCommand {

	@Override
	public String execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		//앞에서 선택된 장바구니의 메뉴 코드와 수량을 받아옴
		String[] food_code = request.getParameterValues("food_code");
		String[] food_num = request.getParameterValues("food_num");
		
		
		//받아온 코드와 수량을 map에 넣겠다.
		Map<String, String> shoppingBag = new HashMap<String, String>();
		for (int i = 0; i < food_code.length; i++) {
			shoppingBag.put(food_code[i], food_num[i]);
		}
		int price=0;//총 가격
		InterfaceFoodDao dao = FoodDao.getInstance();
		ArrayList<FoodDto> shoppingBagForPayment = new ArrayList<FoodDto>(); //결제창에서 뿌릴, 고객이 선택해서 넘어온 메뉴
		for (int i = 0; i < food_code.length; i++) {
			FoodDto foodDto = dao.getFood(Integer.parseInt(food_code[i]));	//고객이 선택한 메뉴
			foodDto.setFood_num(Integer.parseInt(food_num[i]));	//고객이 선택한 수량
			shoppingBagForPayment.add(foodDto);	//하나씩 차곡차곡
			
			price += foodDto.getPrice()*foodDto.getFood_num();// 상품 가격*개수
			
		}
		model.addAttribute("price", price);
		model.addAttribute("shoppingBagForPayment", shoppingBagForPayment);
		
		return "guest/payment/paymentForm";
	}
}

