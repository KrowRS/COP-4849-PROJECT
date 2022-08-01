package project;


import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 * @author Khembe Brothers
 */
@ManagedBean
public class ItemEntry implements Serializable {

    private String ordId;
    private String itemId;
    private String prodId;
    private String actualPrice;
    private String qty;
    private String itemTot;

    public ItemEntry() {

    }

    public ItemEntry(String ordId, String itemId, String prodId, String actualPrice, String qty, String itemTot) {
        this.ordId = ordId;
        this.itemId = itemId;
        this.prodId = prodId;
        this.actualPrice = actualPrice;
        this.qty = qty;
        this.itemTot = itemTot;
    }


    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(String actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getItemTot() {
        return itemTot;
    }

    public void setItemTot(String itemTot) {
        this.itemTot = itemTot;
    }
}