package com.first.lastproject.command.goods;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class GoodsPayProCommand implements GoodsCommand {

	@Override
	public String execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String id = (String) request.getSession().getAttribute("id");
		int seat_num = (Integer) request.getSession().getAttribute("seat_num");
		
		//order 테이블에 insert함으로 주문 레코드 하나 추가.
		//insert into p_order values (seq_order_code.nextval, seatNum세션에서 받아오기, id 세션에서 받아오기, sysdate, sysdate)
		// 
		return null;
	}

}
