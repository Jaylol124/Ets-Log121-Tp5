package org.example.log121tp5.Controleur;

import org.example.log121tp5.Modele.GestionnaireCommande;
import org.example.log121tp5.Modele.Commande.ChangeImageCommande;
import org.example.log121tp5.Modele.Commande.ChangePerspCommande;
import org.example.log121tp5.Modele.Commande.Commande;
import org.example.log121tp5.Modele.Commande.DeplacerImageCommande;
import org.example.log121tp5.Modele.Commande.SavePerspCommande;
import org.example.log121tp5.Modele.Commande.RedoCommande;
import org.example.log121tp5.Modele.Commande.UndoCommande;
import org.example.log121tp5.Modele.Commande.ZoomCommande;
import org.example.log121tp5.Vue.ConteneurObserver;
import org.example.log121tp5.Vue.ConteneurSubject;

import javafx.scene.input.ScrollEvent;

public class Controleur {

    private final GestionnaireCommande gestionnaireCommande = GestionnaireCommande.getInstance();

    private ConteneurSubject conteneurSubject;
    private ConteneurObserver conteneurObserver1;
    private ConteneurObserver conteneurObserver2;

    public void setConteneurs(ConteneurSubject conteneurSubject,
                              ConteneurObserver conteneurObserver1,
                              ConteneurObserver conteneurObserver2) {
        this.conteneurSubject = conteneurSubject;
        this.conteneurObserver1 = conteneurObserver1;
        this.conteneurObserver2 = conteneurObserver2;
    }


    // --- METHODES DES COMMANDES DANS LE MENU ---

    public void setOnClickListenerChangerImage(String uri) { 
        if (uri == null || conteneurSubject == null) return;
        Commande commande = new ChangeImageCommande(conteneurSubject, uri);
        gestionnaireCommande.commandeExecute(commande);
    }

    public void setOnClickListenerSauvegardePersp(String uri) { 
        if (uri == null || conteneurObserver1 == null || conteneurObserver2 == null) return;
        Commande commande = new SavePerspCommande(uri, conteneurObserver1, conteneurObserver2);
        gestionnaireCommande.commandeExecute(commande);
    }

    public void setOnClickListenerChangePersp(String uri) { 
        if (uri == null || conteneurObserver1 == null || conteneurObserver2 == null) return;
        Commande commande = new ChangePerspCommande(uri, conteneurObserver1, conteneurObserver2);
        gestionnaireCommande.commandeExecute(commande);
    }

    public void setOnClickListenerUndo() {
        if (conteneurObserver1 == null || conteneurObserver2 == null) return;
        Commande commande = new UndoCommande(conteneurObserver1, conteneurObserver2);
        gestionnaireCommande.commandeExecute(commande);
    }

    public void setOnClickListenerRedo() {
        if (conteneurObserver1 == null || conteneurObserver2 == null) return;
        Commande commande = new RedoCommande(conteneurObserver1, conteneurObserver2);
        gestionnaireCommande.commandeExecute(commande);
    }

    // --- METHODES DES COMMANDES DEPLACEMENT ET ZOOM ---

    public void deplacerImageCommande(ConteneurObserver cible, ConteneurObserver autre) {
        Commande comande = new DeplacerImageCommande(cible, autre);
        gestionnaireCommande.commandeExecute(comande);
    }

    public void zoomerImageCommande(ConteneurObserver conteneur, ConteneurObserver autre, ScrollEvent event) {
        Commande commande = new ZoomCommande(conteneur, autre, event);
        gestionnaireCommande.commandeExecute(commande);
    }
}
