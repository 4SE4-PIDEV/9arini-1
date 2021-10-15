/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Ressources;
import DB.DB;
import IService.IServiceRessources;
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
public class Ressourcesservice implements IServiceRessources {
  Connection connexion;
    //Utilisateur loggeduser;

    public Ressourcesservice() {
        connexion = DB.getInstance().getConnection();
    }
//////////// Ajout//////////////  '" + loggeduser.getUtilisateurID()+ "'
    @Override
        public void ajouterProduitRessources(Ressources r) throws SQLException {
        String req = "INSERT INTO `ressource` ( `chapitreID`) "
                + "VALUES ( ?) ";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setInt(1,r.getChapitreID());
                ps.executeUpdate(); 
    } 
///////////// affichage////////////
        @Override
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
    
    @Override
     public void supprimerRessources(int ressourceID ) throws SQLException {

        String req = "DELETE FROM ressource WHERE ressourceID =?";
     try {
         PreparedStatement ps = connexion.prepareStatement(req);
     
        ps.setInt(1,ressourceID);
        ps.executeUpdate();
     }catch (SQLException ex) {
        }
    } 
      @Override
         public  void ModifierRessources(Ressources rs ,int ressourceID) {      
        try {
        String req = "UPDATE ressource SET "
                + " chapitreID='"+rs.getChapitreID()+"'where ressourceID = "+ressourceID+"";
        Statement stm = connexion.createStatement();
        stm.executeUpdate(req);

        } catch (SQLException ex) {
        }
    }
}
