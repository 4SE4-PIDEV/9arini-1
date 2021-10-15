/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9arini1.pkg0.pkg1;


import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import workshodb.entities.Membre;
import workshodb.entities.Utilisateur;
import workshopdb.services.UtilisateurService;
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException, NoSuchAlgorithmException, SQLException {
        // TODO code application logic here
        UtilisateurService productService = new UtilisateurService();
        List<Utilisateur> cherchep = new ArrayList<>();
            
        Date date =new Date( 100, 6,10);
    
        //java.sql.Date sqlDate = new java.sql.Date(date);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final String stringDate= dateFormat.format(date);
        final java.sql.Date sqlDate=  java.sql.Date.valueOf(stringDate);
        Utilisateur p = new  Utilisateur(217335,"cccc", " Ben Ali", " Ben Ali", " Ben Ali"
                , " Ben Ali", " Ben Ali", " Ben Ali", " Ben Ali", " Ben Ali", " Ben Ali"
                , " Ben Ali", sqlDate);
        Utilisateur p1 = new  Utilisateur(217335,"zzz", " Ben Ali", " Ben Ali", " Ben Ali"
                , " Ben Ali", " Ben Ali", " Ben Ali", " Ben Ali", " Ben Ali", " Ben Ali"
                , " Ben Ali",  sqlDate);
                
        try {
            //productService.ajouterPersonne(p);
            productService.ajouterUtilisateur(p);
            System.out.println("personne ajouté");
          
            
        } catch (SQLException ex) {
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur d'ajout"+ex.getMessage());
        }
        try {
            //productService.ajouterPersonne(p);
            
            productService.modifierUtilisateur(p1, 54);
            System.out.println("personne  modifier");
            
          
            
        } catch (SQLException ex) {
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur de modifier"+ex.getMessage());
        }
        try {
          
            productService.supprimerUtilisateur(53);
            System.out.println("personne  supprimé");
          
          
            
        } catch (SQLException ex) {
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur de suppression"+ex.getMessage());
        }
        
        try {
            for(Utilisateur p2 : productService.getAllPersonnes()){
                System.out.println(p2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(" recherche de p : " + productService.rechercherUtilisateur(" Ben Ali").toString());
         
    }
    
}
