/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roadrevel.resources;

import java.util.List;

/**
 *
 * @author GAMING A15
 */
public interface IService <T> {
    public void ajouter(T p);
    public void modifier(T p);
    public void supprimer(T p);
    public List<T> afficher();
}
