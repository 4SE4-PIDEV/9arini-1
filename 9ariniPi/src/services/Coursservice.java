/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Cours;
import DB.DB;
import IService.IServiceCours;
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
public class Coursservice implements IServiceCours {
     Connection connexion;
    //Utilisateur loggeduser;

    public Coursservice() {
        connexion = DB.getInstance().getConnection();
    }
//////////// Ajout//////////////  '" + loggeduser.getUtilisateurID()+ "'
@Override
    public void ajouterProduitCours(Cours c) throws SQLException {
        String req = "INSERT INTO `cours` (`utilisateurID` , `nomCours`, `nbrChapitres`) "
                + "VALUES ( ?, ?,?) ";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setInt(1,c.getUtilisateurID());
           ps.setString(2, c.getNomCours());
        ps.setInt(3, c.getNbrChapitres());
        ps.executeUpdate(); 
    } 
///////////// affichage////////////
    @Override
    public List<Cours> getAllCours() throws SQLException {

        List<Cours> Courss = new ArrayList<>();
        String req = "select * from Cours";
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Cours c = new Cours(rst.getInt("coursID")
                    , rst.getInt("utilisateurID")

                    , rst.getString("nomCours")
                    , rst.getInt("nbrChapitres"));
            Courss.add(c);
        }
        return Courss;
    }
        @Override
     public void supprimerCoursbyName(String nomCours) throws SQLException {

        String req = "DELETE FROM cours WHERE nomCours =?";
     try {
         PreparedStatement ps = connexion.prepareStatement(req);
             ps.setString(1,nomCours);
        ps.executeUpdate();
     }catch (SQLException ex) {
        }
    }
    @Override
  public void supprimerCoursbyId(int coursID) throws SQLException {

        String req = "DELETE FROM cours WHERE coursID =?";
     try {
         PreparedStatement ps = connexion.prepareStatement(req);
     
        ps.setInt(1,coursID);
        ps.executeUpdate();
     }catch (SQLException ex) {
        }
    }  
  @Override
     public  void ModifierCours(Cours c ,int coursID) {      
        try {
        String req = "UPDATE cours SET "
                + " utilisateurID='"+c.getUtilisateurID()+"'"
                + ", nomCours='"+c.getNomCours()+"'"
                + ", nbrChapitres='"+c.getNbrChapitres()+"'where coursID = "+coursID+"";
        Statement stm = connexion.createStatement();
        stm.executeUpdate(req);

        } catch (SQLException ex) {
        }
    }

   
}

 