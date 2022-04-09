package com.example.demo3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddUserModel {
    
    Connection connection;

    public AddUserModel() {

        connection = SqliteConnection.Connector();
    }

    public boolean isDbConnected() {
        try {
            return !connection.isClosed();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }

    public  void AddUser(String Prenom, String Nom, String Titre, String Description) throws SQLException {


        PreparedStatement preparedStatement = null;


        try {
            String query = "INSERT INTO User(iD,Prenom,Nom,Titre,Description) VALUES(?,?,?,?,?);";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(2, Prenom);
            preparedStatement.setString(3, Nom);
            preparedStatement.setString(4, Titre);
            preparedStatement.setString(5, Description);
            preparedStatement.execute();

            
        }
        catch(Exception e){
            System.out.println("Echec");
        }
        finally {
            preparedStatement.close();
        }


    }
   public void AddLogin(String UserName, String Password, String Permission) throws SQLException {

        PreparedStatement preparedStatement = null;


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
        }


    }


}