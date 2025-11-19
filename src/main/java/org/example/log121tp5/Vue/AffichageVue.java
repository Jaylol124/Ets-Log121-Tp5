package org.example.log121tp5.Vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import org.example.log121tp5.Controleur.Controleur;
import org.example.log121tp5.Modele.Conteneur1;
import org.example.log121tp5.Modele.Conteneur2;
import org.example.log121tp5.Modele.Conteneur3;
import org.example.log121tp5.Modele.ConteneurModele;

public class AffichageVue extends BorderPane {

    private Controleur controleur;


    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }

    public AffichageVue(Controleur controleur) {
        // on met la nav bar toute en haut
        setTop(new BarreNavVue());

        HBox conteneurGlobal = new HBox();
        conteneurGlobal.setAlignment(Pos.CENTER);
        conteneurGlobal.setSpacing(0);
        conteneurGlobal.setPadding(Insets.EMPTY);



        ConteneurModele cont1 = controleur.getConteneur1().getCont();
        ConteneurModele cont2 = controleur.getConteneur2().getCont();
        ConteneurModele cont3 = controleur.getConteneur3().getCont();

//        ConteneurModele cont1 = new ConteneurModele("gray");
//        ConteneurModele cont2 = new ConteneurModele("#1e90ff");
//        ConteneurModele cont3 = new ConteneurModele("#1e90ff");



        // image par default pour tester. on va changer les prochains conteneur avec observer dans le futur
        //cont1.setImage("/images/blackrizz.png");
        //controleur.getConteneur1().changementImage();

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