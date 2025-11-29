package org.example.log121tp5.Modele.Commande;


import javafx.stage.FileChooser;
import org.example.log121tp5.Controleur.Controleur;
import org.example.log121tp5.Controleur.ControleurCommandes;
import org.example.log121tp5.Modele.Conteneur.ConteneurModele;
import org.example.log121tp5.Vue.ConteneurVue;

import java.io.*;

public class SavePerspCommande implements Commande{
    private transient ControleurCommandes controleurCommandes;
    private transient FileChooser fileChooser;

    @Override
    public void execute()  {

        ConteneurVue cm1 = controleurCommandes.getConteneurObserver2().getCont();
        ConteneurVue cm2 = controleurCommandes.getConteneurObserver1().getCont();

        fileChooser = new FileChooser();
        fileChooser.setTitle("Sauvegarder les perspectives");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Perspective", "*.Perspective")
        );
        File nomFichier = fileChooser.showSaveDialog(null);

        if (nomFichier != null) {
            try {
                FileOutputStream fileOut = new FileOutputStream( nomFichier);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);

                out.writeObject(cm1);
                out.writeObject(cm2);
                out.close();
                fileOut.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
