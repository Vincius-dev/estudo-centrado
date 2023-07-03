package com.viniciusdev.estudocentrado.controllers;

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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.random.RandomGenerator;

public class CadastroController implements Initializable {

    @FXML
    private TextField textFieldEmail;
    @FXML
    private TextField textFieldName;
    @FXML
    private PasswordField textFieldPassword;
    @FXML
    private PasswordField textFieldPassword2;
    @FXML
    private Label labelMessage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void Register(ActionEvent event) {

        String name = textFieldName.getText();
        String mail = textFieldEmail.getText();
        String password1 = textFieldPassword.getText();
        String password2 = textFieldPassword2.getText();

        if (password1.equals(password2)){

            String hashedPassword = verifyHashedPassword(password1);

            Student student = new Student(name,mail,hashedPassword);

            SQLITEController sqliteController = new SQLITEController();
            sqliteController.insertStudent(student);

            realizeTransition(event);

        } else {
            labelMessage.setVisible(true);
        }
    }

    private void realizeTransition(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/viniciusdev/estudocentrado/login/login.fxml"));
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

    private String verifyHashedPassword(String password){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        String hash = argon2.hash(10, 65536, 1, password);

        return hash;
    }

}

