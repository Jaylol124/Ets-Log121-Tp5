package org.example.log121tp5.Modele.Commande;

import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import org.example.log121tp5.Controleur.Controleur;
import org.example.log121tp5.Modele.Conteneur.ConteneurModele;

import java.io.*;

public class ChangePerspCommande implements Commande {
    private Controleur controleur;
    private FileChooser fileChooser;

    public ChangePerspCommande(Controleur controleur) {
        this.controleur = controleur;
    }
    @Override
    public void execute() {

        ConteneurModele cm = controleur.getConteneurModele();
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
                //System.out.println(cm1.getPosXActuelle());
                controleur.getConteneurObserver1().getCont().setPosActuelle(cm1.getPosXActuelle(),cm1.getPosYActuelle());
                controleur.getConteneurObserver1().getCont().setZoomActuelle(cm1.getZoomPosX(),cm1.getZoomPosY());
                controleur.getConteneurObserver2().getCont().setPosActuelle(cm2.getPosXActuelle(),cm2.getPosYActuelle());
                controleur.getConteneurObserver2().getCont().setPosActuelle(cm2.getZoomPosX(), cm2.getZoomPosY());
                //System.out.println(cm1.getPosYActuelle());
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
