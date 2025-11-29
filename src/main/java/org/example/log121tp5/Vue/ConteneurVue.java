package org.example.log121tp5.Vue;

import javafx.beans.binding.Bindings;
import javafx.geometry.Bounds;
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

import org.example.log121tp5.Modele.GestionnaireCommande;
import org.example.log121tp5.Modele.Commande.Commande;
import org.example.log121tp5.Modele.Commande.DeplacerImageCommande;
import org.example.log121tp5.Modele.Commande.ZoomCommande;

public class ConteneurVue extends StackPane{
    private transient final ImageView imageView = new ImageView();
    private transient final StackPane content = new StackPane(); 

    private GestionnaireCommande gestionnaireCommande = GestionnaireCommande.getInstance();

    private double posXActuelle = 0d;
    private double posYActuelle = 0d;
    private double zoomPosX     = 1d;
    private double zoomPosY     = 1d;
    public ConteneurVue(String couleur, boolean estBougeable) {

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

        if(estBougeable){
            deplacerImage();
            zoomerImage();
        }
    }
    public void positionActuelle() {
        Bounds b = imageView.localToParent(imageView.getBoundsInLocal());
        posXActuelle = b.getMinX();
        posYActuelle = b.getMinY();
        zoomPosX = imageView.getScaleX();
        zoomPosY = imageView.getScaleY();
    }

    // --- METHODES DE DEPLACEMENT ---

    public void deplacerImage() {
        Commande comande = new DeplacerImageCommande(imageView);
        gestionnaireCommande.commandeExecute(comande);
    }

    // --- METHODES DE ZOOM ---
    public void zoomerImage() {
        setOnScroll(event -> {
            Commande commande = new ZoomCommande(this, event);
            gestionnaireCommande.commandeExecute(commande);
        });
    }

    public void zoom(Double multiplicateurDeZoom) { 
        imageView.setScaleX(imageView.getScaleX() * multiplicateurDeZoom);
        imageView.setScaleY(imageView.getScaleY() * multiplicateurDeZoom);
        zoomPosX = imageView.getScaleX();
        zoomPosY = imageView.getScaleY();
    }

    // GETTERS
    public double getPosXActuelle() {return posXActuelle;}
    public double getPosYActuelle() {return posYActuelle;}

    public double getZoomPosX() {return zoomPosX;}
    public double getZoomPosY() {return zoomPosY;}

    public Double getPositionImageX() { return (posXActuelle + posYActuelle);}

    // SETTERS
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
    public ImageView getImageView() {return imageView;}

    //setteur de l'imageview
    public void setImage(Image image) {imageView.setImage(image);}

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
