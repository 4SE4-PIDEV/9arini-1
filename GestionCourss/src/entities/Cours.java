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
public class Cours {
  private int coursID;
  private int utilisateurID;
private String nomCours;
private int nbrChapitres;



    

    public int getCoursID() {
        return coursID;
    }

    public void setCoursID(int coursID) {
        this.coursID = coursID;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public int getNbrChapitres() {
        return nbrChapitres;
    }

    public void setNbrChapitres(int nbrChapitres) {
        this.nbrChapitres = nbrChapitres;
    }

    public Cours() {
    }

    public int getUtilisateurID() {
        return utilisateurID;
    }

    public void setUtilisateurID(int utilisateurID) {
        this.utilisateurID = utilisateurID;
    }

    public Cours(int utilisateurID, String nomCours, int nbrChapitres) {
        this.utilisateurID = utilisateurID;
        this.nomCours = nomCours;
        this.nbrChapitres = nbrChapitres;
    }

  

    
    
    public Cours(int coursID, int utilisateurID, String nomCours, int nbrChapitres) {
        this.coursID = coursID;
        this.utilisateurID = utilisateurID;
        this.nomCours = nomCours;
        this.nbrChapitres = nbrChapitres;
    }

    @Override
    public String toString() {
        return "Cours{" + "coursID=" + coursID + ", utilisateurID=" + utilisateurID + ", nomCours=" + nomCours + ", nbrChapitres=" + nbrChapitres + '}';
    }

 
   
  

}
