package com.first.lastproject.command.seat;

import java.util.ArrayList;
import org.springframework.ui.Model;

import com.first.lastproject.dao.seat.InterfaceSeatDao;
import com.first.lastproject.dao.seat.SeatDao;
import com.first.lastproject.dto.SeatDto;

public class SeatListCommand implements SeatCommand {

	@Override
	public String execute(Model model) {
		InterfaceSeatDao seatDao = SeatDao.getInstance();
		
		ArrayList<SeatDto> seats = seatDao.getSeats();
		model.addAttribute("seats", seats);
		
		/*for(SeatDto seat : seats) {
			System.out.println(seat.getOccupied());
			System.out.println(seat.getSeat_num());
		}*/
		return "guest/seat/seatList";
	}

}
