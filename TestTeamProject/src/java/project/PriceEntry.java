/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
/**
 *
 * @author Joshua Lopez
 */
@ManagedBean
public class PriceEntry implements Serializable{
    private int prodID;
    private String stdPrice;
    private String minPrice;
    private Date startDate;
    private Date endDate;
public PriceEntry() {}

public PriceEntry(int prodID, String stdPrice, String minPrice, Date startDate, Date endDate) {
    this.prodID = prodID;
    this.stdPrice = stdPrice;
    this.minPrice = minPrice;
    this.startDate = startDate;
    this.endDate = endDate;
}

    public int getProdID() {
        return prodID;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    public String getStdPrice() {
        return stdPrice;
    }

    public void setStdPrice(String stdPrice) {
        this.stdPrice = stdPrice;
    }
    
    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }
    
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}

