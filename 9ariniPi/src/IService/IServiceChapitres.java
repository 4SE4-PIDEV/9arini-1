/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

/**
 *
 * @author fares
 */
import entities.Chapitres;
import java.sql.SQLException;
import java.util.List;
public interface IServiceChapitres {
         public void ajouterProduitChapitres(Chapitres c) throws SQLException ;
    public List<Chapitres> getAllChapitres() throws SQLException ;
      public void supprimerChapitres(int chapitreID) throws SQLException ;
      public  void ModifierChapitres(Chapitres c ,int chapitreID) ;     
}
