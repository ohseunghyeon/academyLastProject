package com.first.lastproject.dao;

import java.util.List;

import com.first.lastproject.dto.AccountDto;

public interface AccountDao {

	public List<AccountDto> getDayAccount();
	
	public List<AccountDto> getDayAccount(String dayDate);

	public AccountDto getDayTotalAccount();
	
	public AccountDto getDayTotalAccount(String dayDate);

	public List<AccountDto> getMonthAccountDays(int monlist);
	
	public List<AccountDto> getMonthAccountPrice(int monlist);

	public AccountDto getMonthTotalAccount(int monlist);

	public AccountDto getSelectTotalAccount(String startday, String endday);

	public List<AccountDto> getSelectAccountDays(String startday, String endday);
	
	public List<AccountDto> getSelectAccountPrice(String startday, String endday);

	

}
