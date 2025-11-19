package org.example.log121tp5;

import org.example.log121tp5.Controleur.Controleur;
import org.example.log121tp5.Modele.Conteneur.ConteneurSubject;
import org.example.log121tp5.Modele.Conteneur.ConteneurObserver;
import org.example.log121tp5.Vue.AffichageVue;
import org.example.log121tp5.Modele.AffichageModele;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class App extends Application {

    private Controleur controleur = new Controleur();
    @Override
    public void start(Stage stage) {
        
        // Lier le controleur au different module
        AffichageModele affichageModele = new AffichageModele();
        controleur.setAffichageModele(affichageModele);

        /////
        ConteneurSubject conteneurSubject = new ConteneurSubject();
        controleur.setConteneur1(conteneurSubject);

        ConteneurObserver conteneurObserver1 = new ConteneurObserver();
        controleur.setConteneurObserver1(conteneurObserver1);

        ConteneurObserver conteneurObserver2 = new ConteneurObserver();
        controleur.setConteneurObserver2(conteneurObserver2);

        // pour patron observer
        conteneurSubject.attach(conteneurObserver1);
        conteneurSubject.attach(conteneurObserver2);
        ///
        AffichageVue affichageVue = new AffichageVue(controleur);
        controleur.setAffichageVue(affichageVue);
        affichageVue.setControleur(controleur);
        /////

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(8);
        grid.setVgap(8);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setStyle("--fx-background-color: #812323ff;");
        
    
        stage.setTitle("Image avec Perpectives");

        Scene scene = new Scene(affichageVue, 800, 400);
        scene.setFill(Paint.valueOf("#010461ff"));
        stage.setScene(scene);

        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}