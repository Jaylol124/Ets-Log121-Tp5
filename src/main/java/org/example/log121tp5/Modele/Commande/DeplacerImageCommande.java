package org.example.log121tp5.Modele.Commande;

import javafx.scene.image.ImageView;

public class DeplacerImageCommande implements Commande {
    private final ImageView imageView;

    public DeplacerImageCommande(ImageView imageView) {
        this.imageView = imageView;
    }
    @Override
    public void execute() {
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
            double dx = event.getSceneX() - posSouriX[0];
            double dy = event.getSceneY() - posSouriY[0];

            imageView.setTranslateX(posImgX[0] + dx);
            imageView.setTranslateY(posImgY[0] + dy);
        });
    }

}
