package org.example.log121tp5;

import org.example.log121tp5.Controleur.ControleurCommandes;
import org.example.log121tp5.Modele.Conteneur.ConteneurSubject;
import org.example.log121tp5.Modele.Conteneur.ConteneurObserver;
import org.example.log121tp5.Vue.AffichageVue;
import org.example.log121tp5.Vue.ConteneurVue;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class App extends Application {

    private ControleurCommandes controleurCommandes;
    @Override
    public void start(Stage stage) {
        
        ConteneurVue cv = new ConteneurVue("blue", true);

        controleurCommandes = new ControleurCommandes(
            cv,
            new ConteneurSubject(),
            new ConteneurObserver(),
            new ConteneurObserver()
        );
    
        AffichageVue affichageVue = new AffichageVue(controleurCommandes);
        controleurCommandes.setAffichageVue(affichageVue);
        /////

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(8);
        grid.setVgap(8);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setStyle("--fx-background-color: #812323ff;");
        
        grid.add(cv,0,0);
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