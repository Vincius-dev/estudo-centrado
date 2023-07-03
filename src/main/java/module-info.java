module com.viniciusdev.estudocentrado {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.mkammerer.argon2.nolibs;
    requires com.sun.jna;
    requires java.sql;


    opens com.viniciusdev.estudocentrado.controllers to javafx.fxml;
    opens com.viniciusdev.estudocentrado.models to javafx.base;


    exports com.viniciusdev.estudocentrado;
}
