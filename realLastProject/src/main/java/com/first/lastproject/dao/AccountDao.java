package com.first.lastproject.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.first.lastproject.dto.AccountDto;

public interface AccountDao {

	public ArrayList<AccountDto> getDayAccount();
	
	public List<AccountDto> getDayAccount(String dayDate);

	public AccountDto getDayTotalAccount();
	
	public AccountDto getDayTotalAccount(String dayDate);
	
	public ArrayList<AccountDto> getMonthAccountDays(Map<String, String> map2);

	//public Map<String, Object> getMonthAccountDays(int monlist);
	
	public List<AccountDto> getMonthAccountPrice(Map<String, String> map2);

	public AccountDto getMonthTotalAccount(int monlist);

	public AccountDto getSelectTotalAccount(String startday, String endday);

	public List<AccountDto> getSelectAccountDays(String startday, String endday);
	
	public List<AccountDto> getSelectAccountPrice(String startday, String endday);

	

}
