package com.viniciusdev.estudocentrado.controllers;

import com.viniciusdev.estudocentrado.App;
import com.viniciusdev.estudocentrado.models.Student;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.security.SecureRandom;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LoginController implements Initializable {
    @FXML
    private Button loginButton;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private TextField textFieldPassword;
    @FXML
    private Label labelErrorMessage;

    @FXML
    private void loadInterfaceIntermediaria(ActionEvent event) {

        String textEmail = textFieldEmail.getText();
        String textPassword = textFieldPassword.getText();

        SQLITEController sqliteController = new SQLITEController();

        Student student = sqliteController.receiveStudent(textEmail);
        String hashedPassword = student.getPasswordStudent();

        if (verifyHashedPassword(textPassword, hashedPassword)){
            realizeTransition(event);
        } else {
            labelErrorMessage.setVisible(true);
        }


    }

    public void loadInterfaceCadastro(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/viniciusdev/estudocentrado/cadastro/cadastro.fxml"));
            Parent root = loader.load();

            // Criar uma transição de fade
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), root);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.play();

            Scene scene = new Scene(root, 840, 420);
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

    private void realizeTransition(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/viniciusdev/estudocentrado/intermediario/intermediario.fxml"));
            Parent root = loader.load();

            // Criar uma transição de fade
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), root);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.play();

            Scene scene = new Scene(root, 840, 600);
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

    private Boolean verifyHashedPassword(String password, String hash){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        if (argon2.verify(hash, password)){
            System.out.println("A senha digitada esta correta");
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
