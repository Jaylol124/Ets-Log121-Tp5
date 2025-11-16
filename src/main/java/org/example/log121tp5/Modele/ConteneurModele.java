package org.example.log121tp5.Modele;

import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class ConteneurModele extends StackPane {
    private ImageView imageView = new ImageView();

    public ConteneurModele(String couleur) {
        setStyle(
                "-fx-background-color: rgba(255,255,255,0.35);" +
                        "-fx-border-color: " + couleur + ";" +
                        "-fx-border-width: 3;"

        );

        //mettre l'image au millieu
        setAlignment(Pos.CENTER);
        setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        // rendre plus belle l'image
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);

        imageView.fitWidthProperty().bind(
                Bindings.min(widthProperty(), heightProperty()).multiply(0.9)
        );

        getChildren().add(imageView);
    }

    public void setImage(String resourcePath) {
        Image img = new Image(getClass().getResource(resourcePath).toExternalForm());
        imageView.setImage(img);
    }

    public void setImageDepuisUrlFichier(String Url) {
        Image img = new Image(Url);
        imageView.setImage(img);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImage(ImageView image) {
        imageView = image;
    }
}