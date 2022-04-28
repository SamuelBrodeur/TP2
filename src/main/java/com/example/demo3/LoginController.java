package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import java.io.IOException;
import java.sql.SQLException;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

//Cette classe affiche l'état de connexion à la base et fait la connexion de l'utilisateur à application
public class LoginController {
    private LoginModel loginModel = new LoginModel();
    private UserModel usermodel = new UserModel();


    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    //Label utilisé pour afficher l'échec de connexion de l'usager à l'application
    private Label isSuccessful;



    public String usrid;

    //Bouton de Connexion avec un utilisateur et mot de passe
    public void Login(ActionEvent event) throws SQLException, IOException {


        //Store les informations de user et mot de passe

        usermodel.AddLoginHistory(usermodel.UserID(username.getText(), password.getText()));


        //Ouvre la scene "Admin" si l'utilisateur est Administrateur
        if (loginModel.isLogin(username.getText(), password.getText(), "Administrateur")) {


            Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            //Ouvre la scene "User" si l'utilisateur est Utilisateur
        } else if (loginModel.isLogin(username.getText(), password.getText(), "Utilisateur")) {


            Parent root = FXMLLoader.load(getClass().getResource("User.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        //Si la connexion n'est pas réusi, un message d'erreur s'affiche
        else {
            isSuccessful.setText("Utilisateur ou mot de passe invalide");
        }
    }






}