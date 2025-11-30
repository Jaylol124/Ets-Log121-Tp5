package org.example.log121tp5.Modele;

import java.util.LinkedList;
import java.util.List;

import org.example.log121tp5.Vue.ConteneurVue;

public class ConteneurSubject implements Subject {
    private transient List<Observer> listObservers = new LinkedList<>();
    private final ConteneurVue conteneurVue;
    private String cheminImage;

    public ConteneurSubject() {
        conteneurVue = new ConteneurVue("gray");
    }

    public ConteneurVue getVue()   {return conteneurVue;}
    public String getCheminImage() {return cheminImage;}


    /**
    * Change l'image affichée dans le conteneur.
    * Met à jour le chemin, charge l'image dans la vue, avertit les observers,
    * puis remet à jour l'état de zoom courant.
    *
    * @param cheminImage le chemin (ou URL de fichier) vers la nouvelle image
    */
    public void changementImage(String cheminImage){
        this.cheminImage = cheminImage;
        conteneurVue.setImageDepuisUrlFichier(cheminImage);

        notifyObservers();
        conteneurVue.setZoomActuelle();
    }

    @Override
    public void attach(Observer o) {
        getObservers().add(o);
    }

    @Override
    public void detach(Observer o) {
        getObservers().remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer obv : getObservers()) {
            obv.update(this);
        }
    }

    private List<Observer> getObservers() {
        if (listObservers == null) {
            listObservers = new LinkedList<>();
        }
        return listObservers;
    }
}
