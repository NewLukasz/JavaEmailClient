package org.javaemailclinet;

import javafx.scene.control.TreeItem;
import org.javaemailclinet.controller.services.FetchFolderService;
import org.javaemailclinet.model.EmailAccount;
import org.javaemailclinet.model.EmailTreeItem;

public class EmailManager {
    //Folder handling:
    private EmailTreeItem<String> foldersRoot = new EmailTreeItem<String>("");
    public EmailTreeItem<String> getFoldersRoot(){
        return foldersRoot;
    };

    public void addEmailAccount(EmailAccount emailAccount){
        EmailTreeItem<String> treeItem = new EmailTreeItem<String>(emailAccount.getAddress());
        treeItem.setExpanded(true);
        FetchFolderService fetchFolderService = new FetchFolderService(emailAccount.getStore(),treeItem);
        fetchFolderService.start();
        foldersRoot.getChildren().add(treeItem);
    }
}
