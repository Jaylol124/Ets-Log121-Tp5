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

    public void initialiserInteractions(ConteneurObserver autre) {
        deplacerImage(autre);
        zoomerImage(autre);
    }

    public void deplacerImage(ConteneurObserver autre) {
        controleur.deplacerImageCommande(this, autre);
    }

    public void zoomerImage(ConteneurObserver autre) {
        setOnScroll(event -> controleur.zoomerImageCommande(this, autre, event));
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
