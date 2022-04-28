package com.example.demo3;

import javafx.beans.property.SimpleStringProperty;

public class User {

    private final SimpleStringProperty prenom;
    private final SimpleStringProperty nom;
    private final SimpleStringProperty titre;

    public User(String prenom, String nom, String titre) {
        this.prenom = new SimpleStringProperty(prenom);
        this.nom = new SimpleStringProperty(nom);
        this.titre = new SimpleStringProperty(titre);
    }



    public String getPrenom() {
        return prenom.get();
    }

    public String getNom() {
        return nom.get();
    }


    public String getTitre() {
        return titre.get();
    }


}
