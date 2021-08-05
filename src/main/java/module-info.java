module org.javaemailclinet {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;


    opens org.javaemailclinet to javafx.fxml;
    exports org.javaemailclinet;
    opens org.javaemailclinet.view to javafx.fxml;
    exports org.javaemailclinet.controller;
    opens org.javaemailclinet.controller to javafx.fxml;
}