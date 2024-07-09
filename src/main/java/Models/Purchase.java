package Models;

import java.time.LocalDateTime;

public class Purchase {
    private int ID;
    private int store_id;
    private int customer_id;
    private LocalDateTime purchase_date;

    public Purchase() {
    }

    public Purchase(int ID, int store_id, int customer_id, LocalDateTime purchase_date) {
        this.ID = ID;
        this.store_id = store_id;
        this.customer_id = customer_id;
        this.purchase_date = purchase_date;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public LocalDateTime getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(LocalDateTime purchase_date) {
        this.purchase_date = purchase_date;
    }
}
