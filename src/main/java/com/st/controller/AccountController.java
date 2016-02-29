package com.st.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.st.domain.salesforce.Account;
import com.st.repository.AccountRepository;

@RestController
public class AccountController {

	private final static Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private AccountRepository accountRepository;

	private final static String HC_LASTOP = "FAILED";

	@RequestMapping(value = "/api/accounts", method = RequestMethod.GET)
	public List<Account> findAllAccounts(@RequestParam(value = "createddate", required = false) Date createddate) {
		List<Account> accounts = null;
		if (createddate != null) {
			accounts = accountRepository.findByCreateddateAfter(createddate);
		} else {
			accounts = accountRepository.findAll();
		}
		return accounts;
	}

	@RequestMapping(value = "/api/accounts", method = RequestMethod.POST)
	public ResponseEntity<Account> addAccount(@RequestBody Account account) {
		logger.debug("account: " + account.toString());
		if (StringUtils.isEmpty(account.getName())) {
			logger.debug("Account must have a name. Returning error: " + HttpStatus.BAD_REQUEST);
			return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);
		}
		account.setCreateddate(new Date());
		Account entity = accountRepository.save(account);
		logger.debug("account saved: " + entity.toString());
		if (HC_LASTOP.equals(entity.get_hc_lastop())) {
			return new ResponseEntity<Account>(entity, HttpStatus.CONFLICT);
		}
		ResponseEntity<Account> response = new ResponseEntity<>(entity, HttpStatus.OK);
		return response;
	}

}
