package com.first.lastproject.command.seat;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.OrderDao;
import com.first.lastproject.dao.OrderDaoImpl;
import com.first.lastproject.dao.SeatDao;
import com.first.lastproject.dao.SeatDaoImpl;

public class SeatFinishCommand implements SeatCommand {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int seat_num = Integer.parseInt(request.getParameter("seat_num"));
		String order_id = request.getParameter("order_id");
		
		SeatDao seatDao = SeatDaoImpl.getInstance();
System.out.println("비점유 시키는 seat_num : " + seat_num);
		int seatOccupiedChangeResult = seatDao.timeFinishedSeat(seat_num);
		int finishOrderResult = 0;
		
		if (seatOccupiedChangeResult == 1) {
			OrderDao orderDao = OrderDaoImpl.getInstance();
System.out.println("사용 종료 시간 설정 order_id : " + order_id);
			finishOrderResult = orderDao.updateOrderSeatEndTime(order_id);	
		}
		model.addAttribute("finishOrderResult", finishOrderResult);
		return "redirect:/seatList";
	}

}
