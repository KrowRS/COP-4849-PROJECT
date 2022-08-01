
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author Joshua Lopez
 */
@Named(value = "priceBean")
@RequestScoped
@ManagedBean
public class PriceBean implements Serializable {
    @Inject
    private ConnectBean connectBean;

    public PriceBean() {
    }

    public List<PriceEntry> getAllPriceEntries() throws NamingException {
        List<PriceEntry> priceEntries = new ArrayList<>();
        Connection connection = connectBean.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from PRICE");
            while (resultSet.next()) {
                int prodID = resultSet.getInt("PRODID");
                String stdPrice = resultSet.getString("STDPRICE");
                String minPrice = resultSet.getString("MINPRICE");
                Date startDate = resultSet.getDate("STARTDATE");
                Date endDate = resultSet.getDate("ENDDATE");
                PriceEntry priceEntry = new PriceEntry(prodID, stdPrice, minPrice, startDate, endDate);
                priceEntries.add(priceEntry);
            }
            return priceEntries;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}