package com.danielbartl.ssbawi.sl;

import com.danielbartl.ssbawi.MessageService;
import org.apache.wicket.mock.MockApplication;
import org.apache.wicket.spring.test.ApplicationContextMock;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomePageTest {

     private WicketTester tester;

        @BeforeEach
        public void setUp()
        {

            final MockApplication webApp = new MockApplication();
            final ApplicationContextMock contextMock = new ApplicationContextMock();
            final MessageService service = new MessageService();
            contextMock.putBean(service);
            new SimpleContextLocator(webApp, contextMock);
            tester = new WicketTester(webApp);

        }

        @Test
        public void homepageRendersSuccessfully()
        {
            //start and render the test page
            tester.startPage(HomePage.class);

            //assert rendered page class
            tester.assertRenderedPage(HomePage.class);
        }
}
