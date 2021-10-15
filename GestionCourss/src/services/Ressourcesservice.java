/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Ressources;
import DB.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author fares
 */
public class Ressourcesservice {
  Connection connexion;
    //Utilisateur loggeduser;

    public Ressourcesservice() {
        connexion = DB.getInstance().getConnection();
    }
//////////// Ajout//////////////  '" + loggeduser.getUtilisateurID()+ "'
    
        public void ajouterProduitRessources(Ressources r) throws SQLException {
        String req = "INSERT INTO `ressource` ( `chapitreID`) "
                + "VALUES ( ?) ";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setInt(1,r.getChapitreID());
                ps.executeUpdate(); 
    } 
///////////// affichage////////////
    public List<Ressources> getAllRessources() throws SQLException {

        List<Ressources> Ressourcess = new ArrayList<>();
        String req = "select * from ressource";
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Ressources r = new Ressources(rst.getInt("ressourceID")
                    , rst.getInt("chapitreID"));
            Ressourcess.add(r);
        }
        return Ressourcess;
    }
    
    
     public void supprimerFormations(String nomFormation ) throws SQLException {

        String req = "DELETE FROM formation WHERE nomFormation =?";
     try {
         PreparedStatement ps = connexion.prepareStatement(req);
     
        ps.setString(1,nomFormation);
        ps.executeUpdate();
     }catch (SQLException ex) {
        }
    } 
      /*
         public  void ModifierFormations(Formations f ,int formationID) {      
        try {
        String req = "UPDATE formation SET "
                + " utilisateurID='"+f.getUtilisateurID()+"'"
                + ", nomFormation='"+f.getNomFormation()+"'where formationID = "+formationID+"";
        Statement stm = connexion.createStatement();
        stm.executeUpdate(req);

        } catch (SQLException ex) {
        }
    }*/
}
