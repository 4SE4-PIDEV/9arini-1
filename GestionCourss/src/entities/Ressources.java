/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author fares
 */
public class Ressources {
   private int ressourceID;
   private int chapitreID;

    public Ressources() {
    }

    public Ressources(int ressourceID, int chapitreID) {
        this.ressourceID = ressourceID;
        this.chapitreID = chapitreID;
    }

    public Ressources(int chapitreID) {
        this.chapitreID = chapitreID;
    }

    public int getRessourceID() {
        return ressourceID;
    }

    public void setRessourceID(int ressourceID) {
        this.ressourceID = ressourceID;
    }

    public int getChapitreID() {
        return chapitreID;
    }

    public void setChapitreID(int chapitreID) {
        this.chapitreID = chapitreID;
    }

    @Override
    public String toString() {
        return "Ressources{" + "ressourceID=" + ressourceID + ", chapitreID=" + chapitreID + '}';
    }
   
   
}
