module main.bankingsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens classes to javafx.fxml;


    exports classes;


    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens main to javafx.fxml;
    exports main;
    exports controllers;
    opens controllers to javafx.fxml;
    exports controllers.old;
    opens controllers.old to javafx.fxml;
}