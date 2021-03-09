module com.group1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.group1 to javafx.fxml;
    exports com.group1;
}