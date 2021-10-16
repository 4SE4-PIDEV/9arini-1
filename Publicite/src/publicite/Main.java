/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicite;


import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import publicite.entities.Publicite;
import publicite.entities.Utilisateur;
import publicite.services.PubliciteServices;
import publicite.services.UtilisateurServices;

/**
 *
 * @author pc-asus
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.security.NoSuchAlgorithmException
     
     */
    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException  { 
        // TODO code application logic here
                PubliciteServices productService = new PubliciteServices();

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
       
        
      
            
           productService.ajouterPublicite(p1);
            

      /*     for (publicite p : PubliciteServices.getAllPublicites()) {
            System.out.println(p);
        }*/
      
            productService.modifierPublicite(p3, 4);
       
            productService.supprimerPublicite(p,1);
            
       UtilisateurServices productServices = new UtilisateurServices();   
        Date date =new Date( 100, 6,10);
        final String stringDate= dateFormat.format(date);
        final java.sql.Date sqlDate=  java.sql.Date.valueOf(stringDate);
        Utilisateur u = new  Utilisateur(217335,"cccc", " Ben Ali", " Ben Ali", " Ben Ali"
                , " Ben Ali", " Ben Ali", " Ben Ali", " Ben Ali", " Ben Ali", " Ben Ali"
                , " Ben Ali", sqlDate);
      
        try {
            
            productServices.ajouterUtilisateur(u);
            System.out.println("personne ajouté");
          
            
        } catch (SQLException ex) {
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur d'ajout"+ex.getMessage());
        }
       
          }

   
}
