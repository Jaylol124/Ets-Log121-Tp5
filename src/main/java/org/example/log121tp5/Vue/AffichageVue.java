package org.example.log121tp5.Vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import org.example.log121tp5.Controleur.Controleur;

public class AffichageVue extends BorderPane {

    private Controleur controleur;


    public AffichageVue() {
        // on met la nav bar toute en haut
        setTop(new BarreNavVue());

        HBox conteneurGlobal = new HBox();
        conteneurGlobal.setAlignment(Pos.CENTER);
        conteneurGlobal.setSpacing(0);
        conteneurGlobal.setPadding(Insets.EMPTY);

        ConteneurVue cont1 = new ConteneurVue("gray");
        ConteneurVue cont2 = new ConteneurVue("#1e90ff");
        ConteneurVue cont3 = new ConteneurVue("#1e90ff");

        // image par default pour tester. on va changer les prochains conteneur avec observer dans le futur
        cont1.setImage("/images/blackrizz.png");

        conteneurGlobal.getChildren().addAll(cont1, cont2, cont3);

        StackPane center = new StackPane(conteneurGlobal);
        center.setPadding(Insets.EMPTY);
        StackPane.setAlignment(conteneurGlobal, Pos.CENTER);
        setCenter(center);

        //largeur 1/3 de StackPane
        cont1.prefWidthProperty().bind(center.widthProperty().divide(3));
        cont2.prefWidthProperty().bind(center.widthProperty().divide(3));
        cont3.prefWidthProperty().bind(center.widthProperty().divide(3));

        //toute la hauteur
        cont1.prefHeightProperty().bind(center.heightProperty());
        cont2.prefHeightProperty().bind(center.heightProperty());
        cont3.prefHeightProperty().bind(center.heightProperty());
    }


    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }
}