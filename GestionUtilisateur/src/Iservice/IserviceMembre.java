/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iservice;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import workshodb.entities.Membre;

/**
 *
 * @author lahbib
 */
public interface IserviceMembre {
    public void ajouterMembre(Membre p) throws SQLException, NoSuchAlgorithmException;
    public void modifierMembre(Membre p,int id) throws SQLException, NoSuchAlgorithmException;
    public void supprimerMembre(int id) throws SQLException;
    public List<Membre> getAllMembre() throws SQLException;
    public String hashmdp (String mdp) throws NoSuchAlgorithmException;
    public List<Membre> rechercherMembre(String nom) throws SQLException;
    
    
}
