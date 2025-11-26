package org.example.log121tp5.Modele.Conteneur;

import javafx.beans.binding.Bindings;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.Serializable;

public class ConteneurModele extends StackPane implements Serializable {



    private transient static final double BORDER_WIDTH = 3.0;

    private transient final ImageView imageView = new ImageView();

//    private double posXActuelle = (imageView.getLayoutX() + imageView.getTranslateX());
//    private double posYActuelle = (imageView.getLayoutY() + imageView.getTranslateY());
    private double posXActuelle =0;
    private double posYActuelle = 0;
    private double zoomPosX = 1.0;
    private double zoomPosY = 1.0;


    private transient final StackPane content = new StackPane(); // pane interne qui sera clipé
    public ConteneurModele(String couleur, boolean estBougeable) {

        setStyle("-fx-background-color: rgba(255,255,255,0.35);");

        //le contour
        setBorder(new Border(new BorderStroke(
                Color.web(couleur),
                BorderStrokeStyle.SOLID,
                new CornerRadii(0),
                new BorderWidths(BORDER_WIDTH)
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

    public void positionActuelle() {
        Bounds b = imageView.localToParent(imageView.getBoundsInLocal());
        posXActuelle = b.getMinX();
        posYActuelle = b.getMinY();
        zoomPosX = imageView.getScaleX();
        zoomPosY = imageView.getScaleY();
    }

    public double getPosXActuelle() {
        return posXActuelle;
    }

    public double getPosYActuelle() {
        return posYActuelle;
    }

    public double getZoomPosX() {
        return zoomPosX;
    }

    public double getZoomPosY() {
        return zoomPosY;
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

            posXActuelle = imageView.getTranslateX();
            posYActuelle = imageView.getTranslateY();
        });

        //positionActuelle();



//        System.out.println(posXActuelle);
//        System.out.println('\n' + posYActuelle);


    }

    // pour zoomer image
    private void zoomer() {
        setOnScroll(event -> {
            double multiplicateurDeZoom = 1.2;

            if (event.getDeltaY() < 0) {
                multiplicateurDeZoom = 1 / multiplicateurDeZoom;
            }

            imageView.setScaleX(imageView.getScaleX() * multiplicateurDeZoom);
            imageView.setScaleY(imageView.getScaleY() * multiplicateurDeZoom);

            //positionActuelle();
            zoomPosX = imageView.getScaleX();
            zoomPosY = imageView.getScaleY();
        });
    }

    public Double getPositionImageX() {
        return (posXActuelle + posYActuelle);

    }

    public void setPosActuelle(double posX, double posY ) {
        imageView.setTranslateX(posX);
        imageView.setTranslateY(posY);
    }

    public void setZoomActuelle(double zoomX,double zoomY) {
        imageView.setScaleX(zoomX);
        imageView.setScaleY(zoomY);
    }
    public void setZoomActuelle() {
        imageView.setScaleX(imageView.getScaleX() +0.5);
        imageView.setScaleY(imageView.getScaleX() + 0.5);

    }
}
