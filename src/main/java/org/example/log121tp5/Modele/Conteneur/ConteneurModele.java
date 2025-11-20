package org.example.log121tp5.Modele.Conteneur;

import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

/*
 * 
 */
public class ConteneurModele extends StackPane {
    private ImageView imageView = new ImageView();

    public ConteneurModele(String couleur) {
        setStyle(
                "-fx-background-color: rgba(255,255,255,0.35);" +
                "-fx-border-color: " + couleur + ";" +
                "-fx-border-width: 3;"

        );

        // Image centrée
        setAlignment(Pos.CENTER);
        setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        // 🔹 CLIP pour empêcher de déborder sur les autres conteneurs
        Rectangle clip = new Rectangle();
        clip.widthProperty().bind(widthProperty());
        clip.heightProperty().bind(heightProperty());
        setClip(clip);

        // Image plus belle
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);


        imageView.fitWidthProperty().bind(
                Bindings.min(widthProperty(), heightProperty()).multiply(0.6)
        );

        getChildren().add(imageView);

        enableDrag();
        enableZoom();
    }

    //changer l'image avec le path
    public void setImage(String resourcePath) {
        Image img = new Image(getClass().getResource(resourcePath).toExternalForm());
        imageView.setImage(img);
    }
    //changer l'image avec l'url du fichier
    public void setImageDepuisUrlFichier(String Url) {
        Image img = new Image("file:" + Url);
        imageView.setImage(img);
    }
    //getteur de l'imageview
    public ImageView getImageView() {
        return imageView;
    }

    //setteur de l'imageview
    public void setImage(Image image) {
        imageView.setImage(image);
    }

    // pour bouger image a modifier
    public void enableDrag() {
        final double[] mouseAnchorX = new double[1];
        final double[] mouseAnchorY = new double[1];
        final double[] initialTranslateX = new double[1];
        final double[] initialTranslateY = new double[1];

        imageView.setOnMousePressed(event -> {
            mouseAnchorX[0] = event.getSceneX();
            mouseAnchorY[0] = event.getSceneY();
            initialTranslateX[0] = imageView.getTranslateX();
            initialTranslateY[0] = imageView.getTranslateY();
        });

        imageView.setOnMouseDragged(event -> {
            double dx = event.getSceneX() - mouseAnchorX[0];
            double dy = event.getSceneY() - mouseAnchorY[0];

            imageView.setTranslateX(initialTranslateX[0] + dx);
            imageView.setTranslateY(initialTranslateY[0] + dy);
        });
    }

    // pour zoomer a modifier
    private void enableZoom() {
        setOnScroll(event -> {
            double zoomFactor = 1.1;
            if (event.getDeltaY() < 0) {
                zoomFactor = 1 / zoomFactor;
            }

            imageView.setScaleX(imageView.getScaleX() * zoomFactor);
            imageView.setScaleY(imageView.getScaleY() * zoomFactor);
        });
    }
}
