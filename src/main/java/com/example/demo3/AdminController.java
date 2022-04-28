package com.example.demo3;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ResourceBundle;

public class AdminController implements Initializable {


    public TableView<User> table;
    public TableColumn<User,String> prenom;
    public TableColumn<User,String> nom;
    public TableColumn<User,String> titre;

    private ObservableList<User>data;

    AdminModel adminModel = new AdminModel();

    @Override

    //charge la table
    public  void initialize(URL url, ResourceBundle resourceBundle) {
        Connection connection = SqliteConnection.Connector();
        data=FXCollections.observableArrayList();

        try {
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM User");

            while(resultSet.next()){
                data.add(new User(resultSet.getString("Prenom"),resultSet.getString("Titre"),resultSet.getString("Titre")));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        titre.setCellValueFactory(new PropertyValueFactory<>("titre"));

        table.setItems(null);
        table.setItems(data);
    }





    //Bouton de déconnexion change de fenêtre
    public void Logout(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    //Bouton ajouter (un nouvel utilisateur) change de fenêtre
    public void AddUser(ActionEvent event) throws  IOException {

        Parent root = FXMLLoader. load(getClass().getResource("AddUser.fxml"));
        Stage stage = new Stage();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    //Bouton supprimer
    public void delete(ActionEvent event) throws SQLException {

        //si la sélection n'est pas null
        if(table.getSelectionModel().getSelectedItem() != null ){

        //supprimer la ligne selectionner du tableview
        table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
        //supprimer le user de la Base de donnée
        adminModel.deleteUser(table.getSelectionModel().getSelectedItem().getPrenom(),table.getSelectionModel().getSelectedItem().getNom(),table.getSelectionModel().getSelectedItem().getTitre());
        }
    }
}
