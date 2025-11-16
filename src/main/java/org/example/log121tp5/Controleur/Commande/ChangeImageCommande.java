package org.example.log121tp5.Controleur.Commande;

import org.example.log121tp5.Controleur.Controleur;

public class ChangeImageCommande implements Commande {
    private Controleur controleur;

    public ChangeImageCommande(Controleur controleur) {
        this.controleur = controleur;
    }

    @Override
    public void execute() {
    }

}
