package org.example.log121tp5.Vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;

import org.example.log121tp5.Controleur.Controleur;

public class AffichageVue extends BorderPane {

    private ConteneurSubject conteneurSubject;
        
    private ConteneurObserver conteneurObserver1;
    private ConteneurObserver conteneurObserver2;

    public AffichageVue(Controleur controleurCommandes){
        conteneurSubject = new ConteneurSubject();
        
        conteneurObserver1 = new ConteneurObserver(controleurCommandes);
        conteneurObserver2 = new ConteneurObserver(controleurCommandes);

        controleurCommandes.setConteneurs(conteneurSubject, conteneurObserver1, conteneurObserver2);

        // on attache les observers au subject
        conteneurSubject.addObserver(conteneurObserver1);
        conteneurSubject.addObserver(conteneurObserver2);

        conteneurObserver1.initialiserInteractions(conteneurObserver2);
        conteneurObserver2.initialiserInteractions(conteneurObserver1);

        // on met la nav bar toute en haut
        setTop(new BarreNavVue(controleurCommandes));

        HBox conteneurGlobal = new HBox();
        conteneurGlobal.setAlignment(Pos.CENTER);
        conteneurGlobal.setSpacing(0);
        conteneurGlobal.setPadding(Insets.EMPTY);

        conteneurGlobal.getChildren().addAll(conteneurSubject, conteneurObserver1, conteneurObserver2);

        StackPane center = new StackPane(conteneurGlobal);
        center.setPadding(Insets.EMPTY);
        StackPane.setAlignment(conteneurGlobal, Pos.CENTER);
        setCenter(center);

        //largeur 1/3 de StackPane
        conteneurSubject.prefWidthProperty().bind(center.widthProperty().divide(3));
        conteneurObserver1.prefWidthProperty().bind(center.widthProperty().divide(3));
        conteneurObserver2.prefWidthProperty().bind(center.widthProperty().divide(3));

        //toute la hauteur
        conteneurSubject.prefHeightProperty().bind(center.heightProperty());
        conteneurObserver1.prefHeightProperty().bind(center.heightProperty());
        conteneurObserver2.prefHeightProperty().bind(center.heightProperty());
    }
}
