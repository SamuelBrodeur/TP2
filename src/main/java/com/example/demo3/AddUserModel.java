package com.example.demo3;

import javafx.scene.control.CheckBox;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Cette classe gère l'ajout de données utilsateurs(table AddUser) et données de connexions(AddLogin)
public class AddUserModel {


    //Ajouter les informations à la table AddUser(information de l'usager)
    public  void AddUser(String Prenom, String Nom, String Titre, String Description, CheckBox Dimanche, CheckBox Lundi, CheckBox Mardi, CheckBox Mercredi, CheckBox Jeudi, CheckBox Vendredi, CheckBox Samedi) throws SQLException {

        Connection connection = SqliteConnection.Connector();
        PreparedStatement preparedStatement = null;


        try {
            String query = "INSERT INTO User(iD,Prenom,Nom,Titre,Description,Dimanche,Lundi,Mardi,Mercredi,Jeudi,Vendredi,Samedi) VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";

            connection = SqliteConnection.Connector();
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(2, Prenom);
            preparedStatement.setString(3, Nom);
            preparedStatement.setString(4, Titre);
            preparedStatement.setString(5, Description);

            //Si le CheckBox est coché, on ajoute du du texte, "rien" / Si le CheckBox n'est pas coché on ajoute NULL
            if (Dimanche.isSelected()) {
                preparedStatement.setString(6, Dimanche.getText());
            }
            if (!Dimanche.isSelected()) {
                preparedStatement.setString(6, null);
            }

            if (Lundi.isSelected()) {
                preparedStatement.setString(7, Lundi.getText());
            }
            if (!Lundi.isSelected()) {
                preparedStatement.setString(7, null);
            }

            if (Mardi.isSelected()) {
                preparedStatement.setString(8, Mardi.getText());
            }
            if (!Mardi.isSelected()) {
                preparedStatement.setString(8, null);
            }

            if (Mercredi.isSelected()) {
                preparedStatement.setString(9, Mercredi.getText());
            }
            if (!Mercredi.isSelected()) {
                preparedStatement.setString(9, null);
            }

            if (Jeudi.isSelected()) {
                preparedStatement.setString(10, Jeudi.getText());
            }
            if (!Jeudi.isSelected()) {
                preparedStatement.setString(10, null);
            }

            if (Vendredi.isSelected()) {
                preparedStatement.setString(11, Vendredi.getText());
            }
            if (!Vendredi.isSelected()) {
                preparedStatement.setString(11, null);
            }

            if (Samedi.isSelected()) {
                preparedStatement.setString(12, Samedi.getText());
            }
            if (!Samedi.isSelected()) {
                preparedStatement.setString(12, null);
            }
            else {
            }
            preparedStatement.execute();

        }

        catch(Exception e){
            System.out.println("Echec");
        }
        finally {
            preparedStatement.close();
            connection.close();
        }


    }
    //Ajouter les informations à la table AddLogin(information de connection)
   public void AddLogin(String UserName, String Password, String Permission) throws SQLException {

        PreparedStatement preparedStatement = null;

       Connection connection = SqliteConnection.Connector();
        try {

            String query = "INSERT INTO Login(iD, UserName, Password, Permission) VALUES(?,?,?,?);";

            preparedStatement = connection.prepareStatement(query);


            preparedStatement.setString(2, UserName);
            preparedStatement.setString(3, Password);
            preparedStatement.setString(4, Permission);
            preparedStatement.execute();
        }
        catch(Exception e){
            System.out.println("Echec");
        }
        finally {
            preparedStatement.close();
            connection.close();
        }

    }


}