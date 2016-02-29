package com.st.configuration;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.st.dto.schemas.Login;
import com.st.dto.schemas.LoginResponse;

@Configuration
public class WebServiceConfig {

	// This URL is used only for logging in. The LoginResult
	// returns a serverUrl which is then used for constructing
	// the streaming URL. The serverUrl points to the endpoint
	// where your organization is hosted.
	private static final String LOGIN_ENDPOINT = "https://test.salesforce.com";

	// The enterprise SOAP API endpoint used for the login call in this example.
	private static final String SERVICES_SOAP_PARTNER_ENDPOINT = "/services/Soap/u/22.0/";

	@Bean
	@Primary
	public Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setClassesToBeBound(Login.class, LoginResponse.class);
		return jaxb2Marshaller;
	}

	@Bean
	public WebServiceTemplate webServiceTemplate(Jaxb2Marshaller jaxb2Marshaller) throws MalformedURLException {
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
		// FIXME: both String should be placed as environment variables, as this
		// configuration dependes on which server we want to point at.
		webServiceTemplate.setDefaultUri(new URL(LOGIN_ENDPOINT + SERVICES_SOAP_PARTNER_ENDPOINT).toExternalForm());
		return webServiceTemplate;
	}

}
