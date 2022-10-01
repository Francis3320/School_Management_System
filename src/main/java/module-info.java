module com.example.school_management_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;


    opens com.example.school_management_system to javafx.fxml;
    exports com.example.school_management_system;
}