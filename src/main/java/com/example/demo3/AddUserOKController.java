package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class AddUserOKController {


    //Fermer la fenêtre de confirmation avec le bouton OK
    public void Close(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

    }
}
