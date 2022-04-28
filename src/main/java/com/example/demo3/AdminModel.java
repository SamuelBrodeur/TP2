package com.example.demo3;

import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AdminModel {

    //supprimer le user de la Base de donnée
    public void deleteUser(String prenom, String nom, String titre) throws SQLException {
        Connection connection = SqliteConnection.Connector();
        PreparedStatement preparedStatement = null;

        try{
            String sql = "DELETE FROM User WHERE Prenom=? and Nom=? and Titre=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,prenom);
            preparedStatement.setString(2,nom);
            preparedStatement.setString(3,titre);

            preparedStatement.execute();



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            preparedStatement.close();
            connection.close();
        }
    }


    /*private ListView<String> UserListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) throws SQLException {

        Connection connection = SqliteConnection.Connector();

        String query = ("SELECT Prenom, Nom, Titre FROM User");

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                String prenom = resultSet.getString("Prenom");
                String nom = resultSet.getString("Nom");
                String titre = resultSet.getString("Titre");

                UserListView.getItems().add(prenom);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
