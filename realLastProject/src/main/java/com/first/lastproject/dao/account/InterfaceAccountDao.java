package com.first.lastproject.dao.account;

import java.util.List;

import com.first.lastproject.dto.AccountDto;

public interface InterfaceAccountDao {

	public List<AccountDto> getDayAccount();

	public AccountDto getDayTotalAccount();



}
