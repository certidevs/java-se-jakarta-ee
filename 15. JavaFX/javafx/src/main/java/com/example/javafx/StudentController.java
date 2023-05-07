package com.example.javafx;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {

    @FXML
    private TableView<StudentModel> tbData;
    @FXML
    public TableColumn<StudentModel, Integer> studentId;
    @FXML
    public TableColumn<StudentModel, String> firstName;
    @FXML
    public TableColumn<StudentModel, String> lastName;
    


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        studentId.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        tbData.setItems(FXCollections.observableArrayList(
                new StudentModel(1, "student1", "lastname1"),
                new StudentModel(2, "student2", "lastname2"),
                new StudentModel(3, "student3", "lastname3"),
                new StudentModel(4, "student4", "lastname4")
        ));
    }
}
