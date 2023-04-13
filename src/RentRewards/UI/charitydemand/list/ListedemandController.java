/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentRewards.UI.charitydemand.list;

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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    @FXML
    private TableColumn<Charity_Demand, String> colTitrecharite;
    @FXML
    private TableColumn<Charity_Demand, String> colreceiver;
    @FXML
    private TableColumn<Charity_Demand, String> colvalue;
    @FXML
    private TableColumn<Charity_Demand, String> coldate;
 private Connection cnx;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize (URL url, ResourceBundle rb) {
         // TODO

    }    

    @FXML
    private Stage showselecteditem(MouseEvent event)throws IOException, SQLException {
                
             List <Charity_Demand> list = myservice.afficher() ;
                
           
       
   String req = "SELECT * FROM charity_demand";
                PreparedStatement pst;
         pst = cnx.prepareStatement(req);
            ResultSet result = pst.executeQuery(); 
                list.add(new Charity_Demand(result.getInt("id"),result.getInt("username_id"),result.getInt("category_id"), result.getString("title"), result.getString("receiver"), result.getFloat("pointsdemanded"), result.getDate("datedemand"),result.getString("file_upload")));

       
return       (Stage) list;
         
}

    @FXML
    private void liste(SortEvent<i> event) {
         colTitrecharite.setCellValueFactory(new PropertyValueFactory<>("title"));
        colreceiver.setCellValueFactory(new PropertyValueFactory<>("receiver"));
        colvalue.setCellValueFactory(new PropertyValueFactory<>("pointsdemanded"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("datedemanded"));
  
    }
}
      
    
            
      
            
            
      
                     


    
       
    

