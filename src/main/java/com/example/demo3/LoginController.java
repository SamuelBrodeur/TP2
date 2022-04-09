package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

//Cette affiche l'état de connexion à la base et la connexion de l'utilisateur
public class LoginController implements Initializable {
    public LoginModel loginModel = new LoginModel();

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    //Label utilisé pour afficher l'état de connexion à la BD
    private Label isConnected;
    @FXML
    //Label utilisé pour afficher l'état de connexion de l'usager
    private Label isSuccessful;

    //Status de connexion a la BD
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        if (loginModel.isDbConnected()) {
            isConnected.setText("Connecté");
            isConnected.setStyle("-fx-text-fill: green");
        } else {

            isConnected.setText("Déonnecté");
            isConnected.setStyle("-fx-text-fill: red");
        }
    }
    //Bouton de Connexion avec un utilisateur et mot de passe
    public void Login (ActionEvent event) throws SQLException, IOException {

        //Ouvre la scene Admin

        if ( loginModel.isLogin(username.getText(), password.getText(),"Administrateur")) {

            Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            //Ouvre la scene user
        }else if( loginModel.isLogin(username.getText(), password.getText(), "Utilisateur")) {

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