package com.st.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.st.HerokuSalesForceApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HerokuSalesForceApplication.class)
@WebAppConfiguration
public class GreetingControllerTest {


	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		// Greeting controller is a dummy one with no inyections or WebContext
		// associated so it can be tested completely standalone. For more
		// complex testing set up the WebApplicationContext
		mvc = MockMvcBuilders.standaloneSetup(new GreetingController()).build();
	}

	@Test
	public void getBasicURL() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void getApi() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void getGreeting() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/greeting").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
