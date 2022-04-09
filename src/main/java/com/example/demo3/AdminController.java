package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {

    public void Logout(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void AddUser(ActionEvent event) throws  IOException {

        Parent root = FXMLLoader.load(getClass().getResource("AddUser.fxml"));
        Stage stage = new Stage();;
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
