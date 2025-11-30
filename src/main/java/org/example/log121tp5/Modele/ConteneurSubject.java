package org.example.log121tp5.Modele;


import org.example.log121tp5.Vue.ConteneurVue;

public class ConteneurSubject extends Subject {
    private final ConteneurVue conteneurVue;
    private String cheminImage;

    public ConteneurSubject() {
        conteneurVue = new ConteneurVue("gray");
    }

    public ConteneurVue getVue()   {return conteneurVue;}
    public String getCheminImage() {return cheminImage;}


    /**
    * Change l'image affichée dans le conteneur.
    * Met à jour le chemin, charge l'image dans la vue, avertit les observers,
    * puis remet à jour l'état de zoom courant.
    *
    * @param cheminImage le chemin (ou URL de fichier) vers la nouvelle image
    */
    public void changementImage(String cheminImage){
        this.cheminImage = cheminImage;
        conteneurVue.setImageDepuisUrlFichier(cheminImage);

        notifyObservers();
        conteneurVue.setZoomActuelle();
    }
}
