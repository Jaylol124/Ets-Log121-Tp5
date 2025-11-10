package org.example.log121tp5;

import java.util.ArrayList;

public class GestionnaireCommande {
    private static  GestionnaireCommande instance;
    private ArrayList<Commande> historiqueCommande = new ArrayList<>();


    private GestionnaireCommande(){

    }


// creer une instance par classe
    public static GestionnaireCommande getInstance(){
        if(instance == null) {

            instance = new GestionnaireCommande();




        }



        return instance;
    }
   // ajoute les commande executer dans la liste de commande
   public void commandeExecute(Commande commande){
    commande.excute();
    historiqueCommande.add(commande);



  }
   // retire les commandes du liste
   public void retirerCommande(Commande commande){
        if(!historiqueCommande.isEmpty()) {
            historiqueCommande.remove(commande);
        }


   }



}
