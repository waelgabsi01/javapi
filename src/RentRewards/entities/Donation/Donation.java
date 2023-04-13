/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentRewards.entities.Donation;

import java.util.Objects;
import java.sql.Date;

/**
 *
 * @author MSI
 */
public class Donation {
    
    private int id;
    private int username_id;
    private int title_id;
    private float pointsdonated;
    private Date datedonation;

    public Donation(int id, int username_id, int title_id, float pointsdonated, Date datedonation) {
        this.id = id;
        this.username_id = username_id;
        this.title_id = title_id;
        this.pointsdonated = pointsdonated;
        this.datedonation = datedonation;
    }

    public Donation(int title_id, float pointsdonated, Date datedonation) {
        this.title_id = title_id;
        this.pointsdonated = pointsdonated;
        this.datedonation = datedonation;
    }
    

    public Donation(float pointsdonated, Date datedonation) {
        this.pointsdonated = pointsdonated;
        this.datedonation = datedonation;
    }
    public Donation(int id, int username_id, int title_id, float pointsdonated) {
        this.id = id;
        this.username_id = username_id;
        this.title_id = title_id;
        this.pointsdonated = pointsdonated;
    }
     public Donation( int username_id, int title_id, float pointsdonated, Date datedonation) {
        
        this.username_id = username_id;
        this.title_id = title_id;
        this.pointsdonated = pointsdonated;
        this.datedonation = datedonation;
    }

    public Donation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsername_id() {
        return username_id;
    }

    public void setUsername_id(int username_id) {
        this.username_id = username_id;
    }

    public int getTitle_id() {
        return title_id;
    }

    public void setTitle_id(int title_id) {
        this.title_id = title_id;
    }

    public float getPointsdonated() {
        return pointsdonated;
    }

    public void setPointsdonated(float pointsdonated) {
        this.pointsdonated = pointsdonated;
    }

    public Date getDatedonation() {
        return datedonation;
    }

    //public void setDatedonation(Date datedonation) {
      //  this.datedonation = datedonation;
    //}
     public void setDatedonation(java.sql.Date datedonation) {
    this.datedonation = datedonation;
}
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Donation other = (Donation) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.username_id != other.username_id) {
            return false;
        }
        if (this.title_id != other.title_id) {
            return false;
        }
        if (Float.floatToIntBits(this.pointsdonated) != Float.floatToIntBits(other.pointsdonated)) {
            return false;
        }
        if (!Objects.equals(this.datedonation, other.datedonation)) {
            return false;
        }
        return true;
    }
     public void affecterDateExpiration(Date date){
        this.datedonation = date;
    }
  


    @Override
    public String toString() {
        return "\n"+" Donation{" + "id=" + id + ", username_id=" + username_id + ", title_id=" + title_id + ", pointsdonated=" + pointsdonated + ", datedonation=" + datedonation + '}';
    }
    
    

    
}
