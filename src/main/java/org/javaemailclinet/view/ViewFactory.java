package org.javaemailclinet.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.javaemailclinet.EmailManager;
import org.javaemailclinet.controller.BaseController;
import org.javaemailclinet.controller.LoginWindowController;
import org.javaemailclinet.controller.MainWindowController;
import org.javaemailclinet.controller.OptionWindowController;

import java.io.IOException;
import java.util.ArrayList;

public class ViewFactory {
    private EmailManager emailManager;
    private ArrayList<Stage> activeStages;

    public ViewFactory(EmailManager emailManager) {
        this.emailManager = emailManager;
        activeStages = new ArrayList<Stage>();
    }

    //View options handling
    private ColorTheme colorTheme = ColorTheme.LIGHT;
    private FontSize fontSize = FontSize.MEDIUM;

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    public FontSize getFontSize() {
        return fontSize;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    public void showLoginWindow(){
        System.out.println("Login windows - test");
        BaseController controller = new LoginWindowController(emailManager, this,"LoginWindow.fxml");
        initializeStage(controller);
    }

    public void showMainWindow(){
        System.out.println("Main windows - test");
        BaseController controller = new MainWindowController(emailManager, this,"MainWindow.fxml");
        initializeStage(controller);
    }

    public void showOptionWindow(){
        System.out.println("Option window - test");
        BaseController controller = new OptionWindowController(emailManager, this,"OptionsWindow.fxml");
        initializeStage(controller);
    }

    private void initializeStage(BaseController baseController){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(baseController.getFXMLname()));
        fxmlLoader.setController(baseController);
        Parent parent;
        try{
            parent = fxmlLoader.load();

        }catch (IOException e){
            e.printStackTrace();
            return;
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        activeStages.add(stage);
    }

    public void closeStage(Stage stageToClose){
        stageToClose.close();
        activeStages.remove(stageToClose);
    }

    public void updateStyles() {
        for(Stage stage: activeStages){
            Scene scene = stage.getScene();
            // handle CSS
        }
    }
}
