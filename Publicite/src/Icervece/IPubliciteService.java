/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Icervece;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import publicite.entities.Publicite;
import publicite.entities.Utilisateur;

/**
 *
 * @author pc-asus
 */
public interface IPubliciteService {
    
   public  void ajouterPublicite(Publicite p) throws SQLException;
   
   public   List<Publicite> getAllPublicites() throws SQLException;
   
   public void modifierPublicite(Publicite p,int id) throws SQLException, NoSuchAlgorithmException;
   
   public void supprimerPublicite(Publicite p,int id) throws SQLException;
   
   public List<Utilisateur> chercherCible(Publicite p) throws SQLException;
   
   public void lancerPublicite(Publicite p)throws SQLException;
    
}
