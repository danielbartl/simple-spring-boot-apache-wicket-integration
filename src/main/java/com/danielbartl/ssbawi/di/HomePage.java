package com.danielbartl.ssbawi.di;

import com.danielbartl.ssbawi.MessageService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.io.Serial;

public class HomePage extends WebPage {

    @Serial
    private static final long serialVersionUID = 1L;

    @SpringBean
    MessageService service;

    public HomePage() {

        super();

        add(new Label(
                "message",
                (IModel<String>) () -> service.getMessage())
        );

    }
}
