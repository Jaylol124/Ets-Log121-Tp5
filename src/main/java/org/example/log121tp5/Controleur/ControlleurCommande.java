package org.example.log121tp5.Controleur;
import org.example.log121tp5.Controleur.Commande.*;

import org.example.log121tp5.Modele.AffichageModele;
import org.example.log121tp5.Vue.AffichageVue;
import org.example.log121tp5.Vue.BarreNavVue;

public class ControlleurCommande {
    private AffichageVue affichageVue;
    private BarreNavVue barreNavVue;
    private AffichageModele affichageModele;

    private Commande savePerspCommande = new SavePerspCommande();


    public ControlleurCommande(AffichageVue affichageVue,
                               AffichageModele affichageModele,
                               BarreNavVue barreNavVue) {
        this.affichageVue = affichageVue;
        this.affichageModele = affichageModele;
        this.barreNavVue = barreNavVue;

    }
    
    public void savePersp() {
        savePerspCommande.execute();
    }
}
