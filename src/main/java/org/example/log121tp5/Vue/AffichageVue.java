package org.example.log121tp5.Vue;

import org.example.log121tp5.Controleur.Controleur;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class AffichageVue extends HBox{

    private Controleur controleur;

    public AffichageVue() {

        VBox navBar = new VBox(new BarreNavVue());

        navBar.setPrefWidth(800);
        VBox.setVgrow(navBar, Priority.ALWAYS);
        this.getChildren().add(navBar);
    }

    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }
}