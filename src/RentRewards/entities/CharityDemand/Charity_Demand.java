/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentRewards.entities.CharityDemand;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author MSI
 */
public class Charity_Demand {
    private int id;
    private int username_id;
    private int category_id ;
    private String title;
    private String receiver;
    private float pointsdemanded;
    private Date datedemand;
    private String file_upload;

    public Charity_Demand() {
    }
     public Charity_Demand(String title, String receiver, float pointsdemanded) {
        this.title = title;
        this.receiver = receiver;
        this.pointsdemanded = pointsdemanded;
     
    }

    public Charity_Demand(int category_id, String title, String receiver, float pointsdemanded, Date datedemand) {
        this.category_id = category_id;
        this.title = title;
        this.receiver = receiver;
        this.pointsdemanded = pointsdemanded;
        this.datedemand = datedemand;
    }

    public Charity_Demand(int category_id, String title, String receiver, float pointsdemanded, Date datedemand, String file_upload) {
        this.category_id = category_id;
        this.title = title;
        this.receiver = receiver;
        this.pointsdemanded = pointsdemanded;
        this.datedemand = datedemand;
        this.file_upload = file_upload;
    }
    
    

    public Charity_Demand(int id, int username_id, int category_id, String title, String receiver, float pointsdemanded, Date datedemand, String file_upload) {
        this.id = id;
        this.username_id = username_id;
        this.category_id = category_id;
        this.title = title;
        this.receiver = receiver;
        this.pointsdemanded = pointsdemanded;
        this.datedemand = datedemand;
        this.file_upload = file_upload;
    }

    public Charity_Demand(String title, String receiver, float pointsdemanded, Date datedemand, String file_upload) {
        this.title = title;
        this.receiver = receiver;
        this.pointsdemanded = pointsdemanded;
        this.datedemand = datedemand;
        this.file_upload = file_upload;
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

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public float getPointsdemanded() {
        return pointsdemanded;
    }

    public void setPointsdemanded(float pointsdemanded) {
        this.pointsdemanded = pointsdemanded;
    }

    public Date getDatedemand() {
        return datedemand;
    }

   // public void setDatedemand(Date datedemand) {
     //   this.datedemand = datedemand;
         public void setDatedemand(java.sql.Date datedonation) {
    this.datedemand = datedemand;
    }

    public String getFile_upload() {
        return file_upload;
    }

    public void setFile_upload(String file_upload) {
        this.file_upload = file_upload;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Charity_Demand other = (Charity_Demand) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.username_id != other.username_id) {
            return false;
        }
        if (this.category_id != other.category_id) {
            return false;
        }
        if (Float.floatToIntBits(this.pointsdemanded) != Float.floatToIntBits(other.pointsdemanded)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.receiver, other.receiver)) {
            return false;
        }
        if (!Objects.equals(this.file_upload, other.file_upload)) {
            return false;
        }
        if (!Objects.equals(this.datedemand, other.datedemand)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  "\n"+"Charity_Demand{" + "id=" + id + ", username_id=" + username_id + ", category_id=" + category_id + ", title=" + title + ", receiver=" + receiver + ", pointsdemanded=" + pointsdemanded + ", datedemand=" + datedemand + ", file_upload=" + file_upload + '}';
    }
    
    
    
    
}
