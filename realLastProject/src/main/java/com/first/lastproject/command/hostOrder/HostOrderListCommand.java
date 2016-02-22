package com.first.lastproject.command.hostOrder;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.first.lastproject.dao.OrderDao;
import com.first.lastproject.dto.FoodDto;
import com.first.lastproject.dto.HostOrderListDto;
import com.first.lastproject.dto.OrderDto;
@Service("hostOrderListCommand")
public class HostOrderListCommand implements HostOrderCommand {

	@Autowired
	OrderDao orderDao;
	@Override
	public String execute(Model model) {

		
		ArrayList<OrderDto> order_done = orderDao.getUndoneOrder();

		if (order_done != null) { //메뉴가 안 나간 주문이 존재할 경우.
			ArrayList<HostOrderListDto> hostOrderlist = new ArrayList<HostOrderListDto>();
			ArrayList<String> foodNameArray = new ArrayList<String>();
			
			for (int i = 0; i < order_done.size(); i++) { //출력할 주문메뉴 합치기 작업
				String food_name = "";
				ArrayList<FoodDto> foodList = orderDao.concatFoodName(order_done.get(i).getOrder_id());
				for(FoodDto foodDto : foodList) {
					food_name += foodDto.getFood_name() + "(" + foodDto.getFood_num() + ") ";
				}
				foodNameArray.add(food_name);
			}
			
			for (int i = 0; i < order_done.size(); i++) {
				HostOrderListDto holDto = new HostOrderListDto();
				holDto.setFood_name(foodNameArray.get(i));
				holDto.setOrder_id(order_done.get(i).getOrder_id());
				holDto.setSeat_num(order_done.get(i).getSeat_num());
				hostOrderlist.add(holDto);
			}

			model.addAttribute("hostOrderlist", hostOrderlist);
		}

		return "host/order/orderList";
	}

}
