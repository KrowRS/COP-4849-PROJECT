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
 * @author Khembe Brothers
 * 
 */
@Named(value = "itemBean")
@RequestScoped
@ManagedBean
public class ItemBean implements Serializable {

    @Inject
    private ConnectBean connectBean;

    /**
     * Creates a new instance of ItemBean
     */
    public ItemBean() {
    }

    public List<ItemEntry> getAllItemEntries() throws NamingException {

        List<ItemEntry> itemEntries = new ArrayList<>();
        Connection connection = connectBean.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from ITEM");
            while (resultSet.next()) {

                String ordId = resultSet.getString("ORDID");
                String itemId = resultSet.getString("ITEMID");
                String prodId = resultSet.getString("PRODID");
                String actualPrice = resultSet.getString("ACTUALPRICE");
                String qty = resultSet.getString("QTY");
                String itemTot = resultSet.getString("ITEMTOT");
               
                ItemEntry itemEntry = new ItemEntry(ordId, itemId, prodId, actualPrice, qty, itemTot);
                itemEntries.add(itemEntry);
            }
            return itemEntries;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}