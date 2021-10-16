/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entities.Reclamation;
import DB.DB;

/**
 *
 * @author yahia
 */
public class ReclamationService {
    
    Connection connexion;
public ReclamationService() {
        connexion = DB.getInstance().getConnection();
    } 
public void ajouterReclamation(Reclamation r) throws SQLException {
        String req = "INSERT INTO `reclamation`"+
                "(`formateurid`,`formationid`,`coursid`,`utilisateurid`,`etat`, `message`) "
                + "VALUES ( '"
                + r.getFormateurid()+ "', '" 
                + r.getFormationid()+ "', '" 
                + r.getCoursid()+ "', '" 
                + r.getUtilisateurid()+ "', '" 
                + r.getEtat() + "', '" 
                + r.getMessage() 
                + "') ";
        
        Statement stm = connexion.createStatement();
        stm.executeUpdate(req);
    }

/*
public void ajouterReclamationPs(Reclamation r) throws SQLException {
        String req = "INSERT INTO `personne` (`nom`, `prenom`) "
                + "VALUES ( ?, ?) ";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setString(1, r.getNom());
        ps.setString(2, r.getPrenom());
        ps.executeUpdate();
        
        
  */      
        
public List<Reclamation> getAllReclamation() throws SQLException {

        List<Reclamation> reclamations = new ArrayList<>();
        String req = "select * from Reclamation";
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Reclamation r = new Reclamation(rst.getInt("reclamationid")
                    , rst.getInt("formateurid")
                    , rst.getInt("formationid")
                    , rst.getInt("coursid")
                    , rst.getInt("utilisateurid")
                    , rst.getString("etat")
                    , rst.getString("message"));
            reclamations.add(r);
        }
        return reclamations;
    }

public List<Reclamation> updateReclamation(int idR , String newMsg) throws SQLException{
    
    /*String req = "select forumId from Forum where forumId=idF";
            Statement stm = connexion.createStatement();
            ResultSet rst = stm.executeQuery(req);*/
       
    String req = "UPDATE reclamation SET message = '"+ newMsg +"' WHERE reclamationid ="+ idR;
    Statement stm = connexion.createStatement();
    stm.executeUpdate(req);
    return getAllReclamation();
}

}


    /*public void ajouterProduitPs(Personne p) throws SQLException {
        String req = "INSERT INTO `personne` (`nom`, `prenom`) "
                + "VALUES ( ?, ?) ";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setString(1, p.getNom());
        ps.setString(2, p.getPrenom());
        ps.executeUpdate();
    }
*/