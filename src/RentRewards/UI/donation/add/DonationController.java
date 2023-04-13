/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentRewards.UI.donation.add;

import RentRewards.entites.CharityCategory.CharityCategory;
import RentRewards.entities.CharityDemand.Charity_Demand;
import RentRewards.entities.Donation.Donation;
import RentRewards.entities.Donation.ServiceDonation;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class DonationController implements Initializable {
ServiceDonation a = new ServiceDonation();
Donation donation = new Donation();
    @FXML
    private  TextField  title;
    @FXML
    private TextField amount;
    @FXML
    private DatePicker datedonation;
    @FXML
    private Button btndonationadd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    public void adddonation(ActionEvent event) throws IOException {
          if(inputsControl()){
            
                
        
        //donation.setTitle_id(title.getValue());
       
        donation.setPointsdonated(Integer.parseInt(amount.getText()));
        donation.setDatedonation(Date.valueOf(datedonation.getValue()));
       
        a.ajouter(donation);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Demande de charité ajoutée !");
        alert.setContentText("Demande de charité ajoutée avec succès !");
        alert.show();
        
        Parent root = FXMLLoader.load(getClass().getResource("/RentRewards/UI/donation/list/DonationList.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
        
    }}
     public boolean inputsControl(){
        if (  amount.getText().trim().isEmpty() || datedonation.getValue() == null ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("\nVeuillez remplir tous les champs");
            alert.show();
            return false;
        }
        try {
            Integer.parseInt(amount.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("\nVeuillez entrer un nombre valide pour le montant");
            alert.show();
            return false;
        }
        return true;
     }
    }
    


 