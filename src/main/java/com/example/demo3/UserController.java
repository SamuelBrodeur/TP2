package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;


public class UserController {

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



   /* private void SetText() throws SQLException {
        Text.setText(new UserModel().getUserInfo(id.getiD()));
    }*/

    public void Reload(ActionEvent event) throws SQLException {
        Text.setText(new UserModel().getUserInfo(3));
        UserModel UserModel = new UserModel();

        if(UserModel.getDimanche(3) != null){
            Dimanche.setStyle("-fx-text-fill: green;");
        }
        if(UserModel.getLundi(3) != null){
            Lundi.setStyle("-fx-text-fill: green;");
        }
        if(UserModel.getMardi(3) != null){
            Mardi.setStyle("-fx-text-fill: green;");
        }
        if(UserModel.getMercredi(3) != null){
            Mercredi.setStyle("-fx-text-fill: green;");
        }
        if(UserModel.getJeudi(3) != null){
            Jeudi.setStyle("-fx-text-fill: green;");
        }
        if(UserModel.getVendredi(3) != null){
            Vendredi.setStyle("-fx-text-fill: green;");
        }
        if(UserModel.getSamedi(3) != null){
            Samedi.setStyle("-fx-text-fill: green;");
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











    //Déconnexion, retourne à la page de connexion
    public void Logout(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


}
