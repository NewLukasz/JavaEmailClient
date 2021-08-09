package org.javaemailclinet;

import javafx.scene.control.TreeItem;
import org.javaemailclinet.model.EmailAccount;
import org.javaemailclinet.model.EmailTreeItem;

public class EmailManager {
    //Folder handling:
    private EmailTreeItem<String> foldersRoot = new EmailTreeItem<String>("");
    public EmailTreeItem<String> getFoldersRoot(){
        return foldersRoot;
    };

    public void addEmailAccount(EmailAccount emailAccount){
        TreeItem<String> treeItem = new TreeItem<String>(emailAccount.getAddress());
        treeItem.setExpanded(true);
        treeItem.getChildren().add(new TreeItem<String>("Inbox"));
        treeItem.getChildren().add(new TreeItem<String>("Sent"));
        treeItem.getChildren().add(new TreeItem<String>("Folder1"));
        treeItem.getChildren().add(new TreeItem<String>("SPAM"));
        foldersRoot.getChildren().add(treeItem);
    }
}
