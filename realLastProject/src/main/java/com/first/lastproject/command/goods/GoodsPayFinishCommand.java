package com.first.lastproject.command.goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.first.lastproject.dao.FoodDao;
import com.first.lastproject.dao.IngredientDao;
import com.first.lastproject.dao.MemberDao;
import com.first.lastproject.dao.OrderDao;
import com.first.lastproject.dao.SeatDao;
import com.first.lastproject.dto.FoodDto;
import com.first.lastproject.dto.IngredientDto;
import com.first.lastproject.dto.MemberDto;

@Service("goodsPayFinishCommand")
public class GoodsPayFinishCommand implements GoodsCommand {

	@Autowired
	OrderDao orderDao;
	@Autowired
	SeatDao seatDao;
	@Autowired
	MemberDao memberDao;
	@Autowired
	FoodDao foodDao;
	@Autowired
	IngredientDao ingredientDao;
	
	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String id = (String) request.getSession().getAttribute("id");
		int seat_num = (Integer) request.getSession().getAttribute("seat_num");

		map.put("id", id);
		map.put("seat_num", seat_num);
		int orderInsertResult = orderDao.insertOrder(map); // p_order에 추가.

		int insertOrderMenuError = 1; // 전체 메뉴 삽입 실패했는지 확인하기 위함
		if (orderInsertResult == 1) { // 이제 주문 메뉴 추가 order_code와 food_code로 메뉴
										// 하나씩 추가
			//SeatDao seatDao = SeatDaoImpl.getInstance();
			seatDao.startSeat(seat_num);

			String[] foodCodes = request.getParameterValues("food_code");	//어떤 메뉴를
			String[] foodNums = request.getParameterValues("food_num");	//얼마나 주문됐나
			
			String order_code = orderDao.getOrder_code(seat_num); //테이블 넘버로 주문 번호 가져오기

			int insertOrderMenu = 1; // 각 메뉴가 실패했는지 확인하기 위함
			
			//MemberDaoImpl memberDao = MemberDaoImpl.getInstance();
			
			int couponMileageUse = Integer.parseInt(request.getParameter("couponMileageUse"));
			if (couponMileageUse == 1) {	//쿠폰 사용
				int coupon_num = Integer.parseInt(request.getParameter("coupon")); //쿠폰 사용했을때 삭제하기 위해서 받아옴
				orderDao.useCoupon(coupon_num);	//실제 쿠폰 사용 메소드
				//헤더에 리프레시
				request.getSession().setAttribute("coupon", memberDao.getCoupon(id));
				
			} else if (couponMileageUse == 2) {	//마일리지 사용
				int mileage = Integer.parseInt(request.getParameter("mileage"));
				Map<String, Object> useMileagemap = new HashMap<String, Object>();
				useMileagemap.put("id", id);
				useMileagemap.put("mileage", mileage);
				memberDao.useMileage(useMileagemap);	//실제 마일리지 사용 메소드
			}
			
			for (int i = 0; i < foodCodes.length; i++) {	//구매 시작
				int food_code = Integer.parseInt(foodCodes[i]);
				for (int j = 0; j < Integer.parseInt(foodNums[i]); j++) {
					//각 주문당 주문 메뉴 추가 부분
					Map<String, Object> orderMenuMap = new HashMap<String, Object>();
					orderMenuMap.put("order_code", order_code);
					orderMenuMap.put("food_code", food_code);
					insertOrderMenu = orderDao.insertOrderMenu(orderMenuMap);
					
					//마일리지 추가 부분
					Map<String, Object> mileageMap = new HashMap<String, Object>();
					mileageMap.put("id", id);
					FoodDto foodDto = foodDao.getFood(food_code);
					mileageMap.put("mileage", (int) Math.round(foodDto.getPrice() * 0.05)); //가격 불러와서 마일리지로 변경
					memberDao.addMileage(mileageMap);
					
					// 이제 오더메뉴 삽입 성공 시 재료 감소, 실패 시 전체메뉴삽입실패로 else문 질문---------------
					if (insertOrderMenu == 1 && foodDao.getFood(food_code).getFood_num() < 0) { // 구매시 재료 감소
						List<IngredientDto> ingreDtoList = ingredientDao.getIngredientForFood(food_code);
						for (IngredientDto iDto : ingreDtoList) {
							ingredientDao.reduceIngredient(iDto.getIngredient_code());
						}
					} else if (insertOrderMenu == 1 && foodDao.getFood(food_code).getFood_num() > 0) {
						foodDao.reduceFoodNum(food_code);
					} else {
						insertOrderMenuError = 0;
					}
				}
			}
		}
		
		if (insertOrderMenuError == 0) { // 이거 뜨는 페이지에서 확인 해야할 텐데..실패라고.
			System.out.println(insertOrderMenuError);
		}

		model.addAttribute("orderInsertResult", orderInsertResult);
		
		//헤더에 리프레시  질문--------------------------------------
		MemberDto memberDto = memberDao.getMember(id);
		request.getSession().setAttribute("mileage", memberDto.getMileage());
		
		return "guest/payment/paymentFinish";
	}

}
