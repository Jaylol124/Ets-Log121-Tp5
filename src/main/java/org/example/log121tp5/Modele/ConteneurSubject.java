package org.example.log121tp5.Modele;

import java.util.LinkedList;
import java.util.List;

import org.example.log121tp5.Vue.ConteneurVue;    

public class ConteneurSubject extends ConteneurVue implements Subject{
    transient List<Observer> listObservers = new LinkedList<>();
    private String cheminImage;

    public ConteneurSubject() {
        super("gray");
    }

    public void changementImage(String cheminImage){
        this.cheminImage = cheminImage;
        this.setImageDepuisUrlFichier(cheminImage);

        notifyObservers();
        this.setZoomActuelle();
    }

    public String getCheminImage() {
        return cheminImage;
    }

    @Override
    public void addObserver(Observer o) {
	    listObservers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        listObservers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer obv : listObservers)
            obv.update(this);
    }
}
