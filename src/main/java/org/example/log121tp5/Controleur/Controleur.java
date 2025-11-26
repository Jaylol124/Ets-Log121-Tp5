package org.example.log121tp5.Controleur;

import org.example.log121tp5.Modele.AffichageModele;
import org.example.log121tp5.Modele.Commande.ChangePerspCommande;
import org.example.log121tp5.Modele.Commande.SavePerspCommande;
import org.example.log121tp5.Modele.Conteneur.ConteneurModele;
import org.example.log121tp5.Modele.GestionnaireCommande;
import org.example.log121tp5.Modele.Commande.ChangeImageCommande;
import org.example.log121tp5.Modele.Commande.Commande;
import org.example.log121tp5.Modele.Conteneur.ConteneurSubject;
import org.example.log121tp5.Modele.Conteneur.ConteneurObserver;
import org.example.log121tp5.Modele.Sauvegarde.SauvegardePerspective;
import org.example.log121tp5.Vue.AffichageVue;

import java.io.FileNotFoundException;

public class Controleur {

    private AffichageVue affichageVue;
    private AffichageModele affichageModele;

    private GestionnaireCommande gestionnaireCommande = GestionnaireCommande.getInstance();
    private ConteneurSubject conteneurSubject;
    private ConteneurObserver conteneurObserver1;
    private ConteneurObserver conteneurObserver2;

    private ConteneurModele conteneurModele;

    public AffichageVue getAffichageVue() {
        return affichageVue;
    }

    public void setAffichageVue(AffichageVue affichageVue) {
        this.affichageVue = affichageVue;
    }

    public AffichageModele getAffichageModele() {
        return affichageModele;
    }

    public void setAffichageModele(AffichageModele affichageModele) {
        this.affichageModele = affichageModele;
    }

    public void setOnClickListenerChangerImage()  {
        Commande commande = new ChangeImageCommande(this);
        gestionnaireCommande.commandeExecute(commande);
    }

    public void setOnClickListenerSauvegardePersp()  {
        Commande commande = new SavePerspCommande(this);
        gestionnaireCommande.commandeExecute(commande);
    }

    public void setOnClickListenerChangePersp()  {
        Commande commande = new ChangePerspCommande(this);
        gestionnaireCommande.commandeExecute(commande);
    }

    public ConteneurSubject getConteneur() {
        return conteneurSubject;
    }

    public void setConteneur(ConteneurSubject conteneurSubject) {
        this.conteneurSubject = conteneurSubject;
    }

    public ConteneurSubject getConteneurSubject() {
        return conteneurSubject;
    }

    public void setConteneurSubject(ConteneurSubject conteneurSubject) {
        this.conteneurSubject = conteneurSubject;
    }

    public ConteneurObserver getConteneurObserver1() {
        return conteneurObserver1;
    }

    public void setConteneurObserver1(ConteneurObserver conteneurObserver1) {
        this.conteneurObserver1 = conteneurObserver1;
    }

    public ConteneurObserver getConteneurObserver2() {
        return conteneurObserver2;
    }

    public void setConteneurObserver2(ConteneurObserver conteneurObserver2) {
        this.conteneurObserver2 = conteneurObserver2;
    }

    public ConteneurModele getConteneurModele() {
        return conteneurModele;
    }

    public void setConteneurModele(ConteneurModele conteneurModele) {
        this.conteneurModele = conteneurModele;
    }
}
