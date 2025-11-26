package org.example.log121tp5.Modele.Conteneur;

import javafx.scene.image.ImageView;
import org.example.log121tp5.Modele.Subject;

public class ConteneurSubject extends Subject {

    ConteneurModele cont = new ConteneurModele("gray",false);

    private ImageView imageView = cont.getImageView();

    public ImageView getImageView() {
        return imageView;
    }

    public void changementImage(String cheminImage){
        // remettre ca plus tard
        cont.setImageDepuisUrlFichier(cheminImage);
        //cont.setImage("/images/blackrizz.png");

        notifyObservers();
        cont.setZoomActuelle();
    }

    public ConteneurModele getCont() {
        return cont;
    }
}
