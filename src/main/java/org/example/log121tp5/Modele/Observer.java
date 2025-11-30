package org.example.log121tp5.Modele;
/**
 * Inspirer des notes de cours << Le patron observateur >>
 */
public interface Observer {
     /**
      * Met à jour l'observer en fonction des changements du subject.
      * @param subject
      */
     void update(Subject subject);
}