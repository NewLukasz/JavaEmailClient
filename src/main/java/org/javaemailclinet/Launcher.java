package org.javaemailclinet;

import javafx.application.Application;
import javafx.stage.Stage;
import org.javaemailclinet.view.ViewFactory;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;


public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ViewFactory viewFactory = new ViewFactory(new EmailManager());
        viewFactory.showLoginWindow();
        //tests below
        String host = "imap.gmail.com";
        String username = "user";
        String haslo = "passwd";
        Properties props = new Properties();
        props.setProperty("mail.imap.ssl.enable", "true");
        // set any other needed mail.imap.* properties here
        Session session = Session.getInstance(props);
        Store store = null;
        try {
            store = session.getStore("imap");
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
        try {
            store.connect(host, username, haslo);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println("TEST SIE ZAKONCZYL");
    }
}
