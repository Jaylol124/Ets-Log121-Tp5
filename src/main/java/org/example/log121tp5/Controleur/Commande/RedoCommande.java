package org.example.log121tp5.Controleur.Commande;

import org.example.log121tp5.Controleur.Controleur;

public class RedoCommande implements Commande {
    private Controleur controleur;

    public RedoCommande(Controleur controleur) {
        this.controleur = controleur;
    }

    @Override
    public void execute() {
    }

}
