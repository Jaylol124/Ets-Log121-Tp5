package org.example.log121tp5.Modele.Commande;

import org.example.log121tp5.Modele.GestionnaireCommande;
import org.example.log121tp5.Modele.Memento;
import org.example.log121tp5.Modele.ConteneurObserver;

public class DeplacerImageCommande implements Commande {
    private final ConteneurObserver[] conteneurs;
    private final GestionnaireCommande gestionnaireCommande = GestionnaireCommande.getInstance();

    public DeplacerImageCommande(ConteneurObserver[] conteneurs) {
        this.conteneurs = conteneurs;
    }
    @Override
    public void execute() {
        if (conteneurs == null || conteneurs.length == 0) return;

        for (ConteneurObserver conteneur : conteneurs) {
            double[] posSouriX = new double[1];
            double[] posSouriY = new double[1];
            double[] posImgX = new double[1];
            double[] posImgY = new double[1];

            conteneur.getImageView().setOnMousePressed(event -> {
                posSouriX[0] = event.getSceneX();
                posSouriY[0] = event.getSceneY();

                posImgX[0] = conteneur.getImageView().getTranslateX();
                posImgY[0] = conteneur.getImageView().getTranslateY();

                Memento[] snapshot = new Memento[conteneurs.length];
                for (int i = 0; i < conteneurs.length; i++)
                    snapshot[i] = conteneurs[i].saveState();
                
                gestionnaireCommande.pushState(snapshot);
            });

            conteneur.getImageView().setOnMouseDragged(event -> {
                double dx = event.getSceneX() - posSouriX[0];
                double dy = event.getSceneY() - posSouriY[0];

                conteneur.getImageView().setTranslateX(posImgX[0] + dx);
                conteneur.getImageView().setTranslateY(posImgY[0] + dy);
            });
        }
    }
}
