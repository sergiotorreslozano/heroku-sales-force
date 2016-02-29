package com.st.repository;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.st.HerokuSalesForceApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HerokuSalesForceApplication.class)
@WebAppConfiguration
public class AccountRepositoryTest {

	@Autowired
	private AccountRepository accountRepository;

	@Test
	@Transactional
	@Rollback(true)
	public void deleteAccountByName() {
		Integer id = accountRepository.deleteByName("someCompany");
		assertTrue("deleteByName is working", 1 == id);
	}

	@Test
	@Transactional
	public void findAccountsByModifiedDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.MONTH, 1);
		calendar.set(Calendar.YEAR, 2000);
		Date date = calendar.getTime();

		// List<Account> accounts = accountRepository.findByLastmodifieddate();

	}

}
