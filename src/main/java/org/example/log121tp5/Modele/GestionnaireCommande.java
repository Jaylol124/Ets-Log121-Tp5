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

    // ajoute les commande executer dans la liste de commande
    public boolean commandeExecute(Commande commande)  {
        commande.execute();
        return historiqueCommande.add(commande);
    }

    public void pushState(Memento[] states) {
        undoStack.push(states);
        redoStack.clear();
    }

    public Memento[] undo(Memento[] currentState) {
        if (undoStack.isEmpty()) return null;
        redoStack.push(currentState);
        return undoStack.pop();
    }

    public Memento[] redo(Memento[] currentState) {
        if (redoStack.isEmpty()) return null;
        undoStack.push(currentState);
        return redoStack.pop();
    }

    // retire les commandes du liste
    public boolean retirerCommande(Commande commande){
        return historiqueCommande.remove(commande);
    }
}
