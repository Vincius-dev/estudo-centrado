module com.viniciusdev.estudocentrado {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.viniciusdev.estudocentrado.controllers to javafx.fxml;

    exports com.viniciusdev.estudocentrado;
}
