module com.example.laba4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.laba4 to javafx.fxml;
    exports com.example.laba4;
}