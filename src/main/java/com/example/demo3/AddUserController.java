package com.example.demo3;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.event.Event;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.*;
import javafx.scene.text.Text;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Function;

public class AddUserController implements Initializable {

    private static final int MIN_LENGTH_MDP = 5;
    private static final int MIN_CARACTERE_NOM_UTILISATEUR = 2;


    @FXML
    private ChoiceBox<String> Permission;


    public CheckBox Dimanche ;
    public CheckBox Lundi;
    public CheckBox Mardi;
    public CheckBox Mercredi;
    public CheckBox Jeudi;
    public CheckBox Vendredi;
    public CheckBox Samedi;


    @FXML
    private TextField choixNom;

    @FXML
    private Text retroactionNom;

    @FXML
    private TextField choixPrenom;

    @FXML
    private Text retroactionPrenom;

    @FXML
    private TextField choixTitre;

    @FXML
    private Text retroactionTitre;

    @FXML
    private TextArea choixdescription;

    @FXML
    private Text retroactionDescription;

    @FXML
    private PasswordField choixMdp;

    @FXML
    private Text retroactionMdp;

    @FXML
    private PasswordField choixConfirmationMdp;
    @FXML
    private Text retroactionConfirmationMdp;

    @FXML
    private Text retroactionGlobale;


    private boolean erreur;



