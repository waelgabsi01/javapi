/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentRewards.UI.charitydemand.viewsingl;

import RentRewards.entities.CharityDemand.Charity_Demand;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class ViewsingleController implements Initializable {

    @FXML
    private ImageView imagebckground;
    @FXML
    private Label titleget;
    @FXML
    private Label titleget1;
    @FXML
    private Label titleget2;
    @FXML
    private Label titleget3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    

    public void infalteUI(Charity_Demand selectedItem) {
    
                titleget.setText(selectedItem.getTitle());
                titleget1.setText(selectedItem.getReceiver());
                String x = String.valueOf(selectedItem.getPointsdemanded());
                titleget2.setText(x);
                String y = String.valueOf(selectedItem.getDatedemand());
                titleget3.setText(y);
                
                
               
    }
   
}
