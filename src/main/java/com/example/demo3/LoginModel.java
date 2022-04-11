package com.example.demo3;

import java.sql.*;

//Cette classe gère l'état de connexion à la base de donnée et la comparaison entre les champs usager et mot de passe
public class LoginModel {
    Connection connection;
    int allo;

    //Vérifie si les information d'usager et mot de passe correspondent au information trouvé dans la BD et retourne le iD
    public Boolean isLogin(String user, String pass, String permission) throws SQLException {



        connection = SqliteConnection.Connector();

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