    @FXML
    private void initialize() {



        choixNom.focusedProperty().addListener((observableValue, aBoolean, newValue) -> {

            if (newValue == false) {
                validerNom(null);
            }
        });

        choixPrenom.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean newValue) {

                if (newValue == false) {
                    validerPrenom(null);
                }
            }
        } );

        choixTitre.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean newValue) {

                if (newValue == false) {
                    validerTitre(null);
                }
            }
        } );


    }

    @FXML
    private void onSoumission(Event e) throws SQLException, IOException {
        // R??initialise la d??tection d'erreur
        erreur = false;

        // Validation de chaque champ
        validerNom(e);
        validerPrenom(e);
        validerTitre(e);
        validerDescription(e);
        validerMdp(e);
        validerConfirmationMdp(e);

        // Affichage d'une r??troaction pour le clic sur le bouton soumission
        if (!erreur) {

            // Nom d'utilidateur
            String User = choixPrenom.getText() + "." + choixNom.getText();

            //Ajouter les informations ?? la BD
            //Ajouter les informations ?? la table AddUser(information de l'usager)
            AddUserModel.AddUser(choixPrenom.getText(), choixNom.getText(), choixTitre.getText(),choixdescription.getText(), Dimanche, Lundi, Mardi, Mercredi, Jeudi, Vendredi, Samedi);
            //Ajouter les informations ?? la table AddLogin(information de connection)
            AddUserModel.AddLogin(User,choixConfirmationMdp.getText(), Permission.getSelectionModel().getSelectedItem());

            //Remplacer la fen??tre avec fen??tre la  de confirmation AddUserOKController
            Parent root = FXMLLoader.load(getClass().getResource("AddUserOK.fxml"));
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


        } else {
            retroactionGlobale.setText("Veuillez corrgier les erreurs avant de soumettre le formulaire");
        }
    }

    private void validerNom(Event e) {
        boolean valeurValide = true;

        // R??initialisation du texte de r??troaction
        retroactionNom.setText("");

        // Ne peut pas comporter que des blancs
        valeurValide &= validerTextField(choixNom, (str) -> !str.isBlank(), retroactionNom,
                "Le nom d'utilisateur ne doit pas ??tre vide.");

        // Longueur minimale de nom d'utilisateur
        valeurValide &= validerTextField(choixNom, (str) -> str.length() >= MIN_CARACTERE_NOM_UTILISATEUR,
                retroactionNom, String.format("Le nom d'utilisateur doit avoir au moins %d caract??res.",
                        MIN_CARACTERE_NOM_UTILISATEUR));

        if (valeurValide) {
            affecterStyleSucces(choixNom);
        }

        erreur |= !valeurValide;
    }

    private void validerPrenom(Event e) {
        boolean valeurValide = true;

        // R??initialisation du texte de r??troaction
        retroactionPrenom.setText("");

        // Ne peut pas comporter que des blancs
        valeurValide &= validerTextField(choixPrenom, (str) -> !str.isBlank(), retroactionPrenom,
                "Le pr??nom d'utilisateur ne doit pas ??tre vide.");

        // Longueur minimale de nom d'utilisateur
        valeurValide &= validerTextField(choixPrenom, (str) -> str.length() >= MIN_CARACTERE_NOM_UTILISATEUR,
                retroactionPrenom, String.format("Le pr??nom d'utilisateur doit avoir au moins %d caract??res.",
                        MIN_CARACTERE_NOM_UTILISATEUR));

        if (valeurValide) {
            affecterStyleSucces(choixPrenom);
        }

        erreur |= !valeurValide;
    }

    private void validerTitre(Event e) {
        boolean valeurValide = true;

        // R??initialisation du texte de r??troaction
        retroactionTitre.setText("");

        // Ne peut pas comporter que des blancs
        valeurValide &= validerTextField(choixTitre, (str) -> !str.isBlank(), retroactionTitre,
                "Le titre d'utilisateur ne doit pas ??tre vide.");

        // Longueur minimale de nom d'utilisateur
        valeurValide &= validerTextField(choixTitre, (str) -> str.length() >= MIN_CARACTERE_NOM_UTILISATEUR,
                retroactionTitre, String.format("Le titre d'utilisateur doit avoir au moins %d caract??res.",
                        MIN_CARACTERE_NOM_UTILISATEUR));

        if (valeurValide) {
            affecterStyleSucces(choixTitre);
        }

        erreur |= !valeurValide;
    }

    private void validerDescription(Event e) {
        boolean valeurValide = true;

        // R??initialisation du texte de r??troaction
        retroactionDescription.setText("");

        // Ne peut pas comporter que des blancs
        valeurValide &= validerTextArea(choixdescription, (str) -> !str.isBlank(), retroactionDescription,
                "La description d'utilisateur ne doit pas ??tre vide.");

        if (valeurValide) {
            affecterStyleSucces(choixdescription);
        }

        erreur |= !valeurValide;
    }

    @FXML
    private void validerMdp(Event e) {
        boolean valeurValide = true;

        // On efface les vieux message de r??troaction
        retroactionMdp.setText("");

        // Condition sur les blancs
        valeurValide &= validerTextField(choixMdp, (str) -> !str.contains("(.*)\\s(.*)"), retroactionMdp,
                "Le mot de passe ne doit pas contenir de caract??res blancs.");

        // Conditions sur la longueur
        valeurValide &= validerTextField(choixMdp, (str) -> str.length() >= MIN_LENGTH_MDP, retroactionMdp,
                String.format("Le mot de passe ne voir au moins " +
                        MIN_LENGTH_MDP + " caract??res."));

        // Doit contenir un nombre
        valeurValide &= validerTextField(choixMdp, (str) -> str.matches("(.*)[0-9](.*)"), retroactionMdp,
                "Le mot de passe doit comporter au moins un nombre");

        // Doit contenir une lettre
        valeurValide &= validerTextField(choixMdp, (str) -> str.matches("(.*)[a-zA-Z](.*)"), retroactionMdp,
                "Le mot de passe doit comporter au moins une lettre");

        // Pas d'erreur
        if (valeurValide) {
            affecterStyleSucces(choixMdp);
        }

        // Op??rateur ou ??gal (comme un +=, mais avec un op??rateur bool??en)
        erreur |= !valeurValide;
    }

    @FXML
    private void validerConfirmationMdp(Event e) {
        // R??initialisation des messages
        retroactionConfirmationMdp.setText("");

        // V??rification que les mots de passe sont identique
        boolean valeurValide = validerTextField(choixConfirmationMdp, (str) -> choixMdp.getText().equals(str),
                retroactionConfirmationMdp,
                "Les mots de passe doivent ??tre identiques");

        if (valeurValide) {
            affecterStyleSucces(choixConfirmationMdp);
        }

        erreur |= !valeurValide;
    }

    private boolean validerTextField(TextField champ, Function<String, Boolean> condition, Text champRetroaction,
                                     String messageErreur) {
        String valeur = champ.getText();
        boolean valeurValide = condition.apply(valeur);

        if (!valeurValide) {
            ajouterLigneTexte(champRetroaction, messageErreur);
            affecterStyleErreur(champ);
        }

        return valeurValide;
    }

    private boolean validerTextArea(TextArea champ, Function<String, Boolean> condition, Text champRetroaction,
                                    String messageErreur) {
        String valeur = champ.getText();
        boolean valeurValide = condition.apply(valeur);

        if (!valeurValide) {
            ajouterLigneTexte(champRetroaction, messageErreur);
            affecterStyleErreur(champ);
        }

        return valeurValide;
    }

    private void ajouterLigneTexte(Text texte, String message) {
        // Pas de message
        if (texte.getText().isEmpty()) {
            texte.setText(message);
        } else {
            // Il y a d??j?? des messages, donc on fait un saut de ligne.
            texte.setText(texte.getText() + '\n' + message);
        }
    }

    private void affecterStyleSucces(Node noeud) {
        noeud.getStyleClass().remove("erreur");
        noeud.getStyleClass().add("validation");
    }

    private void affecterStyleErreur(Node noeud) {
        noeud.getStyleClass().remove("validation");
        noeud.getStyleClass().add("erreur");
    }


    //Change le label de connexion ?? la BD
    public AddUserModel AddUserModel = new AddUserModel();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
