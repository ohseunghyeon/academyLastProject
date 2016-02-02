package com.first.lastproject.dao.account;

import java.util.List;

import com.first.lastproject.dto.AccountDto;

public interface InterfaceAccountDao {

	public List<AccountDto> getDayAccount();

	public AccountDto getDayTotalAccount();

	public List<AccountDto> getMonthAccountDays(int monlist);
	
	public List<AccountDto> getMonthAccountPrice(int monlist);

	public AccountDto getMonthTotalAccount(int monlist);

	public AccountDto getSelectTotalAccount(String startday, String endday);

	public List<AccountDto> getSelectAccountDays(String startday, String endday);
	
	public List<AccountDto> getSelectAccountPrice(String startday, String endday);

}
