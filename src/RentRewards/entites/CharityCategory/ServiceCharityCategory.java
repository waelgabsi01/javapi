/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentRewards.entites.CharityCategory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import RentRewards.database.DatabaseHandler;
import RentRewards.crudservice.ServiceCrude;
import java.util.Locale.Category;


/**
 *
 * @author MSI
 */
public class ServiceCharityCategory implements ServiceCrude<CharityCategory> {

        private Connection cnx = DatabaseHandler.getInstance().getCnx();
     @Override
    public void ajouter(CharityCategory p) {
        String req = "INSERT INTO `charitycategory`( `id`,`type`, `date_charity`) VALUES( ? ,? ,? );";
        try {
           
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
             pst.setInt(1, p.getId());
            pst.setString(2, p.getType());
            pst.setDate(3, p.getDate_charity());
            
            
            pst.executeUpdate();
            System.out.println("categorie ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(CharityCategory p) {
        
          String req = "UPDATE `charitycategory` SET `type` = ? ,`date_charity` = ? where id =? ";
         try {
            PreparedStatement pst = cnx.prepareStatement(req);

           pst.setString(1, p.getType());
            pst.setDate(2, p.getDate_charity());
            pst.setInt(3, p.getId());
          
            pst.executeUpdate();
            System.out.println("categorie  modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(CharityCategory p) {
        String req = "DELETE FROM `charitycategory` WHERE id=?";
        
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getId());
            pst.executeUpdate();
            System.out.println("Categorie supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<CharityCategory> afficher() {
             List<CharityCategory> list = new ArrayList<>();
        
        String req = "SELECT * FROM `charitycategory`";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                list.add(new CharityCategory(result.getInt("id"), result.getString("type"),result.getDate("date_charity")));
            }
            System.out.println("categories récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    }


