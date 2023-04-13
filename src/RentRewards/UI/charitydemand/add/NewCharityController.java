/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentRewards.UI.charitydemand.add;

import RentRewards.entites.CharityCategory.CharityCategory;
import RentRewards.entities.CharityDemand.Charity_Demand;
import RentRewards.entities.CharityDemand.ServicecharityDemand;
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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class NewCharityController implements Initializable {
    
       ServicecharityDemand myservice =new ServicecharityDemand();

//Charity_Demand demand =new Charity_Demand();

    @FXML
    private ImageView imagebckground;
    @FXML
    private TextField title;
    @FXML
    private TextField receiver;
    @FXML
    private TextField amount;
    
    @FXML
    private DatePicker Datep;
    @FXML
    private ChoiceBox<String> Category;
    @FXML
    private Button SAVEBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    private void SAVE(ActionEvent event) throws IOException {
        
        String x = title.getText();
       String y= receiver.getText();
        int z = Integer.parseInt(amount.getText());
        //Date date = Date.valueOf(Datep.getValue());
 //ServicecharityDemand myservice =new ServicecharityDemand();
         //ServicecharityDemand myservice =new ServicecharityDemand();
//Charity_Demand demand =new Charity_Demand();
       Charity_Demand demand =new Charity_Demand( x, y, z);
              ServicecharityDemand a =new ServicecharityDemand();

  if(inputsControl()){
            
                
               
        a.ajouter(demand);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Demande de charité ajoutée !");
        alert.setContentText("Demande de charité ajoutée avec succès !");
        alert.show();
        Parent root = FXMLLoader.load(getClass().getResource("/RentRewards/UI/charitydemand/list/listedemand.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();}
  
        
        
        
    }
     public boolean inputsControl(){
        if (title.getText().trim().isEmpty() || receiver.getText().trim().isEmpty() || amount.getText().trim().isEmpty() || Datep.getValue() == null ) {
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
    

