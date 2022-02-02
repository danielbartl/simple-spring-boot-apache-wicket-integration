package com.danielbartl.ssbawi.sl;

import com.danielbartl.ssbawi.MessageService;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WicketFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimpleSpringBootApacheWicketIntegrationApplication {

	@Autowired
	ApplicationContext ctx;

	public static void main(String[] args) {

		SpringApplication.run(SimpleSpringBootApacheWicketIntegrationApplication.class, args);

	}

	@Bean
	public MessageService messageService() {

		return new MessageService();

	}

	@Bean
	public FilterRegistrationBean<WicketFilter> wicketFilter(){

		final WicketFilter filter = new WicketFilter(app());
		filter.setFilterPath("/*");
		return new FilterRegistrationBean<>(filter);

	}

	@Bean
	public WebApplication app(){

		return new WebApplication() {

			@Override
			public Class<? extends Page> getHomePage() {

				return HomePage.class;

			}

			@Override
			protected void init() {

				super.init();

				new SimpleContextLocator(this, ctx);

			}
		};

	}

}
