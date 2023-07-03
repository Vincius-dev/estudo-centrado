package com.viniciusdev.estudocentrado.controllers;

import com.viniciusdev.estudocentrado.models.Subject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
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
    public Button btnConcluir;
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
    }

    public void returnToLogin(ActionEvent event) {
    }

    public void concluir(ActionEvent event) {
    }
}
