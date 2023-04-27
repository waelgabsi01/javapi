/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentRewards.payement;

import com.google.gson.FieldNamingPolicy;
import com.stripe.model.Charge;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.Stripe;
import com.stripe.param.ChargeCreateParams;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import com.stripe.Stripe;
import com.stripe.param.ChargeCreateParams;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import payme.payy;

public class PayementController implements Initializable {

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
    private Label titleget;
    @FXML
    private Label valueget;
    @FXML
    private Label categoryget;
    @FXML
    private Label dateget;
    
    @FXML
    private Label paymentStatusLabel;
    
    private int amount;
    @FXML
    private Label amountch;
    @FXML
    private Label frequencych;
    @FXML
    private Label Totalch;

    @Override
    public void initialize(URL url, ResourceBundle rb ) {
        // initialize Stripe
                Stripe.apiKey = "sk_test_51N0nVDDXXNlJHCatFF4DTWc739qNPcC0m2tMDQWq6cSHerf9PTUM0DThWXA484ZABTxe7YwLIk0ExnpdArE2Wvr000Mg65WKM1";


        // set amount based on selected button
        dix.setOnAction(event -> {
            amount = 1;
               System.out.println(amount);
               amountch.setText(Integer.toString(amount));
        });

       dsonciqut.setOnAction(event -> {
    amount = 2;
   
    System.out.println(amount);
    amountch.setText(Integer.toString(amount)); // Convertir l'entier en chaîne de caractères
});

        son.setOnAction(event -> {
            amount = 3;
               System.out.println(amount);
               amountch.setText(Integer.toString(amount));
           
        });

        cinquant.setOnAction(event -> {
            amount = 4;
               System.out.println(amount);
               amountch.setText(Integer.toString(amount));
        });

        vin5.setOnAction(event -> {
            amount = 5;
   System.out.println(amount);
   amountch.setText(Integer.toString(amount));

        });
        
    }

    @FXML
    private void processPayment(ActionEvent event) {
        try {
           
         
            
                            Stripe.apiKey = "sk_test_51N0nVDDXXNlJHCatFF4DTWc739qNPcC0m2tMDQWq6cSHerf9PTUM0DThWXA484ZABTxe7YwLIk0ExnpdArE2Wvr000Mg65WKM1";

               System.out.println(amount);
             
                Gson gson = new GsonBuilder()
    .setPrettyPrinting()
    .create();

// create payment charge

            ChargeCreateParams chargeCreateParams1 = ChargeCreateParams.builder()
                    //.setAmount(Integer.parseInt(amount) * 100)
                 .setAmount(amount *100L)
                    .setCurrency("USD")
                    .setSource("tok_visa") // replace with your test card token
                    .setDescription("Test Payment")
                    .build();
                      Charge charge1 = Charge.create(chargeCreateParams1);


             System.out.println("Success! Here is your starter subscription price id: " + charge1.getId());

            // update payment status label
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Demande Ajoutée !");
                alert.setContentText("Payment Successful. Charge ID: " + charge1.getId());
                alert.show();
           paymentStatusLabel.setText("Payment Successful. Charge ID: " + charge1.getId());
             System.out.println("Success! Here is your starter subscription price id: " + charge1.getId());

        } catch (StripeException e) {
             System.out.println(e.getMessage()); 
            // update payment status label
           paymentStatusLabel.setText("Payment Failed. Error: " + e.getMessage());
        }
    }

    @FXML
    private void BTN1(ActionEvent event) {
        
    }

    @FXML
    private void Imprimer(ActionEvent event) {
    }

    @FXML
    private void Partager(ActionEvent event) {
    }

    @FXML
    private void Close(ActionEvent event) {
        
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(""));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
    private void Weekly(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/RentRewards/payement/Weekly.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}