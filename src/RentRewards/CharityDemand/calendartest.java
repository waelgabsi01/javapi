/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentRewards.CharityDemand;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class calendartest extends Application  {


  

    

    public void start(Stage stage) throws Exception {
         try {
        Parent root = FXMLLoader.load(getClass().getResource("/RentRewards/CharityDemand/calendar.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
    
