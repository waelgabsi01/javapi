/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentRewards.UI.categories.add;

import RentRewards.database.DatabaseHandler;
import RentRewards.entites.CharityCategory.CharityCategory;
import RentRewards.entites.CharityCategory.ServiceCharityCategory;
import RentRewards.entities.CharityDemand.Charity_Demand;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class NewcategorylistController implements Initializable {

    @FXML
    private ImageView bkg;
    @FXML
    private DatePicker datecategory;
    @FXML
    private Button btnsavecategory;
    
      Connection cnx;
         String query;
    @FXML
    private TextField typec;
    ServiceCharityCategory myservice1 =new ServiceCharityCategory();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void savecategorie(ActionEvent event) throws IOException {
        cnx = DatabaseHandler.getInstance().getCnx();
                  if(inputsControl())
            {
                String type = typec.getText();
             
                
                Date date_charity = java.sql.Date.valueOf(datecategory.getValue());
               
                
              
               CharityCategory category =new CharityCategory( type,  date_charity);
              //Reports pv = new Reports(pn, cn, pt, pd, date, Cfrom);
               myservice1.ajouter(category);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Category Ajoutée !");
                alert.setContentText("Category  Ajoutée Avec Succés!");
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
    if (typec.getText().trim().isEmpty()   )
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("\n" +
                    "Veuillez vérifier les champs");
            alert.show();
            return false;
        }
        return true;    }
    
             
        
    }
    

