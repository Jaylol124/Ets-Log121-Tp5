package org.example.log121tp5.Vue;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

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

    private Controleur controleur;

    public BarreNavVue(Controleur controleur) {
        this.setWidth(getLayoutX());

        this.fichierMenu = new Menu("Fichier");
        this.editionMenu = new Menu("Edition");
        this.pressePapier = new Menu("Presse-papier");
        bindMenuItems();
        
        this.getMenus().addAll(fichierMenu, editionMenu, pressePapier);

        this.controleur = controleur;
    }

    /*
     * Methode pour lier les items de menu aux actions correspondantes
     */
    private void bindMenuItems() {
        // Ajout des items au menu Fichier
        this.fichierMenu.getItems().addAll(
            creerItemMenu("Sauvegarder Perpective", e -> System.out.println("Sauvegarder Perpectives")),
            creerItemMenu("Changer Perpective", e -> System.out.println("Ouvrir un fichier")),
            new SeparatorMenuItem(),
            creerItemMenu("Changer Image", e -> {
                System.out.println("Changer l'image affichee");
                controleur.setOnClickListenerChangerImage();
            }),
            new SeparatorMenuItem(),
            creerItemMenu("Quitter", e -> System.exit(0))
        );

        // Ajout des items au menu Edition
        this.editionMenu.getItems().addAll(
            creerItemMenu("Défaire", e -> System.out.println("Défaire la derniere action")),
            new SeparatorMenuItem(),
            creerItemMenu("Refaire", e -> System.out.println("Refaire la derniere action"))
        );

        // Ajout des items au menu Presse-papier
        this.pressePapier.getItems().addAll(
            creerItemMenu("Choisir Stratégie", e -> System.out.println("choisir une stratégie"))
        );
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
