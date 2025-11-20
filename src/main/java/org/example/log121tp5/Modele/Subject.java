package org.example.log121tp5.Modele;
/**
 * Inspiré des notes de cours << Le patron observateur >>
 */

import java.util.LinkedList;
import java.util.List;

public abstract class Subject {
    List<Observer> listObservers = new LinkedList<>();

    public void attach(Observer o) {
	listObservers.add(o);
    }

    public void detach(Observer o) {
	listObservers.remove(o);
    }

    public void notifyObservers() {
	for (Observer obv : listObservers)
	    obv.update(this);
    }
}