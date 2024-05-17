module com.example.laba42 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.laba42 to javafx.fxml;
    exports com.example.laba42;
}