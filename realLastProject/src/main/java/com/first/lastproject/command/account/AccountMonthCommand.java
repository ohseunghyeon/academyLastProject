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
		AccountDto mTotal = new AccountDto();
		InterfaceAccountDao dao = AccountDao.getInstance();
		List <AccountDto> mList = new ArrayList<AccountDto>();
		List <AccountDto> mPrice = new ArrayList<AccountDto>();
		//dto = dao.getDayTotalAccount();
		
		mList = dao.getMonthAccountDays();
		mPrice = dao.getMonthAccountPrice();
		mTotal = dao.getMonthTotalAccount();
		model.addAttribute("mList", mList);
		model.addAttribute("mPrice", mPrice);
		model.addAttribute("mTotal", mTotal);
		return "/host/account/accountMonth";
	}

}
