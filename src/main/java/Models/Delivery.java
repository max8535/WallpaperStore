package Models;

import java.time.LocalDateTime;

public class Delivery {
    private int ID;
    private int store_id;
    private int item_id;
    private LocalDateTime delivery_date;
    private int delivery_amount;

    public Delivery() {
    }

    public Delivery(int ID, int store_id, int item_id, LocalDateTime delivery_date, int delivery_amount) {
        this.ID = ID;
        this.store_id = store_id;
        this.item_id = item_id;
        this.delivery_date = delivery_date;
        this.delivery_amount = delivery_amount;
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

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public LocalDateTime getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(LocalDateTime delivery_date) {
        this.delivery_date = delivery_date;
    }

    public int getDelivery_amount() {
        return delivery_amount;
    }

    public void setDelivery_amount(int delivery_amount) {
        this.delivery_amount = delivery_amount;
    }
}
