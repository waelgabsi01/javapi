/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentRewards.UI.MainPage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class HomeController implements Initializable {

    @FXML
    private Button createbtn;
    @FXML
    private Button viewbtn;
    @FXML
    private Button donatebtn;
    @FXML
    private ImageView imagebckground;
    @FXML
    private AnchorPane baretach;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void create(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/RentRewards/UI/charitydemand/add/newCharity.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void view(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/RentRewards/UI/charitydemand/list/listedemand.fxml"));
       Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void donate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/RentRewards/UI/donation/add/donation.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
}
