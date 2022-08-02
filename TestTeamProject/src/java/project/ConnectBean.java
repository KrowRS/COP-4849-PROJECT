/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.sql.DataSource;

/**
 *
 * @author justin
 */
@Named(value = "connectBean")
@ManagedBean(eager=true)
@ApplicationScoped
public class ConnectBean {

    private DataSource dataSource;
    private String dataUrl = "jdbc:derby://localhost:1527/TestTeamProject";

    public ConnectBean() {

    }

    public Connection getConnection() {
        try {
            Connection c = DriverManager.getConnection(dataUrl);
            return c;
        } catch (Exception ignored) {
        }
        return null;
    }

}
