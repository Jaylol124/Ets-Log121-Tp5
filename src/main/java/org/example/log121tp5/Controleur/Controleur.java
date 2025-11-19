package org.example.log121tp5.Controleur;

import org.example.log121tp5.Modele.AffichageModele;
import org.example.log121tp5.Modele.Conteneur1;
import org.example.log121tp5.Modele.Conteneur2;
import org.example.log121tp5.Modele.Conteneur3;
import org.example.log121tp5.Modele.GestionnaireCommande;
import org.example.log121tp5.Modele.Commande.ChangeImageCommande;
import org.example.log121tp5.Modele.Commande.Commande;
import org.example.log121tp5.Modele.Conteneur.ConteneurSubject;
import org.example.log121tp5.Modele.Conteneur.ConteneurObserver;
import org.example.log121tp5.Vue.AffichageVue;

public class Controleur {

    private AffichageVue affichageVue;
    private AffichageModele affichageModele;

    private Conteneur1 conteneur1;
    private Conteneur2 conteneur2;
    private Conteneur3 conteneur3;

    private GestionnaireCommande gestionnaireCommande = GestionnaireCommande.getInstance();
    private ConteneurSubject conteneurSubject;
    private ConteneurObserver conteneurObserver1;
    private ConteneurObserver conteneurObserver2;

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

    public void setOnClickListenerChangerImage(){
        Commande commande = new ChangeImageCommande(this);
        gestionnaireCommande.commandeExecute(commande);
    }

    public ConteneurSubject getConteneur1() {
        return conteneurSubject;
    }

    public void setConteneur1(ConteneurSubject conteneurSubject) {
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
}
