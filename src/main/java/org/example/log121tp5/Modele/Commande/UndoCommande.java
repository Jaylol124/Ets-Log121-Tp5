package org.example.log121tp5.Modele.Commande;

import org.example.log121tp5.Modele.GestionnaireCommande;
import org.example.log121tp5.Vue.ConteneurObserver;
import org.example.log121tp5.Modele.Memento;

public class UndoCommande implements Commande {

    private final GestionnaireCommande gestionnaireCommande = GestionnaireCommande.getInstance();
    private final ConteneurObserver conteneurObserver1;
    private final ConteneurObserver conteneurObserver2;

    public UndoCommande(ConteneurObserver conteneurObserver1,
                        ConteneurObserver conteneurObserver2) {
        this.conteneurObserver1 = conteneurObserver1;
        this.conteneurObserver2 = conteneurObserver2;
    }

    @Override
    public void execute() {
        Memento[] state = gestionnaireCommande.undo(new Memento[]{conteneurObserver1.saveState(), conteneurObserver2.saveState()});
        if (state == null) return;

        conteneurObserver1.restoreState(state[0]);
        conteneurObserver2.restoreState(state[1]);
    }
}
