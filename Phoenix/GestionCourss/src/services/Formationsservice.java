/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Formations;
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
public class Formationsservice {
     Connection connexion;
    //Utilisateur loggeduser;

    public Formationsservice() {
        connexion = DB.getInstance().getConnection();
    }
//////////// Ajout//////////////  '" + loggeduser.getUtilisateurID()+ "'
    public void ajouterFormation(Formations f) throws SQLException {
        String req = "INSERT INTO `formation` ( `utilisateurID`,`nomFormation`) VALUES ( '"
               + f.getNomFormation() +"' )";
        Statement stm = connexion.createStatement();
        stm.executeUpdate(req);
    }

    public void ajouterProduitFormation(Formations f) throws SQLException {
        String req = "INSERT INTO `formation` (`utilisateurID` , `nomFormation`) "
                + "VALUES ( ?, ?) ";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setInt(1,f.getUtilisateurID());
           ps.setString(2, f.getNomFormation());
                ps.executeUpdate(); 
    } 
///////////// affichage////////////
    public List<Formations> getAllFormations() throws SQLException {

        List<Formations> Formationss = new ArrayList<>();
        String req = "select * from formation";
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Formations f = new Formations(rst.getInt("formationID")
                    , rst.getInt("utilisateurID")
                    , rst.getString("nomFormation"));
            Formationss.add(f);
        }
        return Formationss;
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
}
