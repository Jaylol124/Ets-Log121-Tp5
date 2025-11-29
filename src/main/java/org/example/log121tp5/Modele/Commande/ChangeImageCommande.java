package org.example.log121tp5.Modele.Commande;

import org.example.log121tp5.Modele.Conteneur.ConteneurSubject;

public class ChangeImageCommande implements Commande {
     private final ConteneurSubject sujet;
    private final String imageUri;

    public ChangeImageCommande(ConteneurSubject sujet, String imageUri) {
        this.sujet    = sujet;
        this.imageUri = imageUri;
    }

    @Override
    public void execute() {
        sujet.changementImage(imageUri);
    }
}
