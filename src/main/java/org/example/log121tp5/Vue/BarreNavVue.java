package org.example.log121tp5.Vue;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.FileChooser;

import java.io.File;

import org.example.log121tp5.Controleur.Controleur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;

/*
 * Classe representant la barre de navigation de l'application
 * qui herite de MenuBar de JavaFX 
 */
public class BarreNavVue extends MenuBar{
    private Menu fichierMenu;
    private Menu editionMenu;
    private Menu pressePapier;

    private Controleur controleurCommandes;


    public BarreNavVue(Controleur controleurCommandes) {
        
        this.controleurCommandes = controleurCommandes;

        this.setWidth(getLayoutX());

        this.fichierMenu  = new Menu("Fichier");
        this.editionMenu  = new Menu("Edition");
        this.pressePapier = new Menu("Presse-papier");
        bindMenuItems();
        
        this.getMenus().addAll(fichierMenu, editionMenu, pressePapier);
    }

    /*
     * Methode pour lier les items de menu aux actions correspondantes
     */
    private void bindMenuItems() {
        // Ajout des items au menu Fichier
        this.fichierMenu.getItems().addAll(

            // --- SAUVEGARDER PERSPECTIVE ---
            creerItemMenu("Sauvegarder Perpective", e -> {
                String uri = getFileFromFileChooser(
                    "Sauvegarder Perspectives",
                    "Perspective",
                    new String[]{"*.Perspective"});
                controleurCommandes.setOnClickListenerSauvegardePersp(uri);
            }),

            // --- CHANGER PERSPECTIVE ---
            creerItemMenu("Changer Perpective", e -> {
                String uri = getFileFromFileChooser(
                    "Ouvrir Perspectives",
                    "Perspective",
                    new String[]{"*.Perspective"});
                controleurCommandes.setOnClickListenerChangePersp(uri);
            }),
            new SeparatorMenuItem(),

            // --- CHANGER IMAGE ---
            creerItemMenu("Changer Image", e -> {
                String uri = getFileFromFileChooser(
                    "Choisir Image",
                    "Image Files",
                    new String[]{"*.png", "*.jpg", "*.jpeg"});
                controleurCommandes.setOnClickListenerChangerImage(uri);
            }),
            new SeparatorMenuItem(),

            // --- QUITTER ---
            creerItemMenu("Quitter", e -> System.exit(0))
        );

        // Ajout des items au menu Edition
        this.editionMenu.getItems().addAll(

            // --- DEFAIRE ---
            creerItemMenu("Défaire", e -> controleurCommandes.setOnClickListenerUndo()),
            new SeparatorMenuItem(),

            // --- REFAIRE ---
            creerItemMenu("Refaire", e -> controleurCommandes.setOnClickListenerRedo())
        );

        // Ajout des items au menu Presse-papier
        this.pressePapier.getItems().addAll(

            // --- CHOISIR STRATEGIE ---   
            creerItemMenu("Choisir Stratégie", e -> System.out.println("choisir une stratégie"))
        );
    }

    /**
     * Methode utilitaire pour ouvrir un FileChooser 
     * et retourner le fichier selectionne
     * @return Le fichier selectionne ou {@code null} si aucun fichier n'a ete selectionne
    */
    public String getFileFromFileChooser(String titre, String fileType, String[] filter) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(titre);
        fileChooser.getExtensionFilters().add(
            new FileChooser.ExtensionFilter(fileType, filter)
    );

    File file = (titre.equals("Sauvegarder Perspectives")) ?
                 fileChooser.showSaveDialog(null) : 
                 fileChooser.showOpenDialog(null);

    return (file == null) ? null : file.getAbsolutePath();
}

    /**
     *  Methode utilitaire pour creer un item de menu avec une action associee
     *  @param nom Le nom de l'item de menu
     *  @param action L'action a executer lors du clic sur l'item
     *  @return L'item de menu cree
     */
    private MenuItem creerItemMenu(String nom, EventHandler<ActionEvent> action) {
        MenuItem item = new MenuItem(nom);
        item.setOnAction(action);
        return item;
    }
}
