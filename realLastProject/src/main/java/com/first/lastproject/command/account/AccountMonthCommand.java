package com.first.lastproject.command.account;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.account.AccountDao;
import com.first.lastproject.dao.account.InterfaceAccountDao;
import com.first.lastproject.dto.AccountDto;

public class AccountMonthCommand implements AccountCommand {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		AccountDto mTotal = new AccountDto();
		Calendar calendar = Calendar.getInstance();
		InterfaceAccountDao dao = AccountDao.getInstance();
		List <AccountDto> mList = new ArrayList<AccountDto>();
		List <AccountDto> mPrice = new ArrayList<AccountDto>();
		int monlist = Integer.parseInt(request.getParameter("monlist"));
		String time = (calendar.get(Calendar.YEAR) +"년 " + monlist + "월");
		
		mList = dao.getMonthAccountDays(monlist);
		mPrice = dao.getMonthAccountPrice(monlist);
		mTotal = dao.getMonthTotalAccount(monlist);
		model.addAttribute("time", time);
		model.addAttribute("mList", mList);
		model.addAttribute("mPrice", mPrice);
		model.addAttribute("mTotal", mTotal);
		model.addAttribute("monlist", monlist);
		return "/host/account/accountMonth";
	}

}
