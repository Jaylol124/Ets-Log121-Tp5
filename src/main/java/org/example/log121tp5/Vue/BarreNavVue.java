package org.example.log121tp5.Vue;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.FileChooser;

import org.example.log121tp5.Controleur.ControleurCommandes;
import org.example.log121tp5.Modele.Commande.ChangeImageCommande;

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
    private ControleurCommandes controleurCommandes;

    public BarreNavVue(ControleurCommandes controleurCommandes) {
        
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
                System.out.println("Sauvegarder Perpectives");
            }),

            // --- CHANGER PERSPECTIVE ---
            creerItemMenu("Changer Perpective", e -> {
                System.out.println("Ouvrir un fichier");
            }),
            new SeparatorMenuItem(),

            // --- CHANGER IMAGE ---
            creerItemMenu("Changer Image", e -> {
                String uri = getFileFromFileChooser();
                new ChangeImageCommande(controleurCommandes.getConteneurSubject(), uri).execute();
                System.out.println("Changer l'image affichee");
            }),
            new SeparatorMenuItem(),

            // --- QUITTER ---
            creerItemMenu("Quitter", e -> System.exit(0))
        );

        // Ajout des items au menu Edition
        this.editionMenu.getItems().addAll(

            // --- DEFAIRE ---
            creerItemMenu("Défaire", e -> System.out.println("Défaire la derniere action")),
            new SeparatorMenuItem(),

            // --- REFAIRE ---
            creerItemMenu("Refaire", e -> System.out.println("Refaire la derniere action"))
        );

        // Ajout des items au menu Presse-papier
        this.pressePapier.getItems().addAll(

            // --- CHOISIR STRATEGIE ---   
            creerItemMenu("Choisir Stratégie", e -> System.out.println("choisir une stratégie"))
        );
    }

    /*
     * Methode utilitaire pour ouvrir un FileChooser 
     * et retourner le fichier selectionne
     * @return Le fichier selectionne ou null si aucun fichier n'a ete selectionne
    */
    public String getFileFromFileChooser() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir une image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        ); 
        return fileChooser.showOpenDialog(null).getPath().toString();
    }

    /*
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
