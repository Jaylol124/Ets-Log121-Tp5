package org.example.log121tp5.Modele.Commande;
import javafx.scene.input.ScrollEvent;
import org.example.log121tp5.Vue.ConteneurVue;

public class ZoomCommande implements Commande {
    private final ConteneurVue vue;
    private final ScrollEvent event;
    private final double baseZoomFactor = 1.2;

    public ZoomCommande(ConteneurVue vue, ScrollEvent event) {
        this.vue = vue;
        this.event = event;
    }

    @Override
    public void execute() {
        double multiplicateurDeZoom = (event.getDeltaY() < 0) ? (1.0 / baseZoomFactor) : baseZoomFactor;
        vue.zoom(multiplicateurDeZoom);
    }
}
