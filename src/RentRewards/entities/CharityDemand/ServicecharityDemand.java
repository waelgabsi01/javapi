/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentRewards.entities.CharityDemand;

import RentRewards.crudservice.ServiceCrude;
import RentRewards.database.DatabaseHandler;
import RentRewards.entites.CharityCategory.CharityCategory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MSI
 */
public class ServicecharityDemand implements ServiceCrude<Charity_Demand> {
    private Connection cnx = DatabaseHandler.getInstance().getCnx();
    @Override
    public void ajouter(Charity_Demand p) {
         String req = "INSERT INTO `charity_demand`( `id`,`username_id`, `category_id`, `title`, `receiver`, `pointsdemanded`, `datedemand`, `file_upload`) VALUES( ?,?,?,?,?,?,?,? );";
        try {
            //charity_demand`(`id`, `username_id`, `category_id`, `title`, `receiver`, `pointsdemanded`, `datedemand`, `file_upload`)
           
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getId());
            pst.setInt(2, p.getUsername_id());
            pst.setInt(3, p.getCategory_id());
            pst.setString(4, p.getTitle());
            pst.setString(5, p.getReceiver());
            pst.setFloat(6, p.getPointsdemanded());
            pst.setDate(7, p.getDatedemand());
            pst.setString(8, p.getFile_upload());
            
            
            pst.executeUpdate();
            System.out.println("Demande Ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Charity_Demand p) {
       //`charity_demand` SET `id`= ? ,`username_id`= ? ,`category_id`= ? ,`title`= ? ,`receiver`= ? ,`pointsdemanded`= ? ,`datedemand`= ? ,`file_upload`=?
          String req = "UPDATE `charity_demand` SET `username_id`= ? ,`category_id`= ? ,`title`= ? ,`receiver`= ? ,`pointsdemanded`= ? ,`datedemand`= ? ,`file_upload`= ? where id=? ";
         try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(8, p.getId());
           pst.setInt(1, p.getUsername_id());
            pst.setInt(2, p.getCategory_id());
            pst.setString(3, p.getTitle());
            pst.setString(4, p.getReceiver());
            pst.setFloat(5, p.getPointsdemanded());
            pst.setDate(6, p.getDatedemand());
            pst.setString(7, p.getFile_upload());
          
            pst.executeUpdate();
            System.out.println("Demande  modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Charity_Demand p) {
        String req = "DELETE FROM `charity_demand` WHERE id=?";
        
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getId());
            pst.executeUpdate();
            System.out.println("Demande supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Charity_Demand> afficher() {
                List<Charity_Demand> list = new ArrayList<>();
        
        String req = "SELECT * FROM `charity_demand`";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                list.add(new Charity_Demand(result.getInt("id"),result.getInt("username_id"),result.getInt("category_id"), result.getString("title"), result.getString("receiver"), result.getFloat("pointsdemanded"), result.getDate("datedemand"),result.getString("file_upload")));
            }
            System.out.println("demandes récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    }
    

 
    

