package org.example.log121tp5.Modele.Commande;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.example.log121tp5.Modele.ConteneurObserver;
import org.example.log121tp5.Modele.GestionnaireCommande;
import org.example.log121tp5.Modele.Memento;
import org.example.log121tp5.Vue.ConteneurVue;

public class ChangePerspCommande implements Commande {

    private final String uri;
    private final GestionnaireCommande gestionnaireCommande = GestionnaireCommande.getInstance();

    private final ConteneurObserver conteneurObserver1;
    private final ConteneurObserver conteneurObserver2;

    public ChangePerspCommande(String uri,
                               ConteneurObserver conteneurObserver1,
                               ConteneurObserver conteneurObserver2) {
        this.uri = uri;
        this.conteneurObserver1 = conteneurObserver1;
        this.conteneurObserver2 = conteneurObserver2;
    }

    @Override
    public void execute() {
        if (uri == null) return;

        try (FileInputStream fileIn = new FileInputStream(uri);
             ObjectInputStream in   = new ObjectInputStream(fileIn)){

            ConteneurVue.ConteneurState state1 = (ConteneurVue.ConteneurState) in.readObject();
            ConteneurVue.ConteneurState state2 = (ConteneurVue.ConteneurState) in.readObject();

            gestionnaireCommande.pushState(new Memento[]{conteneurObserver1.saveState(), conteneurObserver2.saveState()});
            conteneurObserver1.restoreState(state1);
            conteneurObserver2.restoreState(state2);
        }
        catch (FileNotFoundException e) {throw new RuntimeException(e);} 
        catch (IOException e)           {throw new RuntimeException(e);}
        catch (ClassNotFoundException e){throw new RuntimeException(e);}
    }
}
