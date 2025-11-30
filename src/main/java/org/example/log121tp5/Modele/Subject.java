package org.example.log121tp5.Modele;

import java.util.LinkedList;
import java.util.List;

public abstract class Subject {
    private transient List<Observer> listObservers = new LinkedList<>();

    /**
     * Ajoute un observer à la liste des observers.
     * @param o
     */
    public void attach(Observer o) {
        listObservers.add(o);
    }
    /**
     * Retire un observer de la liste des observers.
     * @param o
     */
    public void detach(Observer o) {
        listObservers.remove(o);
    }
    /**
     * Notifie tous les observers des changements du subject.
     */
    public void notifyObservers() {
        for (Observer obv : listObservers) {
            obv.update(this);
        }
    }
}