module com.example.ubkasirjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.example.ubkasirjavafx to javafx.fxml;
    exports com.example.ubkasirjavafx;
    exports com.example.ubkasirjavafx.ui;
    opens com.example.ubkasirjavafx.ui to javafx.fxml;
    exports com.example.ubkasirjavafx.controller;
    opens com.example.ubkasirjavafx.controller to javafx.fxml;
}