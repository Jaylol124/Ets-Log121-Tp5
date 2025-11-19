package org.example.log121tp5.Modele.Conteneur;

import javafx.scene.image.ImageView;
import org.example.log121tp5.Modele.Subject;

public class ConteneurSubject extends Subject {

    ConteneurModele cont = new ConteneurModele("gray");

    private ImageView imageView = cont.getImageView();

    public ImageView getImageView() {
        return imageView;
    }

    public void changementImage(String cheminImage){
        cont.setImageDepuisUrlFichier(cheminImage);
        notifyObservers();
    }

    public ConteneurModele getCont() {
        return cont;
    }
}
