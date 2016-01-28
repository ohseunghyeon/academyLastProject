package com.first.lastproject.command.goods;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;

public class GoodsListProCommand implements GoodsCommand {

	@Override
	public String execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String[] shoppingBag = request.getParameterValues("food_code");

		for (String str : shoppingBag) {
			System.out.println("선택된 물건 " + str);
		}
		request.getSession().setAttribute("shoppingBag", shoppingBag);
		
		
		return "redirect:/paymentForm";
	}

}
