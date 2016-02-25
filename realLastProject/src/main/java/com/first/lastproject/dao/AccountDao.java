package com.first.lastproject.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.first.lastproject.dto.AccountDto;

public interface AccountDao {

	public ArrayList<AccountDto> getDayAccount();
	
	//public List<AccountDto> getDayAccount(String dayDate);

	public AccountDto getDayTotalAccount();
	
	//public AccountDto getDayTotalAccount(String dayDate);
	
	public AccountDto getDayTotalAccount(Map<String, String> map);
	
	public int getDayPrice();

	public int getDaySelectPrice(Map<String, String> map);
	
	public ArrayList<AccountDto> getMonthAccountDays(Map<String, String> map2);

	//public Map<String, Object> getMonthAccountDays(int monlist);
	
	public AccountDto getMonthAccountPrice(Map<String, String> map2);
	
	public int getMonthTotalPrice(Map<String, String> map);

	public AccountDto getMonthTotalAccount(Map<String, String> map);

	public AccountDto getSelectTotalAccount(Map<String, String> map);

	public AccountDto getSelectAccountPrice(Map<String, String> selectPrice);
	
	public int getMonthAccountCount(Map<String, String> map2);

	public int getMonthPrice(Map<String, String> map2);

	public int getDayCount(Map<String, String> map2);

	public List<AccountDto> getDayAccounts(Map<String, String> map2);

	List<AccountDto> getSelectAccountDays(Map<String, String> map);

	public int getSelectAccountCount(Map<String, String> map);

	public int getSelectPrice(Map<String, String> map);

	public int getSelectTotalPrice(Map<String, String> map);



	
 
	

}
