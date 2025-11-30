package org.example.log121tp5.Vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;

import org.example.log121tp5.Controleur.Controleur;
import org.example.log121tp5.Modele.ConteneurObserver;
import org.example.log121tp5.Modele.ConteneurSubject;

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

        // initialiser les interactions (deplacer/zoom)
        controleurCommandes.deplacerImageCommande(new ConteneurObserver[]{conteneurObserver1, conteneurObserver2});

        conteneurObserver1.initialiserInteractions();
        conteneurObserver2.initialiserInteractions();

        // on met la nav bar toute en haut
        setTop(new BarreNavVue(controleurCommandes));

        HBox conteneurGlobal = new HBox();
        conteneurGlobal.setAlignment(Pos.CENTER);
        conteneurGlobal.setSpacing(0);
        conteneurGlobal.setPadding(Insets.EMPTY);

        ConteneurVue conteneurSubjectVue = conteneurSubject.getVue();
        ConteneurVue conteneurObserverVue1 = conteneurObserver1.getVue();
        ConteneurVue conteneurObserverVue2 = conteneurObserver2.getVue();

        conteneurGlobal.getChildren().addAll(conteneurSubjectVue, conteneurObserverVue1, conteneurObserverVue2);

        StackPane center = new StackPane(conteneurGlobal);
        center.setPadding(Insets.EMPTY);
        StackPane.setAlignment(conteneurGlobal, Pos.CENTER);
        setCenter(center);

        //largeur 1/3 de StackPane
        conteneurSubjectVue.prefWidthProperty().bind(center.widthProperty().divide(3));
        conteneurObserverVue1.prefWidthProperty().bind(center.widthProperty().divide(3));
        conteneurObserverVue2.prefWidthProperty().bind(center.widthProperty().divide(3));

        //toute la hauteur
        conteneurSubjectVue.prefHeightProperty().bind(center.heightProperty());
        conteneurObserverVue1.prefHeightProperty().bind(center.heightProperty());
        conteneurObserverVue2.prefHeightProperty().bind(center.heightProperty());
    }
}
