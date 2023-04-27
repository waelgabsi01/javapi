/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentRewards.payement;

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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class WeeklyController implements Initializable {

    @FXML
    private ImageView imagebckground;
    @FXML
    private Button dix;
    @FXML
    private Button dsonciqut;
    @FXML
    private Button son;
    @FXML
    private Button cinquant;
    @FXML
    private Button vin5;
    @FXML
    private Label paymentStatusLabel;
    @FXML
    private Label dateget;
    @FXML
    private Label categoryget;
    @FXML
    private Label valueget;
    @FXML
    private Label titleget;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void BTN1(ActionEvent event) {
    }

    @FXML
    private void processPayment(ActionEvent event) {
    }

    @FXML
    private void Close(ActionEvent event) {
    }

    @FXML
    private void Back(ActionEvent event) {
    }

    @FXML
    private void Help(ActionEvent event) {
    }

    @FXML
    private void Home(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/RentRewards/UI/MainPage/home.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void EveryDay(ActionEvent event) {
    }

    @FXML
    private void EveryWeek(ActionEvent event) {
    }

    @FXML
    private void Activate(ActionEvent event) {
    }

    @FXML
    private void Desactive(ActionEvent event) {
    }

    @FXML
    private void Remove(ActionEvent event) {
    }
    
}
