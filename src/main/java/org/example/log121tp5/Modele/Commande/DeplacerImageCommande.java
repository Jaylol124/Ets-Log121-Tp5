package org.example.log121tp5.Modele.Commande;

import org.example.log121tp5.Vue.ConteneurObserver;
import org.example.log121tp5.Modele.GestionnaireCommande;
import org.example.log121tp5.Modele.Memento;

public class DeplacerImageCommande implements Commande {
    private final ConteneurObserver conteneurObserver1,
                                    conteneurObserver2;
    private final GestionnaireCommande gestionnaireCommande = GestionnaireCommande.getInstance();

    public DeplacerImageCommande(ConteneurObserver conteneurObserver1,
                                 ConteneurObserver conteneurObserver2) {
        this.conteneurObserver1 = conteneurObserver1;
        this.conteneurObserver2 = conteneurObserver2;
    }
    @Override
    public void execute() {
        double[] posSouriX = new double[1];
        double[] posSouriY = new double[1];
        double[] posImgX = new double[1];
        double[] posImgY = new double[1];

        conteneurObserver1.getImageView().setOnMousePressed(event -> {
            posSouriX[0] = event.getSceneX();
            posSouriY[0] = event.getSceneY();

            posImgX[0] = conteneurObserver1.getImageView().getTranslateX();
            posImgY[0] = conteneurObserver1.getImageView().getTranslateY();

            gestionnaireCommande.pushState(new Memento[]{conteneurObserver1.saveState(), conteneurObserver2.saveState()});
        });

        conteneurObserver1.getImageView().setOnMouseDragged(event -> {
            double dx = event.getSceneX() - posSouriX[0];
            double dy = event.getSceneY() - posSouriY[0];

            conteneurObserver1.getImageView().setTranslateX(posImgX[0] + dx);
            conteneurObserver1.getImageView().setTranslateY(posImgY[0] + dy);
        });
    }

}
