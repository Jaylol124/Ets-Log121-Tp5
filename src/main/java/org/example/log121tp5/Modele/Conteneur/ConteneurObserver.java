package org.example.log121tp5.Modele.Conteneur;

import org.example.log121tp5.Modele.Observer;
import org.example.log121tp5.Modele.Subject;

public class ConteneurObserver implements Observer {

    ConteneurModele cont = new ConteneurModele("#1e90ff");

    @Override
    public void update(Subject subject) {
        if(subject instanceof ConteneurSubject){
            cont.setImage(((ConteneurSubject) subject).getImageView().getImage());
        }
    }
    public ConteneurModele getCont() {
        return cont;
    }

}
