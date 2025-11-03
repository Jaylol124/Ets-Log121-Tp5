package org.example.log121tp5.Controleur;

//import com.example.Modele.AffichageModele;
//import com.example.Vue.AffichageVue;

import org.example.log121tp5.Modele.AffichageModele;
import org.example.log121tp5.Vue.AffichageVue;

public class Controleur {

    private AffichageVue affichageVue;
    private AffichageModele affichageModele;

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
}
