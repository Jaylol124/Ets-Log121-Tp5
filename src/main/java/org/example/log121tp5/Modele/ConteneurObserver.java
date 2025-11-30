package org.example.log121tp5.Modele;

import org.example.log121tp5.Controleur.Controleur;
import org.example.log121tp5.Vue.ConteneurVue;
import javafx.scene.image.ImageView;

public class ConteneurObserver implements Observer {

    private final Controleur controleur;
    private final ConteneurVue conteneurVue;

    public ConteneurObserver(Controleur controleur) {
        this.conteneurVue = new ConteneurVue("blue");
        this.controleur = controleur;
    }

    public ImageView getImageView() {return conteneurVue.getImageView();}
    public ConteneurVue getVue()    {return conteneurVue;}
    public String getCheminImage()  {return conteneurVue.getCheminImage();}

    public void setImageDepuisUrlFichier(String urlFichier) {
        conteneurVue.setImageDepuisUrlFichier(urlFichier);
    }

    /**
    * Met en place les interactions de base du conteneur.
    */
    public void initialiserInteractions() {
        zoomerImage();
    }
    /**
    * Active le zoom avec la molette (événement de scroll).
    * À chaque scroll, on délègue au contrôleur pour exécuter la commande de zoom.
    */
    public void zoomerImage() {
        conteneurVue.setOnScroll(event -> controleur.zoomerImageCommande(this, event));
    }

    /**
    * Sauvegarde l'état actuel du conteneur (zoom, position, etc.) dans un "memento".
    *
    * @return l'état courant du conteneur
    */
    public ConteneurVue.ConteneurState saveState() {
        return conteneurVue.saveState();
    }

    /**
    * Remet le conteneur dans un état précédent à partir d'un memento.
    *
    * @param memento l'état à restaurer
    */
    public void restoreState(Memento memento) {
        conteneurVue.restoreState(memento);
    }

    /**
    * Applique un zoom avec un multiplicateur.
    * Exemple: 1.2 = +20%
    *
    * @param multiplicateurDeZoom le facteur de zoom à appliquer
    */
    public void zoom(double multiplicateurDeZoom) {
        conteneurVue.zoom(multiplicateurDeZoom);
    }

    @Override
    public void update(Subject subject) {
        if (subject instanceof ConteneurSubject) {
            ConteneurSubject conteneurSubject = (ConteneurSubject) subject;
            String cheminImage = conteneurSubject.getCheminImage();
            conteneurVue.setImageDepuisUrlFichier(cheminImage);
        }
    }
}
