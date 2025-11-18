package org.example.log121tp5.Modele.Commande;

import org.example.log121tp5.Controleur.Controleur;

import javafx.stage.FileChooser;


public class ChangeImageCommande implements Commande {
    private Controleur controleur;
    private FileChooser fileChooser;

    public ChangeImageCommande(Controleur controleur) {
        this.controleur = controleur;
    }

    @Override
    public void execute() {
        fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir une image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.bmp", "*.gif")
        );   
    }

}
