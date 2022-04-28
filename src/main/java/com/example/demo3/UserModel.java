package com.example.demo3;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {

    //Cette fonction retourne les champs Prenom, Nom, Titre et Description selons un id donnée
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

    //La fonction retourne la id de l'usager qui possède les information d'utilisateur et mot de passe fournis.
    public int UserID(String user, String pass) throws SQLException {

        int userid = 0;
        Connection connection = SqliteConnection.Connector();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String query = "select * FROM Login WHERE UserName = ? and Password = ? ";

        try {


            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);


            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                userid = (resultSet.getInt("iD"));

            }

            return userid;


        } catch (Exception e) {
            return 0;
        } finally {
            preparedStatement.close();
            resultSet.close();

        }
    }
    //La fonction insert le id de l'usager dans la Base de donné LoginHistory
    public void AddLoginHistory(int UserID) throws SQLException {

        PreparedStatement preparedStatement = null;

        Connection connection = SqliteConnection.Connector();
        try {

            String query = "INSERT INTO LoginHistory(Userid) VALUES(?);";

            preparedStatement = connection.prepareStatement(query);


            preparedStatement.setInt(1, UserID);
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
    //La fonction va chercher le dernier utilisateur connecté
    public int GetLastLogin() throws SQLException {


        Connection connection = SqliteConnection.Connector();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String query = "SELECT * FROM LoginHistory WHERE iD=(SELECT max(iD) FROM LoginHistory) ";

        try {


            preparedStatement = connection.prepareStatement(query);


            resultSet = preparedStatement.executeQuery();
            int lastconnexion = 0;
            while (resultSet.next()) {

                lastconnexion = (resultSet.getInt("Userid"));

            }

            return lastconnexion;


        } catch (Exception e) {
            return 0;
        } finally {
            preparedStatement.close();
            resultSet.close();

        }
    }
    //Les fonctions suivantes retourne un String NULL ou non NULL pour les jours de semaines sélectionnés
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
    //Les fonctions suivantes retourne un String NULL ou non NULL pour les jours de semaines sélectionnés
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
    //Les fonctions suivantes retourne un String NULL ou non NULL pour les jours de semaines sélectionnés
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
    //Les fonctions suivantes retourne un String NULL ou non NULL pour les jours de semaines sélectionnés
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
    //Les fonctions suivantes retourne un String NULL ou non NULL pour les jours de semaines sélectionnés
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
    //Les fonctions suivantes retourne un String NULL ou non NULL pour les jours de semaines sélectionnés
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
    //Les fonctions suivantes retourne un String NULL ou non NULL pour les jours de semaines sélectionnés
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

