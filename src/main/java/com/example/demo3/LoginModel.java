package com.example.demo3;

import java.sql.*;

//Cette classe gère l'état de connexion à la base de donnée et la comparaison entre les champs usager et mot de passe
public class LoginModel {
    Connection connection;

    public LoginModel() {

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

    //Vérifie si les information d'usager et mot de passe correspondent au information trouvé dans la BD
    public boolean isLogin(String user, String pass, String permission) throws SQLException {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "select * FROM Login WHERE UserName = ? and Password = ? and Permission = ?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);
            preparedStatement.setString(3, permission);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;
        } finally {
            preparedStatement.close();
            resultSet.close();
        }
    }



}
