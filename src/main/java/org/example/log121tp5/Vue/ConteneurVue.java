package org.example.log121tp5.Vue;

import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.example.log121tp5.Modele.Memento;

import java.io.Serializable;

public class ConteneurVue extends StackPane{

    public static final class ConteneurState implements Memento, Serializable {
        private final double posX;
        private final double posY;
        private final double zoomX;
        private final double zoomY;

        public ConteneurState(double posX, double posY, double zoomX, double zoomY) {
            this.posX = posX;
            this.posY = posY;
            this.zoomX = zoomX;
            this.zoomY = zoomY;
        }

        public double getPosX() { return posX; }
        public double getPosY() { return posY; }
        public double getZoomX() { return zoomX; }
        public double getZoomY() { return zoomY; }
    }

    private final StackPane content = new StackPane();
    protected final ImageView imageView = new ImageView();

    public ConteneurVue(String couleur) {
        setStyle("-fx-background-color: rgba(255,255,255,0.35);");

        setBorder(new Border(new BorderStroke(
                Color.web(couleur),
                BorderStrokeStyle.SOLID,
                new CornerRadii(0),
                new BorderWidths(3)
        )));

        content.setAlignment(Pos.CENTER);
        content.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

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

        content.getChildren().add(imageView);
        getChildren().add(content);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public String getCheminImage() {
        if (imageView.getImage() == null) return null;
        return imageView.getImage().getUrl();
    }

    public void setImageDepuisUrlFichier(String urlFichier) {
        if (urlFichier == null) return;
        if (urlFichier.contains("file:")) {
            urlFichier = urlFichier.replace("file:", "");
        }

        Image image = new Image("file:" + urlFichier);
        imageView.setImage(image);
    }

    public void setZoomActuelle() {
        imageView.setScaleX(imageView.getScaleX() + 0.5);
        imageView.setScaleY(imageView.getScaleY() + 0.5);
    }

    public void setZoomActuelle(double zoomX,double zoomY) {
        imageView.setScaleX(zoomX);
        imageView.setScaleY(zoomY);
    }

    public void setPosActuelle(double posX, double posY ) {
        imageView.setTranslateX(posX);
        imageView.setTranslateY(posY);
    }

    /**
     * Applique un zoom avec un multiplicateur.
     * @param multiplicateurDeZoom
     */
    public void zoom(double multiplicateurDeZoom) {
        imageView.setScaleX(imageView.getScaleX() * multiplicateurDeZoom);
        imageView.setScaleY(imageView.getScaleY() * multiplicateurDeZoom);
    }

    /**
     * Sauvegarde l'état actuel du conteneur (zoom, position, etc.) dans un "memento".
     *
     * @return l'état courant du conteneur
     */
    public ConteneurState saveState() {
        return new ConteneurState(
                imageView.getTranslateX(),
                imageView.getTranslateY(),
                imageView.getScaleX(),
                imageView.getScaleY()
        );
    }

    /**
     * Remet le conteneur dans un état précédent à partir d'un memento.
     *
     * @param memento l'état à restaurer
     */
    public void restoreState(Memento memento) {
        if (!(memento instanceof ConteneurState)) return;
        ConteneurState state = (ConteneurState) memento;
        setPosActuelle(state.getPosX(), state.getPosY());
        setZoomActuelle(state.getZoomX(), state.getZoomY());
    }
}
