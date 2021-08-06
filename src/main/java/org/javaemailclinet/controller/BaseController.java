package org.javaemailclinet.controller;

import org.javaemailclinet.EmailManager;
import org.javaemailclinet.view.ViewFactory;

public abstract class BaseController {

    private EmailManager emailManager;
    private ViewFactory viewFactory;
    private String fxmlName;

    public BaseController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        this.emailManager = emailManager;
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    public String getFXMLname(){
        return fxmlName;
    };
}
