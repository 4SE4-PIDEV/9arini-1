/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import entities.Admin;

/**
 *
 * @author lahbib
 */
public interface IserviceAdmin {
    public void ajouterAdmin(Admin p) throws SQLException, NoSuchAlgorithmException ;
    public void modifierAdmin(Admin p,int id) throws SQLException, NoSuchAlgorithmException;
    public void supprimerAdmin(int id) throws SQLException;
    public List<Admin> getAllAdmin() throws SQLException;
    public String hashmdp (String mdp) throws NoSuchAlgorithmException;
    public List<Admin> rechercherAdmin(String nom) throws SQLException;
    
    
}
