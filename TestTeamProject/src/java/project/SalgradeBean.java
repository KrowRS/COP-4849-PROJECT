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
 * @author Phil
 */
@Named(value = "salgradeBean")
@RequestScoped
@ManagedBean
public class SalgradeBean implements Serializable {

    @Inject
    private ConnectBean connectBean;

    /**
     * Creates a new instance of SalgradeBean
     */
    public SalgradeBean() {
    }

    public List<SalgradeEntry> getAllSalgradeEntries() throws NamingException {

        List<SalgradeEntry> salgradeEntries = new ArrayList<>();
        Connection connection = connectBean.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from SALGRADE order by GRADE");
            while (resultSet.next()) {
                int grade = resultSet.getInt("GRADE");
                int loSal = resultSet.getInt("LOSAL");
                int hiSal = resultSet.getInt("HISAL");
                SalgradeEntry salgradeEntry = new SalgradeEntry(grade, loSal, hiSal);
                salgradeEntries.add(salgradeEntry);
            }
            return salgradeEntries;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;

    }

}
