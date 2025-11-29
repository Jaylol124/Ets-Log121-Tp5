package org.example.log121tp5.Modele.Conteneur;

import javafx.scene.image.ImageView;
import org.example.log121tp5.Modele.Subject;
import org.example.log121tp5.Vue.ConteneurVue;

public class ConteneurSubject extends Subject {

    ConteneurVue conteneur = new ConteneurVue("gray",false);

    private ImageView imageView = conteneur.getImageView();

    public ImageView getImageView() {
        return imageView;
    }

    public void changementImage(String cheminImage){
        conteneur.setImageDepuisUrlFichier(cheminImage);

        notifyObservers();
        conteneur.setZoomActuelle();
    }

    public ConteneurVue getCont() {return conteneur;}
}
