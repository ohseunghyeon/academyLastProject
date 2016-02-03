package com.first.lastproject.command.account;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.account.AccountDao;
import com.first.lastproject.dao.account.InterfaceAccountDao;
import com.first.lastproject.dto.AccountDto;

public class AccountDayCommand implements AccountCommand {

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
		InterfaceAccountDao dao = AccountDao.getInstance();
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
