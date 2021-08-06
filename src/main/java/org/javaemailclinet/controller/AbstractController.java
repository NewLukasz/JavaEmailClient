package org.javaemailclinet.controller;

import org.javaemailclinet.EmailManager;
import org.javaemailclinet.View.ViewFactory;

public abstract class AbstractController {

    private EmailManager emailManager;
    private ViewFactory viewFactory;

    private String fxmlName;

    public AbstractController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        this.emailManager = emailManager;
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }
}
