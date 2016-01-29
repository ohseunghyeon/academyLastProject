package com.first.lastproject.command.account;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class AccountDayCommand implements AccountCommand {

	@Override
	public String execute(Model model) {
		Map <String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		return "/account/accountDay";
	}

}
