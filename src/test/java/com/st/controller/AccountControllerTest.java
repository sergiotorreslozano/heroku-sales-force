package com.st.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.st.HerokuSalesForceApplication;
import com.st.domain.salesforce.Account;
import com.st.repository.AccountRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HerokuSalesForceApplication.class)
@WebAppConfiguration
@ActiveProfiles("test")
@SqlGroup({ @Sql(value = "/test-schema.sql"),
		@Sql(value = "/test-clean-up.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD) })
public class AccountControllerTest {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mvc;

	private Account temporaryAccount;

	private HttpMessageConverter<Account> mappingJackson2HttpMessageConverter;

	@Before
	public void setUp() throws Exception {
		this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void cleanDB() throws Exception {
		accountRepository.deleteByName("TestingAccount");
	}

	@Test
	public void getAccounts() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/accounts").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	// @Test
	public void createAccount() throws Exception {
		String accountJson = json(new Account("TestingAccount", new Date()));
		this.mvc
				.perform(post("/api/accounts").contentType(MediaType.APPLICATION_JSON).content(accountJson))
				.andExpect(status().isCreated());
	}

	protected String json(Account o) throws IOException {
		MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
		this.mappingJackson2HttpMessageConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
		return mockHttpOutputMessage.getBodyAsString();
	}

}
