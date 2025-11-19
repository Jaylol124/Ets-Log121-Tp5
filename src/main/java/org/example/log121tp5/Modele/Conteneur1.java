package org.example.log121tp5.Modele;

import javafx.scene.image.ImageView;

public class Conteneur1 extends Subject{

    ConteneurModele cont = new ConteneurModele("gray");

    private ImageView imageView = cont.getImageView();

    public ImageView getImageView() {
        return imageView;
    }

    public void changementImage(String image) {
        cont.setImage(image);
        notifyObservers();
    }

    public ConteneurModele getCont() {
        return cont;
    }
}
