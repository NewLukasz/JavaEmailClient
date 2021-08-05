module org.javaemailclinet {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;


    opens org.javaemailclinet to javafx.fxml;
    exports org.javaemailclinet;
}