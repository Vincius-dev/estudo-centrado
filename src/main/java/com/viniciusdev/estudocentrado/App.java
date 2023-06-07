package com.viniciusdev.estudocentrado;

import com.viniciusdev.estudocentrado.controllers.SQLITEController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 840, 420);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UTILITY);
        stage.setScene(scene);
        stage.show();

        SQLITEController sqliteController = new SQLITEController();
        sqliteController.createDatabaseAndTables();
    }

    public static void main(String[] args) {
        launch();
    }
}