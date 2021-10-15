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
public class Chapitres extends Cours {
    private int chapitreID;
    private int coursID;
    private String videoChapitre;

    public Chapitres() {
    }

    public Chapitres(int chapitreID, int coursID, String videoChapitre) {
        this.chapitreID = chapitreID;
        this.coursID = coursID;
        this.videoChapitre = videoChapitre;
    }

    public Chapitres(String videoChapitre) {
        this.videoChapitre = videoChapitre;
    }

    public Chapitres(int coursID, String videoChapitre) {
        this.coursID = coursID;
        this.videoChapitre = videoChapitre;
    }

    public int getChapitreID() {
        return chapitreID;
    }

    public void setChapitreID(int chapitreID) {
        this.chapitreID = chapitreID;
    }

    public int getCoursID() {
        return coursID;
    }

    public void setCoursID(int coursID) {
        this.coursID = coursID;
    }

    public String getVideoChapitre() {
        return videoChapitre;
    }

    public void setVideoChapitre(String videoChapitre) {
        this.videoChapitre = videoChapitre;
    }

    @Override
    public String toString() {
        return "Chapitres{" + "chapitreID=" + chapitreID + ", coursID=" + coursID + ", videoChapitre=" + videoChapitre + '}';
    }
    
    
    
}
