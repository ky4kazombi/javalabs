module com.example.laba31 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.laba31 to javafx.fxml;
    exports com.example.laba31;
}