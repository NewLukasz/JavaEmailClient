package org.javaemailclinet;

import javafx.scene.control.TreeItem;
import org.javaemailclinet.controller.services.FetchFolderService;
import org.javaemailclinet.controller.services.FolderUpdaterService;
import org.javaemailclinet.model.EmailAccount;
import org.javaemailclinet.model.EmailTreeItem;

import javax.mail.Folder;
import java.util.ArrayList;
import java.util.List;

public class EmailManager {

    private FolderUpdaterService folderUpdaterService;

    //Folder handling:
    private EmailTreeItem<String> foldersRoot = new EmailTreeItem<String>("");
    public EmailTreeItem<String> getFoldersRoot(){
        return foldersRoot;
    };

    private List<Folder> folderList = new ArrayList<Folder>();

    public List<Folder> getFolderList(){
        return this.folderList;
    }

    public EmailManager(){
        folderUpdaterService = new FolderUpdaterService(folderList);
        folderUpdaterService.start();
    }

    public void addEmailAccount(EmailAccount emailAccount){
        EmailTreeItem<String> treeItem = new EmailTreeItem<String>(emailAccount.getAddress());
        treeItem.setExpanded(true);
        FetchFolderService fetchFolderService = new FetchFolderService(emailAccount.getStore(),treeItem, folderList);
        fetchFolderService.start();
        foldersRoot.getChildren().add(treeItem);
    }
}
