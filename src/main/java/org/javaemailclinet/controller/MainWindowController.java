package org.javaemailclinet.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.javaemailclinet.EmailManager;
import org.javaemailclinet.view.ViewFactory;

public class MainWindowController extends BaseController {

    @FXML
    private TreeView<?> emailsTreeView;

    @FXML
    private TableView<?> emailsTableView;

    @FXML
    private WebView emailWebView;

    public MainWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    void optionsAction() {
        System.out.println("optionsAction()");
        viewFactory.showOptionWindow();
        Stage stage = (Stage)emailsTreeView.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

    @FXML
    void addAccountAction() {
        System.out.println("addAccountAction()");
        viewFactory.showLoginWindow();
    }

}
