package org.example.log121tp5.Modele.Commande;

import javafx.stage.FileChooser;
import org.example.log121tp5.Modele.Conteneur.ConteneurModele;

import java.io.*;

public class ChangePerspCommande implements Commande {
    
    private FileChooser fileChooser;

    @Override
    public void execute() {
        ConteneurModele cm1 = null;
        ConteneurModele cm2 = null;

        fileChooser = new FileChooser();
        fileChooser.setTitle("Changer les perspectives");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Perspective", "*.Perspective")
        );
        File nomFichier = fileChooser.showOpenDialog(null);


        if (nomFichier != null) {
            try {
                FileInputStream fileIn = new FileInputStream( nomFichier);
                ObjectInputStream in = new ObjectInputStream(fileIn);

                cm1 = (ConteneurModele) in.readObject();
                cm2 = (ConteneurModele) in.readObject();
                
                in.close();
                fileIn.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }


    }

}
