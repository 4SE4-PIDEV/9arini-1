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
    /*
    public void ajouterRessources(Ressources r) throws SQLException {
        String req = "INSERT INTO `ressource` ( `utilisateurID`,`nomFormation`) VALUES ( '"
               + f.getNomFormation() +"' )";
        Statement stm = connexion.createStatement();
        stm.executeUpdate(req);
    }

    public void ajouterProduitRessources(Ressources r) throws SQLException {
        String req = "INSERT INTO `cours` (`utilisateurID` , `nomFormation`) "
                + "VALUES ( ?, ?) ";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setInt(1,f.getUtilisateurID());
           ps.setString(2, f.getNomFormation());
                ps.executeUpdate(); 
    } 
///////////// affichage////////////
    public List<Ressources> getAllRessources() throws SQLException {

        List<Ressources> Ressourcess = new ArrayList<>();
        String req = "select * from Ressources";
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Ressources r = new Ressources(rst.getInt("formationID")
                    , rst.getInt("utilisateurID")
                    , rst.getString("nomFormation"));
            Ressourcess.add(f);
        }
        return Ressourcess;
    }  */
}
