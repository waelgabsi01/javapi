/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RentRewards.entites.CharityCategory;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author MSI
 */
public class CharityCategory {
   private  int id;
   private String type;
   private Date date_charity;

    public CharityCategory(int id, String type, Date date_charity) {
        this.id = id;
        this.type = type;
        this.date_charity = date_charity;
    }

    public CharityCategory(String type, Date date_charity) {
        this.type = type;
        this.date_charity = date_charity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate_charity() {
        return date_charity;
    }
 
    public void setDate_charity(java.sql.Date date_charity) {
        this.date_charity = date_charity;
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
        final CharityCategory other = (CharityCategory) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.date_charity, other.date_charity)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CharityCategory{" + "id=" + id + ", type=" + type + ", date_charity=" + date_charity + '}';
    }
   
   
   
}
