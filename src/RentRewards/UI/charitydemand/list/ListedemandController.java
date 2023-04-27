/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentRewards.UI.charitydemand.list;

import RentRewards.UI.charitydemand.add.NewCharityController;
import RentRewards.UI.charitydemand.viewsingl.ViewsingleController;
import RentRewards.entities.CharityDemand.Charity_Demand;
import RentRewards.entities.CharityDemand.ServicecharityDemand;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import RentRewards.database.DatabaseHandler;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.C;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class ListedemandController implements Initializable {
     Charity_Demand demand =new Charity_Demand();
     ServicecharityDemand myservice =new ServicecharityDemand();

    private final ObservableList<Charity_Demand> dataList = FXCollections.observableArrayList();


    @FXML
    private ImageView imagebckground;
    @FXML
    private TableView<Charity_Demand> tabCharity;
   
 private Connection cnx;
    @FXML
    private TableColumn<Charity_Demand, String> CTitle;
    @FXML
    private TableColumn<Charity_Demand, String> Creceiver;
    @FXML
    private TableColumn<Charity_Demand, String> Cusername;
    @FXML
    private TableColumn<Charity_Demand, String> Ccategory;
    @FXML
    private TableColumn<Charity_Demand, String> Cpoints;
    @FXML
    private TableColumn<Charity_Demand, String> Cimage;
    @FXML
    private TableColumn<Charity_Demand, String> Cdate;
    
    ObservableList<Charity_Demand> obl = FXCollections.observableArrayList();
    @FXML
    private ListView<Charity_Demand> listedemand;
    @FXML
    private Button modDembtn;
    @FXML
    private Button SuppDembtn;
    @FXML
    private Button Affdembtn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize (URL url, ResourceBundle rb) {
       afficher();
         

    }    

  
 


  
 

    @FXML
    private void showselecteditem(MouseEvent event) {
         ServicecharityDemand  myservice = new ServicecharityDemand();
        CTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
         Creceiver.setCellValueFactory(new PropertyValueFactory<>("receiver"));
          Cusername.setCellValueFactory(new PropertyValueFactory<>("username_id"));
          Ccategory.setCellValueFactory(new PropertyValueFactory<>("category_id"));
          Cpoints.setCellValueFactory(new PropertyValueFactory<>("pointsdemanded"));
          Cdate.setCellValueFactory(new PropertyValueFactory<>("file_upload"));
           Cimage.setCellValueFactory(new PropertyValueFactory<>("datedemand"));
           List<Charity_Demand> listreservation = myservice.afficher();
        ObservableList<Charity_Demand> observableList = FXCollections.observableList(listreservation);
           
           tabCharity.setItems(observableList);  
           afficher();
             
         
    }

   

    @FXML
    private void Supprimer(ActionEvent event) {
           // Vérifier si un élément est sélectionné
    Charity_Demand selectedItem = listedemand.getSelectionModel().getSelectedItem();
    if (selectedItem == null) {
        // Si aucun élément n'est sélectionné, afficher un message d'erreur
        // ouvrir une boite de dialogue par exemple
        return;
    }
    
    // Demander la confirmation de la suppression
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Confirmation de la suppression");
    alert.setHeaderText("Supprimer la demande de charité : " + selectedItem.getTitle());
    alert.setContentText("Êtes-vous sûr de vouloir supprimer cette demande ?");
    Optional<ButtonType> result = alert.showAndWait();
    if (result.get() != ButtonType.OK){
        // Si l'utilisateur annule la suppression, ne rien faire
        return;
    }
    
    // Supprimer l'élément sélectionné
    ServicecharityDemand myservice = new ServicecharityDemand();
    
          myservice.supprimer(selectedItem);
   
        // Si la suppression est réussie, supprimer l'élément de la liste et afficher un message de confirmation
        dataList.remove(selectedItem);
        Alert confirmation = new Alert(AlertType.INFORMATION);
        confirmation.setTitle("Demande de charité supprimée");
        confirmation.setHeaderText(null);
        confirmation.setContentText("La demande de charité a été supprimée avec succès.");
        confirmation.showAndWait();
        afficher();
         
         
      
    
        // Si la suppression échoue, afficher un message d'erreur
     
    
        
    }
    
        
    


  protected void afficher(){
List<Charity_Demand> listreservation = myservice.afficher();
        ObservableList<Charity_Demand> observableList = FXCollections.observableList(listreservation);
           
          listedemand.setItems(observableList);
         
  } 

   

    @FXML
    private void Modifier(ActionEvent event) throws IOException {
        
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("modification");
        alert.setContentText("Voulez vous vraiment modifier cette demande ?");
        Optional<ButtonType> result=alert.showAndWait();
        if (result.isPresent()&& result.get()==ButtonType.OK)
        {
                Charity_Demand selectedItem = listedemand.getSelectionModel().getSelectedItem();
                     FXMLLoader loader = new FXMLLoader(getClass().getResource("/RentRewards/UI/charitydemand/Add/newCharity.fxml"));
                   Parent parent = loader.load();

            NewCharityController controller = (NewCharityController) loader.getController();
            controller.infalteUI(selectedItem);

            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Edit demand");
            stage.setScene(new Scene(parent));
            stage.show();

            
    }}

    @FXML
    private void Afficher(ActionEvent event) throws IOException {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("view more");
        alert.setContentText("Voulez vous vraiment consulter cette demande ?");
        Optional<ButtonType> result=alert.showAndWait();
        if (result.isPresent()&& result.get()==ButtonType.OK)
        {
                Charity_Demand selectedItem = listedemand.getSelectionModel().getSelectedItem();
                     FXMLLoader loader = new FXMLLoader(getClass().getResource("/RentRewards/UI/charitydemand/Viewsingl/Viewsingle.fxml"));
                   Parent parent = loader.load();

            ViewsingleController controller = (ViewsingleController) loader.getController();
            controller.infalteUI(selectedItem);

            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("view demand");
            stage.setScene(new Scene(parent));
            stage.show();
        }
        
        
        
    }

    //@FXML
   // private void showselecteditem(SortEvent<C> event) {
    //}

    @FXML
    private void ShowselectedIdemend(ActionEvent event) {
    }

  
   

    
    
}
      
    
            
      
            
            
      
                     


    
       
    

