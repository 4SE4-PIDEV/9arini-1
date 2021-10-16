/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import entities.Utilisateur;
import entities.Publicite;
import DB.DB;
import IService.IPubliciteService;
import entities.Membre;

/**
 *
 * @author pc-asus
 */
public class PubliciteServices implements IPubliciteService {

   
    static Connection connexion;

    public PubliciteServices() {
        connexion = DB.getInstance().getConnection();
    }
       @Override

    public  void ajouterPublicite(Publicite p) throws SQLException {
        String req ="INSERT INTO `publicité`( `videoPublicite`, `genre`, `ageMax`, `ageMin`, `utilisateurID`, `dateFinPublicite` , `dateDebutPublicite`,   `lienPublicite`, `nbrClick`, `nbrAffichage`, `imagePublicite`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
       try{         
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setString(1, p.getVideoPublicite());
        ps.setString(2, p.getGenre() );
        ps.setInt(3, p.getAgeMax());
        ps.setInt(4, p.getAgeMin());
        ps.setInt(5,p.getUtilisateurID());
        ps.setDate(6, (Date) p.getDateFinPublicite());
        ps.setDate(7, (Date) p.getDateDebutPublicite());
        ps.setString(8, p.getLienPublicite());
        ps.setInt(9, p.getNbrClick());
        ps.setInt(10, p.getNbrAffichage());
        ps.setString(11,  p.getImagePublicite());
        
        ps.executeUpdate();
        System.out.println("publicite ajouté");
       }catch(SQLException ex){
       System.out.println("Erreur d'ajout"+ex.getMessage());
       }
    }

    
   @Override
    public   List<Publicite> getAllPublicites() throws SQLException {
      List<Publicite> publicites = new ArrayList<>();
       String req = "SELECT * FROM publicité";
        try{
        
       
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Publicite P = new Publicite(
                      rst.getInt("publiciteID")
                    , rst.getString("videoPublicite")
                    , rst.getString("genre")
                    , rst.getInt("ageMax")
                    , rst.getInt("ageMin")
                    , rst.getInt("utilisateurID")
                    , rst.getDate("dateFinPublicite")
                    , rst.getDate("dateDebutPublicite")
                    , rst.getString("lienPublicite")
                    , rst.getInt("nbrClick")
                    , rst.getInt("nbrAffichage")
                    , rst.getString("imagePublicite")
                    );
            publicites.add(P);
        }
        
      }catch(SQLException ex){
      Logger.getLogger(Publicite.class.getName()).log(Level.SEVERE, null, ex);
      }
      return publicites;
    }
    @Override
    public void modifierPublicite(Publicite p,int id) throws SQLException, NoSuchAlgorithmException {
        String req = "UPDATE `publicité` SET "
                + " `videoPublicite`='"+p.getVideoPublicite()+"'"
                + ",`genre`='"+p.getGenre()+"'"
                + ", `ageMax`='"+p.getAgeMax()+"'"
                + ", `ageMin`='"+p.getAgeMin()+"'" 
                + ", `utilisateurID`='"+p.getUtilisateurID()+"'"
                + ", `dateFinPublicite`='"+p.getDateFinPublicite()+"'"
                + ", `dateDebutPublicite`='"+p.getDateDebutPublicite()+"'"
                + ", `lienPublicite`='"+p.getLienPublicite()+"'"
                + ", `nbrClick`='"+p.getNbrClick()+"'"
                + ", `nbrAffichage`='"+ p.getNbrAffichage()+"'"
                + ", `imagePublicite`='"+p.getImagePublicite()+"'where PubliciteID = "+id+"";
        try{
        Statement stm = connexion.createStatement();
        stm.executeUpdate(req);
        System.out.println("publicite Modifier");
        }catch(SQLException ex){
        System.out.println("Erreur d'ajout"+ex.getMessage());
        
        }
       
    }
    @Override
    public void supprimerPublicite(Publicite p,int id) throws SQLException {
     String req = "DELETE FROM `publicité` where PubliciteID = "+id+"";
        
     try {
         
         PreparedStatement ps = connexion.prepareStatement(req);
        ps.executeUpdate();
        System.out.println(" Publicite supprimé");
     }catch (SQLException ex) {
         System.out.println("Erreur de suppression"+ex.getMessage());
        }
    }  

    
   
   /*
    @Override
    public List<Membre> chercherCible(Publicite p) throws SQLException {
        List<Membre> presonnes = new ArrayList<>();
        List<Membre> cherchep = new ArrayList<>();
        String req = "select * from utilisateur";
        try{
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);
        //Utilisateur p = null;
        while (rst.next()) {

                        Membre u = new Membre(
            rst.getInt("utilisateurID")
                               , rst.getInt("utilisateurphone")
                    , rst.getString("utilisateurPdp")
                    , rst.getString("utilisateurNom")
                    , rst.getString("utilisateurPrenom")
                    , rst.getString("utilisateurAdresse")
                    , rst.getString("utilisateurPays")
                    , rst.getString("utilisateurGenre")
                    , rst.getString("utilisateurAdresseEmail")
                    , rst.getString("utilisateurMDP")
                    , rst.getString("utilisateurRole")
                    , rst.getString("utilisateurOrganisme")
                    , rst.getString("utilisateurFonction")
                    , rst.getDate("utilisateurDDN"));
            presonnes.add(u);
        }
        for (Membre u : presonnes) {
            if (u.getUtilisateurGenre().equals(p.getGenre()) && (YEAR(getTime())-YEAR(u.getUtilisateurDDN()))>p.getAgeMin() && (YEAR(getTime())-YEAR(u.getUtilisateurDDN())<p.getAgeMax())) {
                
                cherchep.add(u);
            
			
			}
		}
        }catch(SQLException ex){
            System.out.println("Erreur de suppression"+ex.getMessage());
        }
        return cherchep ;
    
    }
    @Override
    public void lancerPublicite(Publicite p)throws SQLException{
        List<Utilisateur> Lp = new ArrayList<>();
       Lp= chercherCible(p);
       
           //koll personne Lp bch yetpusha fi west l interfce mte3ha (p.getVideoPublicite() ||p.getImagePublicite())&&p.getLienPublicite())
           System.out.println("utilisateur"+p.toString());
           
       }

    private int YEAR(java.util.Date utilisateurDDN) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private java.util.Date getTime() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    @Override
    public List<Membre> chercherCible(Publicite p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void lancerPublicite(Publicite p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
        
    }

    
    

   

