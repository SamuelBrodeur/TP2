package com.example.demo3;

import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class Aide implements Initializable {


    public TextArea text;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        text.setText("Vous pouvez vous connecter à l'administrateur par défaut pour créer des usagers. \n\n Information de connexion: \n\n Admin \n Admin \n\n\n Après avoir créé un Utilisateur ou un Administrateur, vous pourrez vous connecter avec celui-ci.\n\n Information de connexion: \n\n Prénom.Nom \n Mot de passe");


    }
}
