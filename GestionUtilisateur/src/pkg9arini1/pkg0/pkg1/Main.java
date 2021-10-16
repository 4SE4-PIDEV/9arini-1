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
import workshodb.entities.Admin;
import workshodb.entities.Entrepreneur;
import workshodb.entities.Formateur;
import workshodb.entities.Membre;
import workshodb.entities.Utilisateur;
import workshopdb.services.AdminService;
import workshopdb.services.EntrepreneurService;
import workshopdb.services.FormateurService;
import workshopdb.services.MembreService;
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException, NoSuchAlgorithmException, SQLException {
        // TODO code application logic here
        MembreService productService = new MembreService();
        AdminService productService1 = new AdminService();
        FormateurService productService2 = new FormateurService();
        EntrepreneurService productService3 = new EntrepreneurService();
        List<Membre> cherchep = new ArrayList<>();
        List<Admin> cherchep1 = new ArrayList<>();
        List<Formateur> cherchep2 = new ArrayList<>();
        List<Entrepreneur> cherchep3 = new ArrayList<>();
                
            
        Date date =new Date( 100, 6,10);
    
        //java.sql.Date sqlDate = new java.sql.Date(date);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final String stringDate= dateFormat.format(date);
        final java.sql.Date sqlDate=  java.sql.Date.valueOf(stringDate);
        Membre p = new  Membre(21733584, "cccc","lahbib", "zied", "medina"
                , "tunis", "homme", "lahbibmedzied@gmail.com", "01234", "membre"
                , "Esprit","etudiant", sqlDate);
        Admin p1 = new  Admin(21733584, "cccc","lahbib", "zied", "medina"
                , "tunis", "homme", "lahbibmedzied@gmail.com", "01234", "Admin"
                , "Esprit","etudiant", sqlDate);
        Entrepreneur p2 = new  Entrepreneur(21733584, "cccc","mohamed", "zied", "medina"
                , "tunis", "homme", "lahbibmedzied@gmail.com", "01234", "Entrepreneur"
                , "Esprit","etudiant","ziedstore","www.ziedstore.com","electronique", sqlDate);
        Formateur p3 = new  Formateur(21733584, "cccc","lahbib", "zied", "medina"
                , "tunis", "homme", "lahbibmedzied@gmail.com", "01234", "Formateur"
                , "Esprit","etudiant","sociable", sqlDate);
        Membre p4 = new  Membre(21733584, "cccc","lahbib", "zied", "medina"
                , "tunis", "homme", "lahbibmedzied@gmail.com", "01234", "membre"
                , "Esprit","etudiant", sqlDate);
                
        try {
            //productService.ajouterPersonne(p);
            productService.ajouterMembre(p);
            productService1.ajouterAdmin(p1);
            productService2.ajouterFormateur(p3);
            productService3.ajouterEntrepreneur(p2);
            productService.ajouterMembre(p4);
            System.out.println("personne ajouté");
          
            
        } catch (SQLException ex) {
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur d'ajout"+ex.getMessage());
        }
        try {
            //productService.ajouterPersonne(p);
            
            productService1.modifierAdmin(p1, 66);
            System.out.println("personne  modifier");
            
          
            
        } catch (SQLException ex) {
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur de modifier"+ex.getMessage());
        }
        try {
          
            productService.supprimerMembre(67);
            System.out.println("personne  supprimé");
          
          
            
        } catch (SQLException ex) {
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur de suppression"+ex.getMessage());
        }
        
        try {
            for(Membre p5 : productService.getAllMembre()){
                System.out.println(p5);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(" recherche de p : " + productService.rechercherMembre("lahbib").toString());
         
    }
    
}
