
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

import java.util.List;
import javax.annotation.ManagedBean;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.naming.NamingException;

/**
 * @author Nathan Lee
 */
@Named(value = "productBean")
@RequestScoped
@ManagedBean
public class ProductBean implements Serializable {
    @Inject
    private ConnectBean connectBean;

    public ProductBean() {
    }

    public List<ProductEntry> getAllProductEntries() throws NamingException {
        List<ProductEntry> productEntries = new ArrayList<>();
        Connection connection = connectBean.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from PRODUCT");
            while (resultSet.next()) {
                int prodID = resultSet.getInt("PRODID");
                String descrip = resultSet.getString("DESCRIP");
                ProductEntry productEntry = new ProductEntry(prodID, descrip);
                productEntries.add(productEntry);
            }
            return productEntries;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}