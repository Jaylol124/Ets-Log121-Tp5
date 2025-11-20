package org.example.log121tp5.Vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import org.example.log121tp5.Controleur.Controleur;
import org.example.log121tp5.Modele.Conteneur.ConteneurModele;

public class AffichageVue extends BorderPane {

    private Controleur controleur;

    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }

    public AffichageVue(Controleur controleur) {
        this.controleur = controleur;
        // on met la nav bar toute en haut
        setTop(new BarreNavVue(this.controleur));

        HBox conteneurGlobal = new HBox();
        conteneurGlobal.setAlignment(Pos.CENTER);
        conteneurGlobal.setSpacing(0);
        conteneurGlobal.setPadding(Insets.EMPTY);

        ConteneurModele cont1 = this.controleur.getConteneur().getCont();
        ConteneurModele cont2 = this.controleur.getConteneurObserver1().getCont();
        ConteneurModele cont3 = this.controleur.getConteneurObserver2().getCont();

        conteneurGlobal.getChildren().addAll(cont1, cont2, cont3);

        StackPane center = new StackPane(conteneurGlobal);
        center.setPadding(Insets.EMPTY);
        StackPane.setAlignment(conteneurGlobal, Pos.CENTER);
        setCenter(center);

        //largeur 1/3 de StackPane
        cont1.prefWidthProperty().bind(center.widthProperty().divide(conteneurGlobal.getChildren().size()));
        cont2.prefWidthProperty().bind(center.widthProperty().divide(conteneurGlobal.getChildren().size()));
        cont3.prefWidthProperty().bind(center.widthProperty().divide(conteneurGlobal.getChildren().size()));

        //toute la hauteur
        cont1.prefHeightProperty().bind(center.heightProperty());
        cont2.prefHeightProperty().bind(center.heightProperty());
        cont3.prefHeightProperty().bind(center.heightProperty());
    }
}