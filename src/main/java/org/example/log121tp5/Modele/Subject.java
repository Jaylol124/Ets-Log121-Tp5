package org.example.log121tp5.Modele;

public interface Subject {
    /**
     * Ajoute un observer à la liste des observers.
     * @param o
     */
    public void addObserver(Observer o);
    /**
     * Retire un observer de la liste des observers.
     * @param o
     */
    public void removeObserver(Observer o);
    /**
     * Notifie tous les observers des changements du subject.
     */
    public void notifyObservers();
}