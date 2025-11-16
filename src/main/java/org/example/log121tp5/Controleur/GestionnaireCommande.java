package org.example.log121tp5.Controleur;

import java.util.ArrayList;

import org.example.log121tp5.Controleur.Commande.Commande;
// gestionnaire de commande pour stocker les commandes executees
public class GestionnaireCommande {
    private static  GestionnaireCommande instance;
    private ArrayList<Commande> historiqueCommande = new ArrayList<>();

    // creer une instance par classe
    public static GestionnaireCommande getInstance(){
       
        if(instance == null) instance = new GestionnaireCommande();
        
        return instance;
    }

    // ajoute les commande executer dans la liste de commande
    public boolean commandeExecute(Commande commande){
        commande.execute();
        return historiqueCommande.add(commande);
    }

    // retire les commandes du liste
    public boolean retirerCommande(Commande commande){
        return historiqueCommande.remove(commande);
    }
}
