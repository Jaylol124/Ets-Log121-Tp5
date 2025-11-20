package org.example.log121tp5.Modele.Commande;

import org.example.log121tp5.Controleur.Controleur;
import org.example.log121tp5.Modele.Conteneur.ConteneurSubject;

import javafx.stage.FileChooser;
import java.io.File;

/*
 * Classe qui permet de changer l'image de fond
 * @autor guim
 */
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
        File selectedFile = fileChooser.showOpenDialog(null);

        ConteneurSubject conteneurSubject = controleur.getConteneur();

        if (selectedFile != null){
            String path = selectedFile.getPath();
            conteneurSubject.changementImage(path);
        }
        else 
            System.out.println("Aucun fichier sélectionné");
    }
}