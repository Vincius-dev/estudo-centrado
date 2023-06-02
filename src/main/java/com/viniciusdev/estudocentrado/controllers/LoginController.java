package com.viniciusdev.estudocentrado.controllers;


import com.viniciusdev.estudocentrado.App;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {
    @FXML
    private Button loginButton;

    @FXML
    private void loadInterfaceIntermediaria(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/viniciusdev/estudocentrado/intermediario/intermediario.fxml"));
            Parent root = loader.load();

            // Criar uma transição de fade
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), root);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.play();

            Scene scene = new Scene(root, 840, 528);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Adicionar um listener para executar a transição de fade antes de trocar a cena
            fadeTransition.setOnFinished(e -> {
                stage.setScene(scene);
                stage.show();
            });

            // Iniciar a transição de fade
            fadeTransition.play();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
