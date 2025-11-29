package org.example.log121tp5.Modele.Conteneur;

import org.example.log121tp5.Modele.Observer;
import org.example.log121tp5.Modele.Subject;
import org.example.log121tp5.Vue.ConteneurVue;

public class ConteneurObserver implements Observer {

    ConteneurVue cont = new ConteneurVue("#1e90ff", true);

    @Override
    public void update(Subject subject) {
        if(subject instanceof ConteneurSubject){
            cont.setImage(((ConteneurSubject) subject).getImageView().getImage());
        }
    }
    public ConteneurVue getCont() {return cont;}
}
