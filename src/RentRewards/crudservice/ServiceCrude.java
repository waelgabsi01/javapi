/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentRewards.crudservice;

import java.util.List;

/**
 *
 * @author MSI
 */
public interface ServiceCrude<T>  {
    
    public void ajouter(T p);
    public void modifier(T p);
    public void supprimer(T p);
    public List<T> afficher();
}

