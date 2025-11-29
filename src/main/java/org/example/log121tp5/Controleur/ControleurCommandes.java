package org.example.log121tp5.Controleur;

import org.example.log121tp5.Modele.GestionnaireCommande;
import org.example.log121tp5.Modele.Commande.ChangeImageCommande;
import org.example.log121tp5.Modele.Commande.Commande;
import org.example.log121tp5.Modele.Conteneur.ConteneurObserver;
import org.example.log121tp5.Modele.Conteneur.ConteneurSubject;
import org.example.log121tp5.Vue.AffichageVue;
import org.example.log121tp5.Vue.ConteneurVue;

public class ControleurCommandes {

    private final ConteneurVue conteneurVue;
    private AffichageVue affichageVue;


    private final ConteneurSubject conteneurSubject;
    private final ConteneurObserver conteneurObserver1;
    private final ConteneurObserver conteneurObserver2;

    private final GestionnaireCommande gestionnaireCommande = GestionnaireCommande.getInstance();

    public ControleurCommandes(ConteneurVue conteneurVue, ConteneurSubject conteneurSubject,
         ConteneurObserver conteneurObserver1, ConteneurObserver conteneurObserver2) {

        this.conteneurVue = conteneurVue;

        this.conteneurSubject = conteneurSubject;
        this.conteneurObserver1 = conteneurObserver1;
        this.conteneurObserver2 = conteneurObserver2;

        this.conteneurSubject.attach(conteneurObserver1);
        this.conteneurSubject.attach(conteneurObserver2);
    }

    public ConteneurVue getConteneurVue() {return conteneurVue;}
    public void setAffichageVue(AffichageVue affichageVue) {this.affichageVue = affichageVue;}
    public AffichageVue getAffichageVue() {return affichageVue;}

    public ConteneurSubject getConteneurSubject() {return conteneurSubject;}

    public ConteneurObserver getConteneurObserver1() {return conteneurObserver1;}
    public ConteneurObserver getConteneurObserver2() {return conteneurObserver2;}

    public void onClickListenerChangerImage(String uri) { 
        Commande commande = new ChangeImageCommande(conteneurSubject, uri);
        gestionnaireCommande.commandeExecute(commande);
    }

    public void setOnClickListenerSauvegardePersp()  {
        //Commande commande = new SavePerspCommande();
        //gestionnaireCommande.commandeExecute(commande);
    }

    public void setOnClickListenerChangePersp()  {
        //Commande commande = new ChangePerspCommande();
        //gestionnaireCommande.commandeExecute(commande);
    }
}
