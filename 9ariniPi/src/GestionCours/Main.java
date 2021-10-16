    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncours;
import entities.Admin;
import entities.Forum;
import entities.Reclamation;
import entities.Chapitres;
import entities.Cours;
import entities.Entrepreneur;
import entities.Formateur;
import entities.Formations;
import entities.Membre;
import entities.Publicite;
import entities.Ressources;
import entities.Utilisateur;
import java.security.NoSuchAlgorithmException;
import services.Coursservice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.AdminService;
import services.Chapitresservice;
import services.EntrepreneurService;
import services.FormateurService;
import services.Formationsservice;
import services.Ressourcesservice;
import services.ReclamationService;
import services.ForumService;
import services.PubliciteServices;
import services.MembreService;
/**
 *
 * @author fares
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {
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
        Ressources rs12 = new Ressources(2);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////// COURS/////////////////////////////////////////////////////////////////////////////////
try {
            productService.ajouterProduitCours(c21);
            System.out.println("cours ajouté");
        } catch (SQLException ex) {
            System.out.println("Erreur d'ajout"+ex.getMessage());}
try {
            productService.supprimerCoursbyId(6);
                        //productService.supprimerCoursbyName("Java");

            System.out.println("cours supprimé");
           // productService.ModifierCours(c20,25);
            System.out.println("cours modifié");
        } catch (SQLException ex) {
            System.out.println("Erreur de suppression"+ex.getMessage());}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
////////////////////// Formations/////////////////////////////////////////////////////////////////////////////////
try {
            productServices.ajouterProduitFormation(f12);
            System.out.println("formation ajouté");
        } catch(SQLException ex) {
            System.out.println("Erreur d'ajout"+ex.getMessage());}
try {
            productServices.supprimerFormations("C++");
            productServices.ModifierFormations(f12,21);
            System.out.println("formation supprimé");
        } catch (SQLException ex) {
            System.out.println("Erreur de suppression"+ex.getMessage());}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////// Chapitres/////////////////////////////////////////////////////////////////////////////////
try {
            productServicesss.ajouterProduitChapitres(cs10);
            System.out.println("Chapitre ajouté");
        } catch (SQLException ex) {
            System.out.println("Erreur d'ajout"+ex.getMessage());} 
try {
            productServicesss.supprimerChapitres(22);
            productServicesss.ModifierChapitres(cs11,22);
            System.out.println("Chapitre supprimé");
        } catch (SQLException ex) {
            System.out.println("Erreur de suppression"+ex.getMessage());}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////Ressoureces////////////////////////////////////////////////////////////////////////////
try {
            productServicess.ajouterProduitRessources(rs12);
            System.out.println("Ressources ajouté");
        } catch (SQLException ex) {
            System.out.println("Erreur d'ajout"+ex.getMessage());}
try {
            productServicess.supprimerRessources(2);
            productServicess.ModifierRessources(rs12,1);
            System.out.println("ressources supprimé");
        } catch (SQLException ex) {
            System.out.println("Erreur de suppression"+ex.getMessage());}
//////////////////////////////////////////////////////////
////////////////////////////Affichage/////////////////////////////////
try {
            for(Cours c2 : productService.getAllCours()){
                System.out.println(c2);}} 
catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);}
try {
            for(Formations f2 : productServices.getAllFormations()){
                System.out.println(f2);}}
catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);  }      
            try {
            for(Ressources rs2 : productServicess.getAllRessources()){
                System.out.println(rs2);}}
catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);  }           
try {
            for(Chapitres cs2 : productServicesss.getAllChapitres()){
                System.out.println(cs2);}}
catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex); }
    //////////////////////////////////    
    
    
    //////////////////////////YAHIA   //////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
    ForumService forumService   = new ForumService();
       Forum yf = new Forum() ; 
       yf.setUtilisateurid(7);
       yf.setDislike(7);
       yf.setLike(9);
       yf.setComment("idk");
       forumService.ajouterforum(yf);
       
       ReclamationService reclamationService = new ReclamationService () ;
       Reclamation yr = new Reclamation() ; 
       yr.setUtilisateurid(34);
       yr.setFormationid(1);
       yr.setCoursid(0);
       yr.setFormateurid(0);
       yr.setEtat("en cour");
       yr.setMessage("cour js not found");
       reclamationService.ajouterReclamation(yr) ;
        System.out.println("\n\n*************LIST FORUM*******************************");

for(Forum yf2 : forumService.getAllForum()){
                System.out.println(yf2);
            }

 System.out.println("\n\n*************LIST RECLAMATIONS *******************************");

for(Reclamation yr2 : reclamationService.getAllReclamation()){
                System.out.println(yr2);
            }

 System.out.println("\n\n *************LIST FORUM AFTER DELETE*******************************");
 for(Forum yf1 : forumService.deleteForum(31)){

        System.out.println(yf1);
    }
 
  System.out.println("\n\n*************LIST RECLAMATION AFTER UPDATE*******************************");

 for(Reclamation yr2 : reclamationService.updateReclamation(30, "update reclamation works")){

        System.out.println(yr2);
    }
 
   System.out.println("\n\n*************LIST FORUM AFTER UPDATE*******************************");
 for(Forum yf2 : forumService.updateComment(30, "update forum works")){
        System.out.println(yf2);
    }
    //////////////////////////Radhwen/////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
PubliciteServices pproductService = new PubliciteServices();
        Date date1 =new Date( 100, 6,10);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final String stringDate1= dateFormat.format(date1);
        final java.sql.Date sqlDate1=  java.sql.Date.valueOf(stringDate1);
                Date date2 =new Date( 100, 6,10);
        final String stringDate2= dateFormat.format(date2);
        final java.sql.Date sqlDate2=  java.sql.Date.valueOf(stringDate2);
        Publicite p = new  Publicite("video", "Homme", 30, 18, 1, sqlDate1, sqlDate2,"www.esprit.com", 25, 5, "image");
        Publicite p1 = new Publicite("v", "H", 30, 18, 1, sqlDate1, sqlDate2,"www.google.com", 25, 5, "i");
        Publicite p3 = new Publicite("hhh", "ooo", 30, 18, 1, sqlDate1, sqlDate2,"www.facebook.com", 25, 5, "gpg");
 pproductService.ajouterPublicite(p1) ;
     /*      for (publicite p : PubliciteServices.getAllPublicites()) {
            System.out.println(p);
        }*/
                  pproductService.modifierPublicite(p3, 4);
            pproductService.supprimerPublicite(p,1);
                   MembreService pproductServices = new MembreService();   
        Date date =new Date( 100, 6,10);
        final String stringDate= dateFormat.format(date);
        final java.sql.Date sqlDate=  java.sql.Date.valueOf(stringDate);
        Membre u = new  Membre(217335,"cccc", " Ben Ali", " Ben Ali", " Ben Ali"
                , " Ben Ali", " Ben Ali", " Ben Ali", " Ben Ali", " Ben Ali", " Ben Ali"
                , " Ben Ali", sqlDate);
        pproductServices.ajouterMembre(u); //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("personne ajouté");
       //////////////////////////Zied/////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////

 MembreService zproductService = new MembreService();
        AdminService productService1 = new AdminService();
        FormateurService productService2 = new FormateurService();
        EntrepreneurService productService3 = new EntrepreneurService();
        List<Membre> cherchep = new ArrayList<>();
        List<Admin> cherchep1 = new ArrayList<>();
        List<Formateur> cherchep2 = new ArrayList<>();
        List<Entrepreneur> cherchep3 = new ArrayList<>();
                
            
    
        //java.sql.Date sqlDate = new java.sql.Date(date);
        
        
        Membre pp = new  Membre(21733584, "cccc","lahbib", "zied", "medina"
                , "tunis", "homme", "lahbibmedzied@gmail.com", "01234", "membre"
                , "Esprit","etudiant", sqlDate);
        Admin pp1 = new  Admin(21733584, "cccc","lahbib", "zied", "medina"
                , "tunis", "homme", "lahbibmedzied@gmail.com", "01234", "Admin"
                , "Esprit","etudiant", sqlDate);
        Entrepreneur pp2 = new  Entrepreneur(21733584, "cccc","mohamed", "zied", "medina"
                , "tunis", "homme", "lahbibmedzied@gmail.com", "01234", "Entrepreneur"
                , "Esprit","etudiant","ziedstore","www.ziedstore.com","electronique", sqlDate);
        Formateur pp3 = new  Formateur(21733584, "cccc","lahbib", "zied", "medina"
                , "tunis", "homme", "lahbibmedzied@gmail.com", "01234", "Formateur"
                , "Esprit","etudiant","sociable", sqlDate);
        Membre pp4 = new  Membre(21733584, "cccc","lahbib", "zied", "medina"
                , "tunis", "homme", "lahbibmedzied@gmail.com", "01234", "membre"
                , "Esprit","etudiant", sqlDate);
                
        try {
            //productService.ajouterPersonne(p);
            zproductService.ajouterMembre(pp);
            productService1.ajouterAdmin(pp1);
            productService2.ajouterFormateur(pp3);
            productService3.ajouterEntrepreneur(pp2);
            zproductService.ajouterMembre(pp4);
            System.out.println("personne ajouté");
          
            
        } catch (SQLException ex) {
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur d'ajout"+ex.getMessage());
        }
        //productService.ajouterPersonne(p);
        
        productService1.modifierAdmin(pp1, 66);
        System.out.println("personne  modifier");
        try {
          
            zproductService.supprimerMembre(67);
            System.out.println("personne  supprimé");
          
          
            
        } catch (SQLException ex) {
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur de suppression"+ex.getMessage());
        }
        
        try {
            for(Membre pp5 : zproductService.getAllMembre()){
                System.out.println(pp5);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(" recherche de p : " + zproductService.rechercherMembre("zied").toString());
              //////////////////////////Amine/////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
        
        
        
        
        
        
        
        
        
        
    }

}







   
    

