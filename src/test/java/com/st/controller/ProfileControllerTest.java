package com.st.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HerokuSalesForceApplication.class)
@WebAppConfiguration
@ActiveProfiles("test")
@SqlGroup({ @Sql(value = "/test-schema.sql"),
		@Sql(value = "/test-clean-up.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD) })
public class ProfileControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getAccounts() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/profiles").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
