package org.example.log121tp5.Commande;

import org.example.log121tp5.Controleur.Controleur;

public class ChooseStrategyCommande implements Commande {
    private Controleur controleur;

    public ChooseStrategyCommande(Controleur controleur) {
        this.controleur = controleur;
    }

    @Override
    public void execute() {
    }

}
