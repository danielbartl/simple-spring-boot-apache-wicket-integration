package com.danielbartl.ssbawi.di;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;


@SpringBootTest
class SimpleSpringBootApacheWicketIntegrationApplicationTests {

	@Autowired
	ApplicationContext ctx;

	@Autowired
	WebApplication webApp;

	@Test
	void contextLoads() {

		Assertions.assertNotNull(ctx);

	}

	@Test
	public void homepageRendersSuccessfully()
	{

		WicketTester tester = new WicketTester(webApp);

		//start and render the test page
		tester.startPage(HomePage.class);

		//assert rendered page class
		tester.assertRenderedPage(HomePage.class);

	}



}
