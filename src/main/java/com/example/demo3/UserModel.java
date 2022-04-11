package com.example.demo3;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {


    public String getUserInfo(int id) throws SQLException {

        String prenom = null;
        String nom = null;
        String titre = null;
        String description = null;

        Connection connection = SqliteConnection.Connector();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String query = ("SELECT * FROM User WHERE iD = ?;");

        try {

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {


                prenom = (resultSet.getString("Prenom"));
                nom = (resultSet.getString("Nom"));
                titre = (resultSet.getString("Titre"));
                description = (resultSet.getString("Description"));


            }


            preparedStatement.close();
            resultSet.close();
            connection.close();

        } catch (Exception e) {

        }

        return ("Bonjour " + prenom + " " + nom + ", \nVous occupez la fonction de " + titre + "\n\n" + description);
    }

    public String getDimanche(int id) throws SQLException {

        String Dimanche = null;
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        Connection connection = SqliteConnection.Connector();

        String query = ("SELECT * FROM User WHERE iD = ?;");

        try {

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                Dimanche = (resultSet.getString("Dimanche"));
            }
            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {

        }
        return Dimanche;
    }

    public String getLundi(int id) throws SQLException {

        String Lundi = null;

        PreparedStatement preparedStatement;
        ResultSet resultSet;

        Connection connection = SqliteConnection.Connector();

        String query = ("SELECT * FROM User WHERE iD = ?;");

        try {

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                Lundi = (resultSet.getString("Lundi"));
            }
            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {

        }
        return Lundi;
    }
    public String getMardi(int id) throws SQLException {

        String Mardi = null;

        PreparedStatement preparedStatement;
        ResultSet resultSet;

        Connection connection = SqliteConnection.Connector();

        String query = ("SELECT * FROM User WHERE iD = ?;");

        try {

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                Mardi = (resultSet.getString("Mardi"));
            }
            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {

        }
        return Mardi;
    }
    public String getMercredi(int id) throws SQLException {

        String Mercredi = null;

        PreparedStatement preparedStatement;
        ResultSet resultSet;

        Connection connection = SqliteConnection.Connector();

        String query = ("SELECT * FROM User WHERE iD = ?;");

        try {

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                Mercredi = (resultSet.getString("Mercredi"));
            }
            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {

        }
        return Mercredi;
    }
    public String getJeudi(int id) throws SQLException {

        String Jeudi = null;

        PreparedStatement preparedStatement;
        ResultSet resultSet;

        Connection connection = SqliteConnection.Connector();

        String query = ("SELECT * FROM User WHERE iD = ?;");

        try {

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                Jeudi = (resultSet.getString("Jeudi"));
            }
            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {

        }
        return Jeudi;
    }
    public String getVendredi(int id) throws SQLException {

        String Vendredi = null;

        PreparedStatement preparedStatement;
        ResultSet resultSet;

        Connection connection = SqliteConnection.Connector();

        String query = ("SELECT * FROM User WHERE iD = ?;");

        try {

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                Vendredi = (resultSet.getString("Vendredi"));
            }
            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {

        }
        return Vendredi;
    }
    public String getSamedi(int id) throws SQLException {

        String Samedi = null;

        PreparedStatement preparedStatement;
        ResultSet resultSet;

        Connection connection = SqliteConnection.Connector();

        String query = ("SELECT * FROM User WHERE iD = ?;");

        try {

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                Samedi = (resultSet.getString("Samedi"));
            }
            preparedStatement.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {

        }
        return Samedi;
    }


}

