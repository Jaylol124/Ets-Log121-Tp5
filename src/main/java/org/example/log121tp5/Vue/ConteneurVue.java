package org.example.log121tp5.Vue;

import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

public class ConteneurVue extends Region {
    public ConteneurVue(String couleur) {
        setStyle(
                "-fx-background-color: rgba(255,255,255,0.35);" +
                        "-fx-border-color: " + couleur + ";" +
                        "-fx-border-width: 3;"
        );
        setMaxHeight(Double.MAX_VALUE);
    }
}