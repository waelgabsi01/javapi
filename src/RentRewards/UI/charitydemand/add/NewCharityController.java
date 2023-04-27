/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentRewards.UI.charitydemand.add;

import RentRewards.database.DatabaseHandler;
import RentRewards.entites.CharityCategory.CharityCategory;
import RentRewards.entities.CharityDemand.Charity_Demand;
import RentRewards.entities.CharityDemand.ServicecharityDemand;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import roadrevel.resources.AlertMaker;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class NewCharityController implements Initializable {
    
      


    @FXML
    private ImageView imagebckground;
  
    @FXML
    private TextField amount;
    @FXML
    private ChoiceBox<Integer> Category;
   
    @FXML
    private Button Submitbtn;
      @FXML
    private DatePicker Datech;
    @FXML
    private ChoiceBox<Integer> username;
   // Charity_Demand demand =new Charity_Demand();
     ServicecharityDemand myservice =new ServicecharityDemand();
     int id ;
     int username_id;
     int category_id;
       private Boolean isInEditMode = Boolean.FALSE;

private ObservableList<Integer> category_idList;
private ObservableList<Integer> username_idList;
private ObservableList<String> category_NameList;
private ObservableList<String> username_NameList;

  
    
      Connection cnx;
         String query;
    @FXML
    private TextField titlec;
    @FXML
    private TextField receiverc;
    @FXML
    private TextField file;
  
     public NewCharityController() {
         cnx = DatabaseHandler.getInstance().getCnx();
    }
    

   /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Category_id
     category_idList = FXCollections.observableArrayList();
            category_NameList = FXCollections.observableArrayList();
 
     


     
        try {
            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery("SELECT id,type FROM charitycategory");
            while (res.next()) {
                
                category_idList.add(res.getInt("id"));
               category_NameList.add(res.getString("type"));

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        // Set the eventsIdChoiceBox items to the eventsIdList
        Category.setItems(category_idList);
      Category.setConverter(new StringConverter<Integer>() {
              @Override
    public String toString(Integer id) {
        int index = category_idList.indexOf(id);
        return category_NameList.get(index);
    }
               @Override
    public Integer fromString(String type) {
        int index = category_NameList.indexOf(type);
        return category_idList.get(index);
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
    username.setItems(username_idList); 
      username.setConverter(new StringConverter<Integer>() {
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
    private void Submit(ActionEvent event)throws IOException {
                 cnx = DatabaseHandler.getInstance().getCnx();
                    if (isInEditMode) {
            handleEditOperation();
            return;}
                  if(inputsControl())
            {
                int Username_id = username.getValue();
                int Category_id= Category.getValue();
                String title = titlec.getText();
                String receiver = receiverc.getText();
                Float pointsdemanded = Float.parseFloat(amount.getText());
                Date datedemand = java.sql.Date.valueOf(Datech.getValue());
                String file_upload =file.getText();
                
               // demand.setUsername_id(username.getValue());
               // demand.setCategory_id(Category.getValue());
                //demand.setTitle(titlec.getText());
                 //demand.setReceiver(receiverc.getText());
                //demand.setPointsdemanded(Float.parseFloat(amount.getText()));
               //demand.setDatedemand(java.sql.Date.valueOf(Datech.getValue()));
                //demand.getFile_upload();
               Charity_Demand demand =new Charity_Demand( Username_id,  Category_id,  title,  receiver, pointsdemanded,datedemand, file_upload);
              //Reports pv = new Reports(pn, cn, pt, pd, date, Cfrom);
               myservice.ajouter(demand);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Demande Ajoutée !");
                alert.setContentText("Demande  Ajoutée Avec Succés!");
                alert.show();
                 Parent root = FXMLLoader.load(getClass().getResource("/RentRewards/UI/charitydemand/list/listedemand.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
                //afficher();
            }
    }      

    private boolean inputsControl() {
    if (titlec.getText().trim().isEmpty() || receiverc.getText().trim().isEmpty() || amount.getText().trim().isEmpty()  )
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("\n" +
                    "Veuillez vérifier les champs");
            alert.show();
            return false;
        }
        return true;    }

    public void infalteUI(Charity_Demand selectedItem) {
                 
                 id = selectedItem.getId();
                titlec.setText(selectedItem.getTitle());
                receiverc.setText(selectedItem.getReceiver());
                String x = String.valueOf(selectedItem.getPointsdemanded());
                amount.setText(x);
                file.setText(selectedItem.getFile_upload());
                isInEditMode = Boolean.TRUE;
                
        
    }

    private void handleEditOperation() {
               Charity_Demand demand =new Charity_Demand( id, username.getValue(),  Category.getValue(),  titlec.getText(),  receiverc.getText(), Float.parseFloat(amount.getText()),java.sql.Date.valueOf(Datech.getValue()), file.getText());
             if (inputsControl()){
               myservice.modifier(demand);
             }
             
    }
    
    
                 

    }


