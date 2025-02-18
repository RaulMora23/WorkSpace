module org.example.examen {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires net.sf.jasperreports.core;


    opens org.example.examen to javafx.fxml;
    exports org.example.examen;
}