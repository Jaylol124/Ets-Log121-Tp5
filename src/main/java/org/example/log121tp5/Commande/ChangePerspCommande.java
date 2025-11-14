package org.example.log121tp5.Commande;

import org.example.log121tp5.Controleur.Controleur;

public class ChangePerspCommande implements Commande {
    private Controleur controleur;

    public ChangePerspCommande(Controleur controleur) {
        this.controleur = controleur;
    }

    @Override
    public void execute() {
    }

}
