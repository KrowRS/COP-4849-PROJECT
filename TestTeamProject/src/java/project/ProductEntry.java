/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
/**
 *
 * @author Nathan Lee
 */
@ManagedBean
public class ProductEntry implements Serializable{
    private int prodID;
    private String descrip;


public ProductEntry() {}

public ProductEntry(int prodID, String descrip) {
    this.prodID = prodID;
    this.descrip = descrip;
}

    public int getProdID() {
        return prodID;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }


}

