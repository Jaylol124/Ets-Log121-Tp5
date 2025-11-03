package org.example.log121tp5;

import org.example.log121tp5.Controleur.Controleur;
import org.example.log121tp5.Vue.AffichageVue;
import org.example.log121tp5.Modele.AffichageModele;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.example.log121tp5.Modele.AffichageModele;

public class App extends Application {

    private Controleur controleur = new Controleur();
    @Override
    public void start(Stage primaryStage) {

        // Lier le controleur au different module
        AffichageModele affichageModele = new AffichageModele();
        controleur.setAffichageModele(affichageModele);
        affichageModele.setControleur(controleur);
        /////
        AffichageVue affichageVue = new AffichageVue();
        controleur.setAffichageVue(affichageVue);
        affichageVue.setControleur(controleur);
        /////

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(8);
        grid.setVgap(8);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}