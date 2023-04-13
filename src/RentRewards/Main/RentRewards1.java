/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentRewards.Main;

import RentRewards.entites.CharityCategory.CharityCategory;
import RentRewards.entites.CharityCategory.ServiceCharityCategory;
import RentRewards.entities.CharityDemand.Charity_Demand;
import RentRewards.entities.CharityDemand.ServicecharityDemand;
import RentRewards.entities.Donation.Donation;
import RentRewards.entities.Donation.ServiceDonation;
import java.io.PrintStream;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 *
 * @author MSI
 */
public class RentRewards1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
    
    //ServiceDonation a = new ServiceDonation();
    //a.ajouter(new Donation(1,2,3,1f));   // create a new Donation object with a valid date of birth
       // ServiceDonation a = new ServiceDonation();
    //Donation d = new Donation(1, 2, 3, 1f,Date.valueOf("2000-01-01"));
   
    //a.ajouter(d);
     //ServiceDonation a = new ServiceDonation();
       // Donation d = new Donation(1, 2, 3, 1f, Date.valueOf("2000-01-01"));
        //a.ajouter(new Donation(1, 2, 3, 1f, d));

  //_________________________________________________________________________________________________________________________________
//                       ******************* verification crude categorie **********************
//_________________________________________________________________________________________________________________________________   
 System.out.println("verification crude Categorie "); 
 ServiceCharityCategory P =new ServiceCharityCategory();
CharityCategory O = new CharityCategory( 100,"hello",Date.valueOf("2000-01-01"));
CharityCategory I = new CharityCategory( 101,"hello",Date.valueOf("2000-01-02"));
CharityCategory U = new CharityCategory( 102,"hello",Date.valueOf("2000-01-03"));


//P.ajouter(O);
//P.ajouter(I);
//P.ajouter(U);



P.modifier(new CharityCategory( 100,"hI",Date.valueOf("2000-01-05")));
P.supprimer(O);
System.out.println(P.afficher());

        
        ServiceDonation a = new ServiceDonation();


//_________________________________________________________________________________________________________________________________
//                       ******************* verification crude charitydemand **********************
//_________________________________________________________________________________________________________________________________
System.out.println("verification crude CHARITY DEMAND "); 
 ServicecharityDemand z =new ServicecharityDemand();
Charity_Demand v = new Charity_Demand( 10,3,100,"hello","hello", 1f ,Date.valueOf("2000-01-01"),"file.jpg");
Charity_Demand n = new Charity_Demand( 11,3,101,"hello","hello", 1f ,Date.valueOf("2000-01-01"),"file.jpg");
Charity_Demand m = new Charity_Demand( 12,3,102,"hello","hello", 1f ,Date.valueOf("2000-01-01"),"file.jpg");
Charity_Demand q = new Charity_Demand( 13,3,102,"hello","hello", 1f ,Date.valueOf("2000-01-01"),"file.jpg");

//z.ajouter(v);
//z.ajouter(n);
//z.ajouter(m);

//z.ajouter(q);

//z.modifier(new Charity_Demand( 10,3,1,"hi","hi", 1f ,Date.valueOf("2000-01-04"),"filemodifiee.jpg"));
//z.supprimer(n);
System.out.println(z.afficher()); 

 //_____________________________________________________________________________________________________________________________       
 //                       ******************* verification crude donation **********************
 //_____________________________________________________________________________________________________________________________
 System.out.println("verification crude DONATION "); 
Donation x = new Donation( 10,3,10, 1f, Date.valueOf("2000-01-01"));
Donation b = new Donation( 3,3,11, 1f, Date.valueOf("2000-01-01"));
Donation c = new Donation( 4,3,12, 1f, Date.valueOf("2000-01-01"));
Donation d = new Donation( 5,3,13, 1f, Date.valueOf("2000-01-01"));



//a.ajouter(b);
//a.ajouter(c);
//a.ajouter(d);

a.modifier(new Donation(9,3,1,1f,Date.valueOf("2022-03-01")));
//a.supprimer(d);
System.out.println(a.afficher()); 

    }
    
}
      


    
     
    

