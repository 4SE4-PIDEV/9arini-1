/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncours;
import entities.Chapitres;
import entities.Cours;
import entities.Formations;
import entities.Ressources;
import services.Coursservice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.Chapitresservice;
import services.Formationsservice;
import services.Ressourcesservice;
import sun.applet.Main;
/**
 *
 * @author fares
 */
public class GestionCours {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                    Coursservice productService = new Coursservice();
            Formationsservice productServices = new Formationsservice();
                        Ressourcesservice productServicess = new Ressourcesservice();

                        Chapitresservice productServicesss = new Chapitresservice();
        //List<Cours> Cr = new ArrayList<>();

        Cours c = new Cours(1,"php",5);
         Cours c20 = new Cours(1,"Java",5);
         Cours c21 = new Cours(1,"SGBD",5);
         Cours c22 = new Cours(1,"SOA",5);
        Chapitres cs = new Chapitres(2,"video3");
        Chapitres cs10 = new Chapitres(3,"video1");
        Chapitres cs11 = new Chapitres(5,"video2");
        Chapitres cs12 = new Chapitres(8,"video5");
        Formations f10 = new Formations(1,"symfony");
        Formations f11 = new Formations(1,"Php");
        Formations f12 = new Formations(1,"C++");
        
        Ressources rs10 = new Ressources(1);
                Ressources rs11 = new Ressources(2);
                Ressources rs13 = new Ressources(2);

/////////////////////////////// COURS////////////////////
     
/* try {
            productService.ajouterProduitCours(c20);
            System.out.println("cours ajouté");
        } catch (SQLException ex) {
            System.out.println("Erreur d'ajout"+ex.getMessage());
        }
 

try {
            productService.supprimerCours(0);
            System.out.println("cours supprimé");
            productService.ModifierCours(c20,25);
            System.out.println("cours modifié");
        } catch (SQLException ex) {
            System.out.println("Erreur de suppression"+ex.getMessage());
        }
      */
        
         /////////////////////////////////////////////////////////////
       ////////////////////// Formations////////////////////
             /*    try {
            productServices.ajouterProduitFormation(f11);
            System.out.println("formation ajouté");
        } catch(SQLException ex) {
            System.out.println("Erreur d'ajout"+ex.getMessage());
        }
                  try {
            productServices.supprimerFormations("symfony");
                        productServices.ModifierFormations(f12,21);

            System.out.println("formation supprimé");
        } catch (SQLException ex) {
            System.out.println("Erreur de suppression"+ex.getMessage());
        }*/
                
                  /////////////////////////////////////////////////////////////
                         ////////////////////// Chapitres////////////////////
/*
       try {
            productServicesss.ajouterProduitChapitres(cs);
            System.out.println("Chapitre ajouté");
        } catch (SQLException ex) {
            System.out.println("Erreur d'ajout"+ex.getMessage());
        } */
         
              try {
            productServicesss.supprimerChapitres(21);
                        productServicesss.ModifierChapitres(cs11,22);

            System.out.println("Chapitre supprimé");
        } catch (SQLException ex) {
            System.out.println("Erreur de suppression"+ex.getMessage());
        }
              ///////////////////////////////Ressoureces///////////////
               try {
            productServicess.ajouterProduitRessources(rs10);
            System.out.println("Ressources ajouté");
        } catch (SQLException ex) {
            System.out.println("Erreur d'ajout"+ex.getMessage());
        } 
         /*
              try {
            productServicesss.supprimerChapitres(21);
                        productServicesss.ModifierChapitres(cs11,22);

            System.out.println("Chapitre supprimé");
        } catch (SQLException ex) {
            System.out.println("Erreur de suppression"+ex.getMessage());
        }*/
              /////////////////////////////////////////////////////////
    ////////////////////////////Affichage/////////////////////////////////
        try {
            for(Cours c2 : productService.getAllCours()){
                System.out.println(c2);}
                    } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);}
                    try {
            for(Formations f2 : productServices.getAllFormations()){
                System.out.println(f2);}
                    } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);  }      
            try {
            for(Ressources r2 : productServicess.getAllRessources()){
                System.out.println(r2);}
                    } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);  }           
             try {
            for(Chapitres cs2 : productServicesss.getAllChapitres()){
                System.out.println(cs2);
            }} catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex); }
    //////////////////////////////////         
   }
    }

