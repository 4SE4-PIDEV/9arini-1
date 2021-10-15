/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Chapitres;
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
public class Chapitresservice {
     Connection connexion;
    //Utilisateur loggeduser;

    public Chapitresservice() {
        connexion = DB.getInstance().getConnection();
    }
//////////// Ajout//////////////  '" + loggeduser.getUtilisateurID()+ "'
    public void ajouterChapitres(Chapitres c) throws SQLException {
        String req = "INSERT INTO `chapitre` ( `coursID`,`videoChapitre`) VALUES ( '"
               + c.getVideoChapitre() +"'  )";
        Statement stm = connexion.createStatement();
        stm.executeUpdate(req);
    }

    public void ajouterProduitChapitres(Chapitres c) throws SQLException {
        String req = "INSERT INTO `chapitre` (`coursID` , `videoChapitre`) "
                + "VALUES ( ?, ?) ";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setInt(1,c.getCoursID());
           ps.setString(2, c.getVideoChapitre());
       
        ps.executeUpdate(); 
    } 
///////////// affichage////////////
    public List<Chapitres> getAllChapitres() throws SQLException {

        List<Chapitres> Chapitress = new ArrayList<>();
        String req = "select * from chapitre";
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Chapitres c = new Chapitres(rst.getInt("chapitreID")
                    , rst.getInt("coursID")
                    , rst.getString("videoChapitre"));
                                Chapitress.add(c);
        }
        return Chapitress;
    }
    
    
      public void supprimerChapitres(int chapitreID) throws SQLException {

        String req = "DELETE FROM chapitre WHERE chapitreID =?";
     try {
         PreparedStatement ps = connexion.prepareStatement(req);
     
        ps.setInt(1,chapitreID);
        ps.executeUpdate();
     }catch (SQLException ex) {
        }
    }
}
