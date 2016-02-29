package com.st.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.st.HerokuSalesForceApplication;
import com.st.dto.schemas.LoginResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HerokuSalesForceApplication.class)
@WebAppConfiguration
public class LoginWsServiceImplTest {

	@Autowired
	private ILoginWs loginWsService;

	@Test
	public void doLoginTest() {
		LoginResponse response = loginWsService.doLogin();
		assertNotNull(response);
		assertNotNull(response.getResult());
		assertNotNull(response.getResult().getSessionId());
		assertNotNull(response.getResult().getUserId());
	}

}
