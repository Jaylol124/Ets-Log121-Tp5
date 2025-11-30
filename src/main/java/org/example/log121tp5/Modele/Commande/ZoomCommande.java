package org.example.log121tp5.Modele.Commande;
import javafx.scene.input.ScrollEvent;

import org.example.log121tp5.Modele.ConteneurObserver;
import org.example.log121tp5.Modele.GestionnaireCommande;
import org.example.log121tp5.Modele.Memento;

public class ZoomCommande implements Commande {
    private final ConteneurObserver observer1;
    private final ConteneurObserver observer2;
    private final ConteneurObserver cible;
    private final ScrollEvent event;
    private final GestionnaireCommande gestionnaireCommande = GestionnaireCommande.getInstance();
    private double multiplicateurDeZoom = 1.2;

    public ZoomCommande(ConteneurObserver observer1,
                        ConteneurObserver observer2,
                        ConteneurObserver cible,
                        ScrollEvent event) {
        this.observer1 = observer1;
        this.observer2 = observer2;
        this.cible = cible;
        this.event = event;
    }

    @Override
    public void execute() {
        gestionnaireCommande.pushState(new Memento[]{observer1.saveState(), observer2.saveState()});
        multiplicateurDeZoom = (event.getDeltaY() < 0) ? (1.0 / multiplicateurDeZoom) : multiplicateurDeZoom;
        cible.zoom(multiplicateurDeZoom);
    }
}
