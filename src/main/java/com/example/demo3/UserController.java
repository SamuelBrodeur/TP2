package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class UserController  implements Initializable {

    public Label Text;
    public Label Dimanche;
    public Label Lundi;
    public Label Mardi;
    public Label Mercredi;
    public Label Jeudi;
    public Label Vendredi;
    public Label Samedi;

    private int Grosseur = 30;
    private double x = 599;
    private double y = 198;


    UserModel userModel = new UserModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        try {
        Text.setText(userModel.getUserInfo(userModel.GetLastLogin()));


        if(userModel.getDimanche(userModel.GetLastLogin()) != null){
            Dimanche.setStyle("-fx-underline: true;");

        }
        if(userModel.getLundi(userModel.GetLastLogin()) != null){
            Lundi.setStyle("-fx-underline: true;");
        }
        if(userModel.getMardi(userModel.GetLastLogin()) != null){
            Mardi.setStyle("-fx-underline: true;");
        }
        if(userModel.getMercredi(userModel.GetLastLogin()) != null){
            Mercredi.setStyle("-fx-underline: true;");
        }
        if(userModel.getJeudi(userModel.GetLastLogin()) != null){
            Jeudi.setStyle("-fx-underline: true;");
        }
        if(userModel.getVendredi(userModel.GetLastLogin()) != null){
            Vendredi.setStyle("-fx-underline: true;");
        }
        if(userModel.getSamedi(userModel.GetLastLogin()) != null){
            Samedi.setStyle("-fx-underline: true;");
        }

    } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    //Grossir le texte
    public void plus(ActionEvent event) throws SQLException {
        Grosseur++;
        x++;
        y++;

        Text.setStyle("-fx-font-size:"+Grosseur+"px;");
        Text.setPrefSize(x, y);
    }

    //raptisser le texte
    public void moin(ActionEvent event){
        Grosseur--;
        x--;
        y--;

        Text.setStyle("-fx-font-size: " +Grosseur+ "px;");
        Text.setPrefSize(x, y);

    }



    //D??connexion, retourne ?? la page de connexion
    public void Logout(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/com/example/demo3/Css.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

    }



}
