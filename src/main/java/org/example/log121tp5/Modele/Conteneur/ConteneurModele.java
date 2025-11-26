package org.example.log121tp5.Modele.Conteneur;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ConteneurModele extends StackPane {
    private final ImageView imageView = new ImageView();
    private final StackPane content = new StackPane(); // pane interne qui sera clipé
    public ConteneurModele(String couleur, boolean estBougeable) {

        setStyle("-fx-background-color: rgba(255,255,255,0.35);");

        //le contour
        setBorder(new Border(new BorderStroke(
                Color.web(couleur),
                BorderStrokeStyle.SOLID,
                new CornerRadii(0),
                new BorderWidths(3)
        )));

        content.setAlignment(Pos.CENTER);
        content.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        //view qui contient l'image
        Rectangle clip = new Rectangle();
        clip.widthProperty().bind(content.widthProperty());
        clip.heightProperty().bind(content.heightProperty());
        content.setClip(clip);


        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);

        imageView.fitWidthProperty().bind(
                Bindings.min(content.widthProperty(), content.heightProperty()).multiply(0.6)
        );

        // ajout de l'image
        content.getChildren().add(imageView);
        // ajout du conteneur de l'image au conteneur principal
        getChildren().add(content);

        if(estBougeable)
        {
            bougerVerticalHorizontal();
            zoomer();
        }

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

    // pour bouger image
    public void bougerVerticalHorizontal() {
        double[] posSouriX = new double[1];
        double[] posSouriY = new double[1];
        double[] posImgX = new double[1];
        double[] posImgY = new double[1];

        imageView.setOnMousePressed(event -> {
            posSouriX[0] = event.getSceneX();
            posSouriY[0] = event.getSceneY();

            posImgX[0] = imageView.getTranslateX();
            posImgY[0] = imageView.getTranslateY();
        });

        imageView.setOnMouseDragged(event -> {
            double x = event.getSceneX() - posSouriX[0];
            double y = event.getSceneY() - posSouriY[0];

            imageView.setTranslateX(posImgX[0] + x);
            imageView.setTranslateY(posImgY[0] + y);
        });
    }

    // pour zoomer image
    public void zoomer() {
        setOnScroll(event -> {
            double multiplicateurDeZoom = 1.2;

            if (event.getDeltaY() < 0) {
                multiplicateurDeZoom = 1 / multiplicateurDeZoom;
            }

            imageView.setScaleX(imageView.getScaleX() * multiplicateurDeZoom);
            imageView.setScaleY(imageView.getScaleY() * multiplicateurDeZoom);
        });
    }
}
