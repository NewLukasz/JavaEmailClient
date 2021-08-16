package org.javaemailclinet;

import javafx.application.Application;
import javafx.stage.Stage;
import org.javaemailclinet.controller.persistence.PersistenceAccess;
import org.javaemailclinet.controller.persistence.ValidAccount;
import org.javaemailclinet.controller.services.LoginService;
import org.javaemailclinet.model.EmailAccount;
import org.javaemailclinet.view.ViewFactory;

import java.util.ArrayList;
import java.util.List;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private PersistenceAccess persistenceAccess = new PersistenceAccess();
    private EmailManager emailManager = new EmailManager();

    @Override
    public void start(Stage stage) throws Exception {
        ViewFactory viewFactory = new ViewFactory(emailManager);
        List<ValidAccount> validAccountsList = persistenceAccess.loadFromPersistence();
        if(validAccountsList.size()>0){
            viewFactory.showMainWindow();
            for(ValidAccount validAccount: validAccountsList){
                EmailAccount emailAccount = new EmailAccount(validAccount.getAddress(),validAccount.getPassword());
                LoginService loginService = new LoginService(emailAccount,emailManager);
                loginService.start();
            }
        }else{
            viewFactory.showLoginWindow();
        }
    }

    @Override
    public void stop() throws Exception {
        List<ValidAccount> validAccountList = new ArrayList<ValidAccount>();
        for(EmailAccount emailAccount: emailManager.getEmailAccounts()){
            validAccountList.add(new ValidAccount(emailAccount.getAddress(),emailAccount.getPassword()));
        }
        persistenceAccess.saveToPersistence(validAccountList);
    }
}
