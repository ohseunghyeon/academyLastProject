package com.first.lastproject.command.goods;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.food.FoodDao;
import com.first.lastproject.dao.ingredient.IngredientDao;
import com.first.lastproject.dao.member.MemberDao;
import com.first.lastproject.dao.order.InterfaceOrderDao;
import com.first.lastproject.dao.order.OrderDao;
import com.first.lastproject.dao.seat.InterfaceSeatDao;
import com.first.lastproject.dao.seat.SeatDao;
import com.first.lastproject.dto.MemberDto;

public class GoodsPayFinishCommand implements GoodsCommand {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String id = (String) request.getSession().getAttribute("id");
		int seat_num = (Integer) request.getSession().getAttribute("seat_num");

		InterfaceOrderDao orderDao = OrderDao.getInstance();
		int orderInsertResult = orderDao.insertOrder(id, seat_num); // p_order에
																	// 추가.

		int insertOrderMenuError = 1; // 전체 메뉴 삽입 실패했는지 확인하기 위함
		if (orderInsertResult == 1) { // 이제 주문 메뉴 추가 order_code와 food_code로 메뉴
										// 하나씩 추가
			InterfaceSeatDao seatDao = SeatDao.getInstance();
			seatDao.startSeat(seat_num);

			String[] foodCodes = request.getParameterValues("food_code");	//어떤 메뉴를
			String[] foodNums = request.getParameterValues("food_num");	//얼마나 주문됐나
			
			String order_code = orderDao.getOrder_code(seat_num); //테이블 넘버로 주문 번호 가져오기

			int insertOrderMenu = 1; // 각 메뉴가 실패했는지 확인하기 위함
			for (int i = 0; i < foodCodes.length; i++) {
				int food_code = Integer.parseInt(foodCodes[i]);
				for (int j = 0; j < Integer.parseInt(foodNums[i]); j++) {
					insertOrderMenu = orderDao.insertOrderMenu(order_code, food_code);
					MemberDao.getInstance().addMileage(food_code, id); //마일리지 추가
					// 이제 오더메뉴 삽입 성공 시 재료 감소, 실패 시 전체메뉴삽입실패로 else문
					if (insertOrderMenu == 1 && FoodDao.getInstance().getFood(food_code).getFood_num() < 0) { // 구매시 재료 감소
						IngredientDao.getInstance().reduceIngredient(food_code);
					} else {
						insertOrderMenuError = 0;
					}
				}
			}
		}
		
		if (insertOrderMenuError == 0) { // 이거 뜨는 페이지에서 확인 해야할 텐데..실패라고.
			System.out.println(insertOrderMenuError);
		}
		
		MemberDto memberDto = MemberDao.getInstance().getMember(id);
		request.getSession().setAttribute("mileage", memberDto.getMileage());
		
		model.addAttribute("orderInsertResult", orderInsertResult);

		return "guest/payment/paymentFinish";
	}

}
