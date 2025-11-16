package org.example.log121tp5;

import org.example.log121tp5.Controleur.Controleur;
import org.example.log121tp5.Modele.Conteneur1;
import org.example.log121tp5.Modele.Conteneur2;
import org.example.log121tp5.Modele.Conteneur3;
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
        affichageModele.setControleur(controleur);
        /////
        AffichageVue affichageVue = new AffichageVue();
        controleur.setAffichageVue(affichageVue);
        affichageVue.setControleur(controleur);
        /////
        Conteneur1 conteneur1 = new Conteneur1();
        controleur.setConteneur1(conteneur1);

        Conteneur2 conteneur2 = new Conteneur2();
        controleur.setConteneur2(conteneur2);

        Conteneur3 conteneur3 = new Conteneur3();
        controleur.setConteneur3(conteneur3);

        // pour patron observer
        conteneur1.attach(conteneur2);
        conteneur1.attach(conteneur3);
        //////

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