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
 * @author justin
 */
@ManagedBean
public class OrderEntry implements Serializable {

    private String ordId;
    private Date orderDate;
    private String commPlan;
    private String custId;
    private Date shipDate;
    private String total;

    public OrderEntry() {
    }

    public OrderEntry(String ordId, Date orderDate, String commPlan, String custId, Date shipDate, String total) {
        this.ordId = ordId;
        this.orderDate = orderDate;
        this.commPlan = commPlan;
        this.custId = custId;
        this.shipDate = shipDate;
        this.total = total;
    }

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getCommPlan() {
        return commPlan;
    }

    public void setCommPlan(String commPlan) {
        this.commPlan = commPlan;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

}
