package org.example.log121tp5.Modele;

import org.example.log121tp5.Modele.Commande.Commande;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

// gestionnaire de commande pour stocker les commandes executees et agir comme caretaker
public class GestionnaireCommande {
    private static  GestionnaireCommande instance;
    private ArrayList<Commande> historiqueCommande = new ArrayList<>();

    private final Deque<Memento[]> undoStack = new ArrayDeque<>();
    private final Deque<Memento[]> redoStack = new ArrayDeque<>();
    
    // creer une instance par classe
    public static GestionnaireCommande getInstance(){
        if(instance == null) instance = new GestionnaireCommande();

        return instance;
    }

    /**
     * Exécute une commande et l’ajoute à l’historique.
     *
     * @param commande la commande à exécuter
     * @return {@code true} si la commande a bien été ajoutée à l’historique
     */
    public boolean commandeExecute(Commande commande)  {
        commande.execute();
        return historiqueCommande.add(commande);
    }

    /**
     * Ajoute un état (ou un groupe d’états) dans la pile de undo.
     * Dès qu’on push un nouvel état, on vide la pile de redo (logique normale : on repart sur une nouvelle branche).
     *
     * @param states les états à sauvegarder pour pouvoir faire "undo"
     */
    public void pushState(Memento[] states) {
        undoStack.push(states);
        redoStack.clear();
    }

    /**
     * Fait un "undo" : on revient à l’état précédent.
     * L’état courant est envoyé dans la pile de redo, puis on récupère l’état du dessus de la pile de undo.
     *
     * @param currentState l’état actuel (à sauvegarder dans redo avant de revenir en arrière)
     * @return l’état précédent à restaurer, ou {@code null} s’il n’y a rien à undo
     */
    public Memento[] undo(Memento[] currentState) {
        if (undoStack.isEmpty()) return null;
        redoStack.push(currentState);
        return undoStack.pop();
    }

    /**
     * Fait un "redo" : on avance à l’état suivant.
     * L’état courant est envoyé dans la pile de undo, puis on récupère l’état du dessus de la pile de redo.
     *
     * @param currentState l’état actuel (à sauvegarder dans undo avant de revenir en avant)
     * @return l’état suivant à restaurer, ou {@code null} s’il n’y a rien à redo
     */
    public Memento[] redo(Memento[] currentState) {
        if (redoStack.isEmpty()) return null;
        undoStack.push(currentState);
        return redoStack.pop();
    }

    /**
     * Retire une commande de l’historique.
     *
     * @param commande la commande à retirer
     * @return {@code true} si la commande a bien été retirée
     */
    public boolean retirerCommande(Commande commande){
        return historiqueCommande.remove(commande);
    }
}
