package com.danielbartl.ssbawi.sl;

import org.apache.wicket.Application;
import org.apache.wicket.MetaDataKey;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.ISpringContextLocator;
import org.springframework.context.ApplicationContext;

import java.io.Serial;

public class SimpleContextLocator implements ISpringContextLocator {

    /**
     * Metadata key used to store application context in application's metadata
     */
    private static final MetaDataKey<SimpleContextLocator> KEY = new MetaDataKey<>()
    {
        @Serial
        private static final long serialVersionUID = 1L;

    };

    private final ApplicationContext ctx;

    public SimpleContextLocator(WebApplication webApp, ApplicationContext ctx) {

        this.ctx = ctx;
        webApp.setMetaData(KEY, this);

    }

    public static ISpringContextLocator get()
    {
        return Application.get().getMetaData(KEY);
    }

    @Override
    public ApplicationContext getSpringContext() {
        return ctx;
    }

}
