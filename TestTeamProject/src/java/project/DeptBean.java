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
 * @author jeremy
 */
@Named(value = "deptBean")
@RequestScoped
@ManagedBean
public class DeptBean implements Serializable{


    @Inject
    private ConnectBean connectBean;

    /**
     * Creates a new instance of DeptBean
     */
    public DeptBean() {
    }
    
    public List<DeptEntry> getAllDeptEntries() throws NamingException {

        List<DeptEntry> deptEntries = new ArrayList<>();
        Connection connection = connectBean.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from DEPT order by DEPTNO");
            while (resultSet.next()) {
                int deptNo = resultSet.getInt("DEPTNO");
                String dName = resultSet.getString("DNAME");
                String loc = resultSet.getString("LOC");
                DeptEntry deptEntry = new DeptEntry(deptNo, dName, loc);
                deptEntries.add(deptEntry);
            }
            return deptEntries;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;

    }


}
