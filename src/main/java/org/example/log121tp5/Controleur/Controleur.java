package org.example.log121tp5.Controleur;

import org.example.log121tp5.Modele.AffichageModele;
import org.example.log121tp5.Modele.GestionnaireCommande;
import org.example.log121tp5.Modele.Commande.ChangeImageCommande;
import org.example.log121tp5.Modele.Commande.ChangePerspCommande;
import org.example.log121tp5.Modele.Commande.Commande;
import org.example.log121tp5.Modele.Commande.RedoCommande;
import org.example.log121tp5.Modele.Commande.SavePerspCommande;
import org.example.log121tp5.Modele.Commande.UndoCommande;
import org.example.log121tp5.Modele.Conteneur.ConteneurSubject;
import org.example.log121tp5.Modele.Conteneur.ConteneurObserver;
import org.example.log121tp5.Vue.AffichageVue;

public class Controleur {

    private AffichageVue affichageVue;
    private AffichageModele affichageModele;

    private GestionnaireCommande gestionnaireCommande = GestionnaireCommande.getInstance();
    private ConteneurSubject conteneurSubject;
    private ConteneurObserver conteneurObserver1;
    private ConteneurObserver conteneurObserver2;


    // GETTERS 
    public AffichageVue getAffichageVue() {return affichageVue;}
    public AffichageModele getAffichageModele() {return affichageModele;}

    public ConteneurSubject getConteneur() {return conteneurSubject;}
    public ConteneurSubject getConteneurSubject() {return conteneurSubject;}

    public ConteneurObserver getConteneurObserver1() {return conteneurObserver1;}
    public ConteneurObserver getConteneurObserver2() {return conteneurObserver2;}

    // SETTERS
    public void setAffichageVue(AffichageVue affichageVue) {this.affichageVue = affichageVue;}
    public void setAffichageModele(AffichageModele affichageModele) {this.affichageModele = affichageModele;}
    
    public void setConteneur(ConteneurSubject conteneurSubject) {this.conteneurSubject = conteneurSubject;}
    public void setConteneurSubject(ConteneurSubject conteneurSubject) {this.conteneurSubject = conteneurSubject;}

    public void setConteneurObserver1(ConteneurObserver conteneurObserver1) {this.conteneurObserver1 = conteneurObserver1;}
    public void setConteneurObserver2(ConteneurObserver conteneurObserver2) {this.conteneurObserver2 = conteneurObserver2;}

    // ON CLICK LISTENERS
    public void setOnClickListenerChangerImage(){
        System.out.println("Clicked: Changer Image");
        Commande commande = new ChangeImageCommande(this);
        gestionnaireCommande.commandeExecute(commande);
    }
    public void setOnClickListenerSave(){
        System.out.println("Clicked: Sauvegarder Perspective");
        Commande commande = new SavePerspCommande(this);
        gestionnaireCommande.commandeExecute(commande);
    }
    public void setOnClickListenerChangePersp(){
        System.out.println("Clicked: Changer Perspective");
        Commande commande = new ChangePerspCommande(this);
        gestionnaireCommande.commandeExecute(commande);
    }
    public void setOnClickListenerUndo(){
        System.out.println("Clicked: Défaire");
        Commande commande = new UndoCommande(this); 
        gestionnaireCommande.commandeExecute(commande);
    }
    public void setOnClickListenerRedo(){
        System.out.println("Clicked: Refaire");
        Commande commande = new RedoCommande(this); 
        gestionnaireCommande.commandeExecute(commande);
    }
}
