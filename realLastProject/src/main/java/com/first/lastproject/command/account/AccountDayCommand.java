package com.first.lastproject.command.account;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.first.lastproject.dao.AccountDao;
import com.first.lastproject.dto.AccountDto;

@Service("accountDayCommand")
public class AccountDayCommand implements AccountCommand {

	@Autowired
	AccountDao dao;
	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String dayDate = request.getParameter("dayDate");
		Date date = new Date();
		DateFormat dateFormat = null;
		String formattedDate = null;
		System.out.println("dayDate : " + dayDate);
		String dayDateOne = null;
		if(dayDate != null) {
			dayDateOne = dayDate.substring(0, 10);
		}
		String dayStart = dayDateOne + " 00:00:00";
		String dayEnd = dayDateOne + " 23:59:59";
		System.out.println("dayDateOne : " + dayDateOne);
		Map <String, String> map2 = new HashMap <String, String>();
		map2.put("dayStart", dayStart);
		map2.put("dayEnd", dayEnd);
		map2.put("dayDate", dayDateOne);
		
		
		if(dayDateOne == null) {
			dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT);
			formattedDate = dateFormat.format(date);
		} else {
			formattedDate = dayDate.substring(0, 10);// 시작값:0, 끝값:10

			formattedDate = dayDateOne;

		}
		AccountDto dto = new AccountDto();
		AccountDto price = new AccountDto();
		List<AccountDto> list = new ArrayList<AccountDto>();
		
		
		if (dayDateOne == null) {
			list = dao.getDayAccount();
			price = dao.getDayTotalAccount();	
		} else {
			list = dao.getDayAccounts(map2);
			price = dao.getDayTotalAccount(map2);
		}
		
		model.addAttribute("list", list);
		model.addAttribute("price", price);
		model.addAttribute("time", formattedDate);
		return "/host/account/accountDay";
	}

}
