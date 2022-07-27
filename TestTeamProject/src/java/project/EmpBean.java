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
@Named(value = "empBean")
@RequestScoped
@ManagedBean
public class EmpBean implements Serializable {

    @Inject
    private ConnectBean connectBean;

    public EmpBean() {
    }

    public List<EmpEntry> getAllEmpEntries() throws NamingException {

        List<EmpEntry> empEntries = new ArrayList<>();
        Connection connection = connectBean.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from EMP");
            while (resultSet.next()) {
                int empNo = resultSet.getInt("EMPNO");
                String eName = resultSet.getString("ENAME");
                String job = resultSet.getString("JOB");
                int mgr = resultSet.getInt("MGR");
                Date hireDate = resultSet.getDate("HIREDATE");
                int sal = resultSet.getInt("SAL");
                int comm = resultSet.getInt("COMM");
                int deptNo = resultSet.getInt("DEPTNO");
                int grade = resultSet.getInt("GRADE");
                EmpEntry empEntry = new EmpEntry(empNo, eName, job, mgr, hireDate, sal, comm, deptNo, grade);
                empEntries.add(empEntry);
            }
            return empEntries;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;

    }

}
