package org.example.log121tp5.Modele;

import org.example.log121tp5.Controleur.Controleur;
import org.example.log121tp5.Vue.ConteneurVue;

public class ConteneurObserver extends ConteneurVue implements Observer {

    private final Controleur controleur;

    public ConteneurObserver(Controleur controleur) {
        super("blue");
        this.controleur = controleur;
    }

    public void initialiserInteractions() {
        zoomerImage();
    }

    public void zoomerImage() {
        setOnScroll(event -> controleur.zoomerImageCommande(this, event));
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
