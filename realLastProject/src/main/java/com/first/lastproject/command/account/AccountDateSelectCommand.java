package com.first.lastproject.command.account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

@Service("accountDateSelectCommand")
public class AccountDateSelectCommand implements AccountCommand {

	@Autowired
	AccountDao dao;
	
	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		AccountDto priceDto = new AccountDto();
		AccountDto selTotal = new AccountDto();
		List <AccountDto> selList = new ArrayList<AccountDto>();
		List <AccountDto> selPrice = new ArrayList<AccountDto>();
		String startDay = request.getParameter("startDay");
		String endDay = request.getParameter("endDay");
		
		Map<String, String> selectDate = new HashMap<String, String>();
		selectDate.put("startDay", startDay);
		selectDate.put("endDay", endDay);
		System.out.println("startDay endDay : " + startDay + "/ " + endDay);
		selList = dao.getSelectAccountDays(selectDate);
		
		Calendar today = Calendar.getInstance();
		String[] startL = startDay.split("-");
		int year = Integer.parseInt(startL[0]);
		int month = Integer.parseInt(startL[1]);
		int day = Integer.parseInt(startL[2]);
		int day2 = Integer.parseInt(startL[2]);
		long diffDays = 0;
		today.set(today.get(Calendar.YEAR), month - 1, day);
		System.out.println(month - 1);
		
		   try {
		        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		        Date beginDate = formatter.parse(startDay);
		        Date endDate = formatter.parse(endDay);
		         
		        // 시간차이를 시간,분,초를 곱한 값으로 나누면 하루 단위가 나옴
		        long diff = endDate.getTime() - beginDate.getTime();
		        diffDays = diff / (24 * 60 * 60 * 1000);
		 
		        System.out.println("날짜차이=" + diffDays);
		         
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		   
			for(int i = 0; i <= diffDays; i++) {
				String selectPriceStart = year + "-" + month + "-" + (day++) + " 00:00:00";
				String selectPriceEnd = year + "-" + month + "-" + (day2++) + " 23:59:59";
				Map<String, String> selectPrice = new HashMap<String, String>();
				selectPrice.put("selectPriceStart", selectPriceStart);
				selectPrice.put("selectPriceEnd", selectPriceEnd);
				if(day > today.getActualMaximum(Calendar.DATE)) {
					day = 1;
					day2 = 1;
					month = month+1;
					today.set(today.get(Calendar.YEAR), month - 1, day);
				}
				
				priceDto = dao.getSelectAccountPrice(selectPrice);
				selPrice.add(priceDto);
			}
			
		selTotal = dao.getSelectTotalAccount(selectDate);
		model.addAttribute("selList", selList);
		model.addAttribute("selTotal", selTotal);
		model.addAttribute("selPrice", selPrice);
		model.addAttribute("startDay", startDay);
		model.addAttribute("endDay", endDay);
		return "/host/account/accountDateSelect";
	}
	
}
