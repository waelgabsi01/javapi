/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentRewards.entities.Donation;

import RentRewards.crudservice.ServiceCrude;
import RentRewards.database.DatabaseHandler;
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
public class ServiceDonation implements ServiceCrude<Donation> {
 private Connection cnx = DatabaseHandler.getInstance().getCnx();
    @Override
    public void ajouter(Donation p) {
        String req = "INSERT INTO `donation`( `id`,`username_id`,`title_id`,`pointsdonated`,`datedonation`) VALUES( ?,?,?,?,? );";
        try {
            //`donation`(`id`, `username_id`, `title_id`, `pointsdonated`, `datedonation`)
            //charity_demand`(`id`, `username_id`, `category_id`, `title`, `receiver`, `pointsdemanded`, `datedemand`, `file_upload`)
           
            //Statement st = cnx.createStatement();
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getId());
            pst.setInt(2, p.getUsername_id());
            pst.setInt(3, p.getTitle_id());
            pst.setFloat(4, p.getPointsdonated());
            pst.setDate(5, p.getDatedonation());
           
            
            
            pst.executeUpdate();
            System.out.println("Donation Ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
          
    }

    @Override
    public void modifier(Donation p) {
        String req = "UPDATE `donation` SET `username_id`= ? ,`title_id`= ? ,`pointsdonated`= ? ,`datedonation`= ? where id=?";
         try {
            PreparedStatement pst = cnx.prepareStatement(req);
           pst.setInt(5, p.getId());
            pst.setInt(1, p.getUsername_id());
            pst.setInt(2, p.getTitle_id());
            pst.setFloat(3, p.getPointsdonated());
            pst.setDate(4, p.getDatedonation());
          
            pst.executeUpdate();
            System.out.println("Donation  modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Donation p) {
       String req = "DELETE FROM `donation` WHERE id=?";
        
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getId());
            pst.executeUpdate();
            System.out.println("Donation supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Donation> afficher() {
                    List<Donation> list = new ArrayList<>();
        
        String req = "SELECT * FROM `donation`";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                list.add(new Donation(result.getInt("id"),result.getInt("username_id"),result.getInt("title_id"), result.getFloat("pointsdonated"), result.getDate("datedonation")));
            }
            System.out.println("Donations récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    }
    

