package org.example.log121tp5.Vue;

import org.example.log121tp5.Controleur.Controleur;
import org.example.log121tp5.Modele.Observer;
import org.example.log121tp5.Modele.Subject;

public class ConteneurObserver extends ConteneurVue implements Observer {

    private final Controleur controleur;

    public ConteneurObserver(Controleur controleur) {
        super("blue");
        this.controleur = controleur;
    }

    public void initialiserInteractions(ConteneurObserver ConteneurObserver) {
        deplacerImage(ConteneurObserver);
        zoomerImage(ConteneurObserver);
    }

    public void deplacerImage(ConteneurObserver ConteneurObserver) {
        controleur.deplacerImageCommande(this, ConteneurObserver);
    }

    public void zoomerImage(ConteneurObserver ConteneurObserver) {
        setOnScroll(event -> controleur.zoomerImageCommande(this, ConteneurObserver, event));
    }

    @Override
    public void update(Subject subject) {
        if (subject instanceof ConteneurSubject) {
            ConteneurSubject conteneurSubject = (ConteneurSubject) subject;
            String cheminImage = conteneurSubject.getCheminImage();
            this.setImageDepuisUrlFichier(cheminImage);
        }
    }
}
