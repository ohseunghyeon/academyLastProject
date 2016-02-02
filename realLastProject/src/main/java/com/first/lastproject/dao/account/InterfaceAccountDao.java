package com.first.lastproject.dao.account;

import java.sql.Timestamp;
import java.util.List;

import com.first.lastproject.dto.AccountDto;

public interface InterfaceAccountDao {

	public List<AccountDto> getDayAccount();

	public AccountDto getDayTotalAccount();

	public List<AccountDto> getMonthAccountDays();
	
	public List<AccountDto> getMonthAccountPrice();

	public AccountDto getMonthTotalAccount(int monlist);

}
