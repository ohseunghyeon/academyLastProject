package com.first.lastproject.command.seat;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.first.lastproject.dao.SeatDao;
import com.first.lastproject.dao.SeatDaoImpl;
import com.first.lastproject.dto.SeatDto;
@Service("seatListCommand")
public class SeatListCommand implements SeatCommand {

	@Autowired
	SeatDao seatDao;
	
	@Override
	public String execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		ArrayList<SeatDto> seats = seatDao.getSeats();
		model.addAttribute("seats", seats);

		String id = (String) request.getSession().getAttribute("id");
		if (id.equals("host")) {
			return "host/seat/seatList";
		} else {
			return "guest/seat/seatList";
		}
	}
}
