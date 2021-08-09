package org.javaemailclinet.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.javaemailclinet.EmailManager;
import org.javaemailclinet.controller.services.LoginService;
import org.javaemailclinet.model.EmailAccount;
import org.javaemailclinet.view.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginWindowController extends BaseController implements Initializable {

    @FXML
    private TextField emailAddressField;

    @FXML
    private Label errorLabel;

    @FXML
    private PasswordField passwordField;

    public LoginWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    void loginButtonAction() {
        System.out.println("loginButtonAction()");
        if(fieldAreValid()){
            EmailAccount emailAccount = new EmailAccount(emailAddressField.getText(),passwordField.getText());
            LoginService loginService = new LoginService(emailAccount,emailManager);
            loginService.start();
            loginService.setOnSucceeded(event->{
                EmailLoginResult emailLoginResult = loginService.getValue();

                switch (emailLoginResult){
                    case SUCCESS:
                        System.out.println("login:"+emailAccount);
                        if(!viewFactory.isMainViewInitialized()){
                            viewFactory.showMainWindow();
                        }
                        Stage stage = (Stage)errorLabel.getScene().getWindow();
                        viewFactory.closeStage(stage);
                    case FAILED_BY_CREDENTIALS:
                        errorLabel.setText("Invalid credentials");
                        return;
                    case FAILED_BY_UNEXPECTED_ERROR:
                        errorLabel.setText("Unexpected error");
                        return;
                    default:
                        return;
                }
            });

        }

        //viewFactory.showMainWindow();
        //Stage stage = (Stage)errorLabel.getScene().getWindow();
        //viewFactory.closeStage(stage);
    }

    private boolean fieldAreValid() {
        if(emailAddressField.getText().isEmpty()){
            errorLabel.setText("Please fill email");
            return false;
        }
        if(passwordField.getText().isEmpty()){
            errorLabel.setText("Please fill password");
            return false;
        }
        return true;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        emailAddressField.setText("coursejava05");
        //passwordField.setText("Tutaj podaj hasło");
    }
}
