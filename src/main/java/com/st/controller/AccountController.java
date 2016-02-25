package com.st.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.st.domain.salesforce.Account;
import com.st.repository.AccountRepository;

@RestController
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;

	private final static String HC_LASTOP = "FAILED";

	@RequestMapping(value = "/api/accounts", method = RequestMethod.GET)
	public List<Account> findAllAccounts() {
		return accountRepository.findAll();
	}

	@RequestMapping(value = "/api/accounts", method = RequestMethod.POST)
	public ResponseEntity<Account> addAccount(@RequestBody Account account) {
		if (StringUtils.isEmpty(account.getName())) {
			return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);
		}
		account.setCreateddate(new Date());
		Account entity = accountRepository.save(account);
		if (HC_LASTOP.equals(entity.get_hc_lastop())) {
			return new ResponseEntity<Account>(entity, HttpStatus.BAD_REQUEST);
		}
		ResponseEntity<Account> response = new ResponseEntity<>(entity, HttpStatus.OK);
		return response;
	}

}
