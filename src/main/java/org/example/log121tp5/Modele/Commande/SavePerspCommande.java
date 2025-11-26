package org.example.log121tp5.Modele.Commande;


import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import org.example.log121tp5.Controleur.Controleur;
import org.example.log121tp5.Modele.Conteneur.ConteneurModele;
//import org.example.log121tp5.Modele.Sauvegarde.SauvegardePerspective;
//import org.example.log121tp5.Modele.Conteneur.ConteneurSubject;

import java.io.*;

public class SavePerspCommande implements Commande{

    private double posX;
    private double posY;
    private transient   Controleur controleur;
    private transient FileChooser fileChooser;




    public SavePerspCommande(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;

    }


    public SavePerspCommande(Controleur controleur) {
        this.controleur = controleur;
    }

    @Override
    public void execute()  {

        ConteneurModele cm2 = controleur.getConteneurObserver2().getCont();
        ConteneurModele cm = controleur.getConteneurObserver1().getCont();
        //cm.positionActuelle();

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

                out.writeObject(cm);
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
