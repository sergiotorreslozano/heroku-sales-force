package com.st.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.st.HerokuSalesForceApplication;
import com.st.domain.salesforce.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HerokuSalesForceApplication.class)
@WebAppConfiguration
@ActiveProfiles("test")
@SqlGroup({ @Sql(value = "/test-schema.sql"),
		@Sql(value = "/test-clean-up.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD) })
public class AccountRepositoryTest {

	@Autowired
	private AccountRepository accountRepository;

	@Test
	@Transactional
	@Rollback(true)
	public void deleteAccountByName() {
		List<Account> accounts = accountRepository.findAll();
		if (!CollectionUtils.isEmpty(accounts)) {
			Integer id = accountRepository.deleteByName(accounts.get(0).getName());
			assertTrue("deleteByName is working", 1 == id);
		}
	}

	@Test
	@Transactional
	public void findAccountsByModifiedDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.MONTH, 1);
		calendar.set(Calendar.YEAR, 2000);
		// setting year 2000 should guarantee to get at least one account
		Date date = calendar.getTime();
		List<Account> accounts = accountRepository.findByLastmodifieddateAfter(date);
		assertNotNull(accounts);
	}

	@Test
	@Transactional
	public void findAccountsByCreatedDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.MONTH, 1);
		calendar.set(Calendar.YEAR, 2000);
		// setting year 2000 should guarantee to get at least one account
		Date date = calendar.getTime();
		List<Account> accounts = accountRepository.findByCreateddateAfter(date);
		assertNotNull(accounts);
	}

}
