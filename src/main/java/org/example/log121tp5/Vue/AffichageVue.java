package org.example.log121tp5.Vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import org.example.log121tp5.Controleur.Controleur;

public class AffichageVue extends BorderPane {

    private Controleur controleur;


    public AffichageVue() {
        //Barre de navigation en haut
        setTop(new BarreNavVue());

        //HBox contenant les 3 conteneurs ce situe direct en bas de navigation
        HBox conteneurGlobal = new HBox();
        conteneurGlobal.setAlignment(Pos.CENTER);
        conteneurGlobal.setSpacing(0);
        conteneurGlobal.setPadding(Insets.EMPTY);

        ConteneurVue cont1 = new ConteneurVue("gray");
        ConteneurVue cont2 = new ConteneurVue("#1e90ff");
        ConteneurVue cont3 = new ConteneurVue("#1e90ff");

        conteneurGlobal.getChildren().addAll(cont1, cont2, cont3);

        //pour centrer horizontalement les conteneur
        StackPane center = new StackPane(conteneurGlobal);
        center.setPadding(Insets.EMPTY); // aucun padding
        StackPane.setAlignment(conteneurGlobal, Pos.CENTER);
        setCenter(center);

        //pour que chaque conteneur prenne 1/3 de la largeur donc change quand on agrandit la page
        conteneurGlobal.widthProperty().addListener((obs, oldVal, newVal) -> {
            double largeur = newVal.doubleValue() / 3;
            cont1.setPrefWidth(largeur);
            cont2.setPrefWidth(largeur);
            cont3.setPrefWidth(largeur);
        });

        //Hauteur
        cont1.prefHeightProperty().bind(center.heightProperty());
        cont2.prefHeightProperty().bind(center.heightProperty());
        cont3.prefHeightProperty().bind(center.heightProperty());
    }

    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }
}