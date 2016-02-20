package com.first.lastproject.command.account;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.first.lastproject.dao.AccountDao;
import com.first.lastproject.dao.AccountDaoImpl;
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
		
		if(dayDate == null) {
			dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT);
			formattedDate = dateFormat.format(date);
		} else {
			formattedDate = dayDate.substring(0, 10);
		}
		AccountDto dto = new AccountDto();
		List<AccountDto> list = new ArrayList<AccountDto>();
		
		if (dayDate == null) {
			list = dao.getDayAccount();
			dto = dao.getDayTotalAccount();
			
		} else {
			list = dao.getDayAccount(dayDate.substring(0, 10));
			dto = dao.getDayTotalAccount(dayDate.substring(0, 10));
			
		}
		model.addAttribute("list", list);
		model.addAttribute("dto", dto);
		model.addAttribute("time", formattedDate);
		return "/host/account/accountDay";
	}

}
