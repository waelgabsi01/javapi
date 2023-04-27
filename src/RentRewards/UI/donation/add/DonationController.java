/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentRewards.UI.donation.add;

import RentRewards.database.DatabaseHandler;
import RentRewards.entities.CharityDemand.Charity_Demand;
import RentRewards.entities.CharityDemand.ServicecharityDemand;
import RentRewards.entities.Donation.Donation;
import RentRewards.entities.Donation.ServiceDonation;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class DonationController implements Initializable {

    @FXML
    private TextField amount;
    @FXML
    private Button btndonationadd;
    @FXML
    private ChoiceBox<Integer> CharityTitleChooser;
    @FXML
    private ChoiceBox<Integer> username1;
      ServiceDonation myservice =new ServiceDonation();

private ObservableList<Integer> Title_idList;
private ObservableList<Integer> username_idList;
private ObservableList<String> Title_NameList;
private ObservableList<String> username_NameList;
    
    
      Connection cnx;
         String query;
    @FXML
    private DatePicker Datedonationc;

    public DonationController(){
                 cnx = DatabaseHandler.getInstance().getCnx();

        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Title_idList = FXCollections.observableArrayList();
            Title_NameList = FXCollections.observableArrayList();
 
     


     
        try {
            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery("SELECT id,title FROM charity_demand");
            while (res.next()) {
                
                Title_idList.add(res.getInt("id"));
               Title_NameList.add(res.getString("title"));

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        // Set the eventsIdChoiceBox items to the eventsIdList
        CharityTitleChooser.setItems(Title_idList);
      CharityTitleChooser.setConverter(new StringConverter<Integer>() {
              @Override
    public String toString(Integer id) {
        int index = Title_idList.indexOf(id);
        return Title_NameList.get(index);
    }
               @Override
    public Integer fromString(String type) {
        int index = Title_NameList.indexOf(type);
        return Title_idList.get(index);
    }
});

        
        
     username_idList = FXCollections.observableArrayList();
     username_NameList = FXCollections.observableArrayList();
try {
    Statement st = cnx.createStatement();
    ResultSet res = st.executeQuery("SELECT id, username FROM user");
    while (res.next()) {
        username_idList.add(res.getInt("id"));
        username_NameList.add(res.getString("username"));

    }
} catch (SQLException ex) {
    System.err.println(ex.getMessage());
    
  
}

// Set the choosemed ChoiceBox items to the medIdList
    username1.setItems(username_idList); 
      username1.setConverter(new StringConverter<Integer>() {
              @Override
    public String toString(Integer id) {
        int index = username_idList.indexOf(id);
        return username_NameList.get(index);
    }
               @Override
    public Integer fromString(String type) {
        int index = username_NameList.indexOf(type);
        return username_idList.get(index);
    }
});

        
        // TODO
    }  

    @FXML
    private void adddonation(ActionEvent event) throws IOException {
        
         cnx = DatabaseHandler.getInstance().getCnx();
                  if(inputsControl())
            {
                int username_id = username1.getValue();
                int title_id= CharityTitleChooser.getValue();
               
                Float pointsdonated = Float.parseFloat(amount.getText());
                Date datedonation = java.sql.Date.valueOf(Datedonationc.getValue());
                
                
               // demand.setUsername_id(username.getValue());
               // demand.setCategory_id(Category.getValue());
                //demand.setTitle(titlec.getText());
                 //demand.setReceiver(receiverc.getText());
                //demand.setPointsdemanded(Float.parseFloat(amount.getText()));
               //demand.setDatedemand(java.sql.Date.valueOf(Datech.getValue()));
                //demand.getFile_upload();
               Donation donation =new Donation( username_id,  title_id,  pointsdonated,  datedonation);
              //Reports pv = new Reports(pn, cn, pt, pd, date, Cfrom);
               myservice.ajouter(donation);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Donation Ajoutée !");
                alert.setContentText("Demande  Ajoutée Avec Succés!");
                alert.show();
                 Parent root = FXMLLoader.load(getClass().getResource("/RentRewards/UI/MainPage/home.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
                //afficher();
            }
    }      

    private boolean inputsControl() {
    if ( amount.getText().trim().isEmpty()  )
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("\n" +
                    "Veuillez vérifier les champs");
            alert.show();
            return false;
        }
        return true; 
    }
    
}
