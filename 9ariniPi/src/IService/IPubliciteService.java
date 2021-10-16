/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import entities.Utilisateur;
import entities.Publicite;
import DB.DB;
import entities.Membre;
/**
 *
 * @author pc-asus
 */
public interface IPubliciteService {
    
   public  void ajouterPublicite(Publicite p) throws SQLException;
   
   public   List<Publicite> getAllPublicites() throws SQLException;
   
   public void modifierPublicite(Publicite p,int id) throws SQLException, NoSuchAlgorithmException;
   
   public void supprimerPublicite(Publicite p,int id) throws SQLException;
   
   public List<Membre> chercherCible(Publicite p) throws SQLException;
   
   public void lancerPublicite(Publicite p)throws SQLException;
    
}
