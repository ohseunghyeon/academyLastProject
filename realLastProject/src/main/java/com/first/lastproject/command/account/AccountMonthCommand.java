package com.first.lastproject.command.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;

import com.first.lastproject.dao.account.AccountDao;
import com.first.lastproject.dao.account.InterfaceAccountDao;
import com.first.lastproject.dto.AccountDto;

public class AccountMonthCommand implements AccountCommand {

	@Override
	public String execute(Model model) {
		AccountDto dto = new AccountDto();
		InterfaceAccountDao dao = AccountDao.getInstance();
		List <AccountDto> list = new ArrayList<AccountDto>();
		dto = dao.getDayTotalAccount();
		
		list = dao.getMonthAccount();
		model.addAttribute("list", list);
		model.addAttribute("dto", dto);
		return null;
	}

}
