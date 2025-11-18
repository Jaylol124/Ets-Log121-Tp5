package org.example.log121tp5.Modele;

public class Conteneur2 implements Observer{

    ConteneurModele cont = new ConteneurModele("#1e90ff");

    @Override
    public void update(Subject subject) {
        if(subject instanceof Conteneur1)
        {
            //cont.setImage(((Conteneur1) subject).getImageView());
            //cont.setImage("/images/blackrizz.png");
            cont.setImage(((Conteneur1) subject).getImageView().getImage());
        }
    }
    public ConteneurModele getCont() {
        return cont;
    }

}
