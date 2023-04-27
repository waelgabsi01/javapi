/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentRewards.CharityDemand;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;



/**
 * FXML Controller class
 *
 * @author MSI
 */
public class CalendarController implements Initializable {

    @FXML
    private GridPane calendrier;
    @FXML
    private Label moisLabel;
    @FXML
    private TextField nomTextField;
    @FXML
    private DatePicker datePicker;
    
    private List<Evenement> evenements;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        evenements = new ArrayList<>();
         // Récupérer la date actuelle
        LocalDate date = LocalDate.now();

        // Afficher le mois et l'année
 moisLabel.setText(date.getMonth().getDisplayName(TextStyle.FULL, Locale.FRANCE) + " " + date.getYear());        // Afficher le calendrier du mois
        int numJour = 1;
        int numJourSemaine = date.withDayOfMonth(1).getDayOfWeek().getValue() % 7;
        int numJoursMois = date.lengthOfMonth();
        for (int row = 2; row < 8; row++) {
            for (int col = 0; col < 7; col++) {
                if ((row == 2 && col < numJourSemaine) || numJour > numJoursMois) {
                    // Case vide
                    continue;
                } else {
                    // Afficher le numéro de jour et
                       // Créer une colonne pour l'événement
                VBox colEvenement = new VBox();

                // Ajouter les événements de ce jour
                for (Evenement evt : evenements) {
                    if (evt.getDate().equals(date.withDayOfMonth(numJour))) {
                        Label lblEvt = new Label(evt.getNom());
                        colEvenement.getChildren().add(lblEvt);
                    }
                }

                // Ajouter le numéro de jour et les événements à la case
                VBox caseJour = new VBox(new Label(String.valueOf(numJour)), colEvenement);
                caseJour.getStyleClass().add("case-jour");
                calendrier.add(caseJour, col, row);

                numJour++;
            }
        }
        }
   }    

    @FXML
    private void ajouterEvenement(ActionEvent event) {
         // Récupérer les informations de l'événement à ajouter
        String nom = nomTextField.getText();
        LocalDate date = datePicker.getValue();

        // Ajouter l'événement à la liste
        Evenement evt = new Evenement(nom, date);
        evenements.add(evt);

        // Mettre à jour l'affichage du calendrier
        initialize(null, null);
         VBox colEvenement = (VBox) calendrier.getChildren().get(date.getDayOfMonth() + 6);
    Label lblEvt = new Label(evt.getNom());
    colEvenement.getChildren().add(lblEvt);
    }
    
    
}
