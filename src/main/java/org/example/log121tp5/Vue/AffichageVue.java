package org.example.log121tp5.Vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import org.example.log121tp5.Controleur.ControleurCommandes;

public class AffichageVue extends BorderPane {

    public AffichageVue(ControleurCommandes controleurCommandes) {
        // on met la nav bar toute en haut
        setTop(new BarreNavVue(controleurCommandes));

        HBox conteneurGlobal = new HBox();
        conteneurGlobal.setAlignment(Pos.CENTER);
        conteneurGlobal.setSpacing(0);
        conteneurGlobal.setPadding(Insets.EMPTY);

        ConteneurVue cont1 = controleurCommandes.getConteneurSubject().getCont();
        ConteneurVue cont2 = controleurCommandes.getConteneurObserver1().getCont();
        ConteneurVue cont3 = controleurCommandes.getConteneurObserver2().getCont();
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

}