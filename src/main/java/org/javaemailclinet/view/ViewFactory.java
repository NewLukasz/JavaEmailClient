package org.javaemailclinet.view;

import org.javaemailclinet.EmailManager;

public class ViewFactory {
    private EmailManager emailManager;

    public ViewFactory(EmailManager emailManager) {
        this.emailManager = emailManager;
    }

    public void showLoginWindow(){
        System.out.println("Login windows - test");
    }
}
