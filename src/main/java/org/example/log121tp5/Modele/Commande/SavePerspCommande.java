package org.example.log121tp5.Modele.Commande;

import org.example.log121tp5.Modele.ConteneurObserver;
import org.example.log121tp5.Vue.ConteneurVue;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SavePerspCommande implements Commande{

    private final String uri;

    private final ConteneurObserver conteneurObserver1;
    private final ConteneurObserver conteneurObserver2;

    public SavePerspCommande(String uri,
                             ConteneurObserver conteneurObserver1,
                             ConteneurObserver conteneurObserver2) {
        this.uri = uri;
        this.conteneurObserver1 = conteneurObserver1;
        this.conteneurObserver2 = conteneurObserver2;
    }

    @Override
    public void execute(){
        if (uri == null) return;

        ConteneurVue.ConteneurState state1 = conteneurObserver1.saveState();
        ConteneurVue.ConteneurState state2 = conteneurObserver2.saveState();

        try (FileOutputStream fileOut = new FileOutputStream(uri);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)){
            
            out.writeObject(state1);
            out.writeObject(state2);    
        } 
        catch (FileNotFoundException e) {throw new RuntimeException(e);}
        catch (IOException e)           {throw new RuntimeException(e);}
    }
}
