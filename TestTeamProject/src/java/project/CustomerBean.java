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
@Named(value = "customerBean")
@RequestScoped
@ManagedBean
public class CustomerBean implements Serializable {

    @Inject
    private ConnectBean connectBean;

    /**
     * Creates a new instance of CustomerBean
     */
    public CustomerBean() {
    }

    public List<CustomerEntry> getAllCustomerEntries() throws NamingException {

        List<CustomerEntry> customerEntries = new ArrayList<>();
        Connection connection = connectBean.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from CUSTOMER");
            while (resultSet.next()) {

                int custId = resultSet.getInt("CUSTID");
                String name = resultSet.getString("NAME");
                String address = resultSet.getString("ADDRESS");
                String city = resultSet.getString("CITY");
                String state = resultSet.getString("STATE");
                String zip = resultSet.getString("ZIP");
                String area = resultSet.getString("AREA");
                String phone = resultSet.getString("PHONE");
                String repId = resultSet.getString("REPID");
                String creditLimit = resultSet.getString("CREDITLIMIT");
                String comments = resultSet.getString("COMMENTS");
                CustomerEntry customerEntry = new CustomerEntry(custId, name, address, city, state, zip, area, phone, repId, creditLimit, comments);
                customerEntries.add(customerEntry);
            }
            return customerEntries;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

}
