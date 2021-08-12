package org.javaemailclinet.controller.services;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import org.javaemailclinet.controller.EmailSendingResult;
import org.javaemailclinet.model.EmailAccount;


public class EmailSenderService extends Service<EmailSendingResult> {

    private EmailAccount emailAccount;
    private String subject;
    private String recipient;
    private String content;

    public EmailSenderService(EmailAccount emailAccount, String subject, String recipient, String content) {
        this.emailAccount = emailAccount;
        this.subject = subject;
        this.recipient = recipient;
        this.content = content;
    }

    @Override
    protected Task<EmailSendingResult> createTask() {
        return new Task<EmailSendingResult>(){
            @Override
            protected EmailSendingResult call() throws Exception{
                return null;
            }
        };
    }
}
