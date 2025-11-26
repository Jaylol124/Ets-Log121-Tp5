package org.example.log121tp5.Modele.Conteneur;

import javafx.scene.image.ImageView;

import java.util.LinkedList;
import java.util.List;

public class ConteneurSubject extends Subject {

    ConteneurModele cont = new ConteneurModele("gray",false);

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
