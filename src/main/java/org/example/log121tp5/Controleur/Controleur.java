package org.example.log121tp5.Controleur;

//import com.example.Modele.AffichageModele;
//import com.example.Vue.AffichageVue;

import org.example.log121tp5.Modele.AffichageModele;
import org.example.log121tp5.Modele.Conteneur1;
import org.example.log121tp5.Modele.Conteneur2;
import org.example.log121tp5.Modele.Conteneur3;
import org.example.log121tp5.Vue.AffichageVue;

public class Controleur {

    private AffichageVue affichageVue;
    private AffichageModele affichageModele;

    private Conteneur1 conteneur1;
    private Conteneur2 conteneur2;
    private Conteneur3 conteneur3;

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

    public Conteneur1 getConteneur1() {
        return conteneur1;
    }

    public Conteneur2 getConteneur2() {
        return conteneur2;
    }

    public Conteneur3 getConteneur3() {
        return conteneur3;
    }

    public void setConteneur1(Conteneur1 conteneur1) {
        this.conteneur1 = conteneur1;
    }

    public void setConteneur2(Conteneur2 conteneur2) {
        this.conteneur2 = conteneur2;
    }

    public void setConteneur3(Conteneur3 conteneur3) {
        this.conteneur3 = conteneur3;
    }
}
