/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package project;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.naming.NamingException;

/**
 *
 * @author justin
 */
@Named(value = "orderBean")
@RequestScoped
@ManagedBean
public class OrderBean {

    @Inject
    private ConnectBean connectBean;

    /**
     * Creates a new instance of OrderBean
     */
    public OrderBean() {
    }

    public List<OrderEntry> getAllOrderEntries() throws NamingException {

        List<OrderEntry> orderEntries = new ArrayList<>();
        Connection connection = connectBean.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from ORD order by ORDID");
            while (resultSet.next()) {
                String ordId = resultSet.getString("ORDID");
                Date orderDate = resultSet.getDate("ORDERDATE");
                String commPlan = resultSet.getString("COMMPLAN");
                String custId = resultSet.getString("CUSTID");
                Date shipDate = resultSet.getDate("SHIPDATE");
                String total = resultSet.getString("TOTAL");
                OrderEntry orderEntry = new OrderEntry(ordId, orderDate, commPlan, custId, shipDate, total);
                orderEntries.add(orderEntry);
            }
            return orderEntries;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;

    }

}
