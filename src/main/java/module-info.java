module org.javaemailclinet {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.web;
    requires activation;
    requires java.mail;

    exports org.javaemailclinet;
    opens org.javaemailclinet.view to javafx.fxml;

    exports org.javaemailclinet.controller;
    opens org.javaemailclinet.controller to javafx.fxml;
    exports org.javaemailclinet.view;
}