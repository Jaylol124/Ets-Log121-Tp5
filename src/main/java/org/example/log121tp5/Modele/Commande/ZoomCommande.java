package org.example.log121tp5.Modele.Commande;
import javafx.scene.input.ScrollEvent;
import org.example.log121tp5.Modele.GestionnaireCommande;
import org.example.log121tp5.Modele.Memento;
import org.example.log121tp5.Vue.ConteneurObserver;

public class ZoomCommande implements Commande {
    private final ConteneurObserver conteneurObserver1;
    private final ConteneurObserver conteneurObserver2;
    private final ScrollEvent event;
    private final GestionnaireCommande gestionnaireCommande = GestionnaireCommande.getInstance();
    private double multiplicateurDeZoom = 1.2;

    public ZoomCommande(ConteneurObserver conteneurObserver1,
                        ConteneurObserver conteneurObserver2,
                        ScrollEvent event) {
        this.conteneurObserver1 = conteneurObserver1;
        this.conteneurObserver2 = conteneurObserver2;
        this.event = event;
    }

    @Override
    public void execute() {
        gestionnaireCommande.pushState(new Memento[]{conteneurObserver1.saveState(), conteneurObserver2.saveState()});
        multiplicateurDeZoom = (event.getDeltaY() < 0) ? (1.0 / multiplicateurDeZoom) : multiplicateurDeZoom;
        conteneurObserver1.zoom(multiplicateurDeZoom);
    }
}
