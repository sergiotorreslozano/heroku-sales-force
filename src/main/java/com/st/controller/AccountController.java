package com.st.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.st.domain.salesforce.Account;
import com.st.repository.AccountRepository;

@RestController
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;

	@RequestMapping(value = "/api/accounts", method = RequestMethod.GET)
	public List<Account> findAllAccounts() {
		return accountRepository.findAll();
	}

	@RequestMapping(value = "/api/accounts/{name}", method = RequestMethod.POST)
	public Account addAccount(@PathVariable String name) {
		Account entity = new Account(name, new Date());
		return accountRepository.save(entity);
	}

}
