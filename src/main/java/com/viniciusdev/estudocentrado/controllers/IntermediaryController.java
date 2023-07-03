package com.viniciusdev.estudocentrado.controllers;

import com.viniciusdev.estudocentrado.models.Student;
import com.viniciusdev.estudocentrado.models.Subject;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class IntermediaryController implements Initializable {

    @FXML
    public TextField txfNameSubject;
    @FXML
    public ChoiceBox cbDificult;
    @FXML
    public ChoiceBox cbRelated;
    @FXML
    public ChoiceBox cbRelevance;
    @FXML
    public Button btnConcluir;
    @FXML
    public TextField lblDaysPerWeek;
    @FXML
    public TextField lblHoursPerWeek;
    @FXML
    private TableView<Subject> tbSubjects;
    @FXML
    private Button btnAdicionar;
    @FXML
    private Button btnRemover;
    @FXML
    private Button btnSair;

    private ObservableList<Subject> data = FXCollections.observableArrayList();
    private TableColumn name;
    private TableColumn related;
    private TableColumn dificult;
    private TableColumn relevance;

    private Student student;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name = new TableColumn("Nome");
        related = new TableColumn("Assunto Relacionado");
        dificult = new TableColumn("Dificuldade");
        relevance = new TableColumn("Relevância");
        tbSubjects.getColumns().addAll(name, related, dificult, relevance);

        cbRelated.setItems(FXCollections.observableArrayList(
                 "Nenhum"));

        cbDificult.setItems(FXCollections.observableArrayList(
                "Normal", "Difícil", "Fácil"));

        cbRelevance.setItems(FXCollections.observableArrayList(
                "Normal", "Muito Relevante", "Pouco Relevante"));

        cbRelevance.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Ação a ser executada quando um item for selecionado
            System.out.println("Item selecionado: " + newValue);
        });

        cbDificult.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Ação a ser executada quando um item for selecionado
            System.out.println("Item selecionado: " + newValue);
        });

        cbRelated.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Ação a ser executada quando um item for selecionado
            System.out.println("Item selecionado: " + newValue);
        });
    }

    public void addSubject(ActionEvent event) {

        data.add(new Subject(
                txfNameSubject.getText(),
                (String)cbRelated.getValue(),
                (String)cbDificult.getValue(),
                (String)cbRelevance.getValue()));

        name.setCellValueFactory(new PropertyValueFactory<Subject,String>("subjectName"));
        related.setCellValueFactory(new PropertyValueFactory<Subject,String>("subjectRelated"));
        dificult.setCellValueFactory(new PropertyValueFactory<Subject,String>("subjectDificult"));
        relevance.setCellValueFactory(new PropertyValueFactory<Subject,String>("subjectRelevance"));

        tbSubjects.setItems(data);
    }

    public void removeSubject(ActionEvent event) {
        Subject selectedItem = tbSubjects.getSelectionModel().getSelectedItem();
        tbSubjects.getItems().remove(selectedItem);
    }

    public void returnToLogin(ActionEvent event) {
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

    public void concluir(ActionEvent event) {

        student.setNumberHoursPerDay(Integer.valueOf(lblHoursPerWeek.getText()));
        student.setNumberDaysPerWeek(Integer.valueOf(lblDaysPerWeek.getText()));

        ObservableList<Subject> observableList = tbSubjects.getItems();
        student.setArrayList(new ArrayList<>(observableList));

        System.out.println(student);
    }

    public void receiveStudent(Student student){
        this.student = student;
    }
}
