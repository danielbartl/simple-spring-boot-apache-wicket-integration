package com.danielbartl.ssbawi.sl;

import com.danielbartl.ssbawi.MessageService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

import java.io.Serial;

public class HomePage extends WebPage {

    @Serial
    private static final long serialVersionUID = 1L;

    public HomePage() {

        super();

        add(new Label(
                "message",
                (IModel<String>) () -> SimpleContextLocator.get().getSpringContext().getBean(MessageService.class).getMessage())
        );

    }
}
