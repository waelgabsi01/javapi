/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentRewards.CharityDemand;

import java.time.LocalDate;

/**
 *
 * @author MSI
 */

public class Evenement {
    private String nom;
    private LocalDate date;
    private String description;

    public Evenement(String nom, LocalDate date) {
        this.nom = nom;
        this.date = date;
    }

    public Evenement(String nom, LocalDate date, String description) {
        this.nom = nom;
        this.date = date;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}