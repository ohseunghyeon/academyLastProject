package com.first.lastproject.command.account;

 
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.ui.Model;

import com.first.lastproject.dao.account.AccountDao;
import com.first.lastproject.dao.account.InterfaceAccountDao;
import com.first.lastproject.dto.AccountDto;

public class AccountDayCommand implements AccountCommand {

	@Override
	public String execute(Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		AccountDto dto = new AccountDto();
		String formattedDate = dateFormat.format(date);	
		InterfaceAccountDao dao = AccountDao.getInstance();
		List <AccountDto> list = new ArrayList<AccountDto>();
		dto = dao.getDayTotalAccount();
		
		list = dao.getDayAccount();
		model.addAttribute("list", list);
		model.addAttribute("dto", dto);
		model.addAttribute("time", formattedDate );
		return "/host/account/accountDay";
	}

}
