package Models;

import java.time.LocalDateTime;

public class Price_change {
    private int ID;
    private int item_id;
    private LocalDateTime change_date;
    private double change_price;

    public Price_change() {
    }

    public Price_change(int ID, int item_id, LocalDateTime change_date, double change_price) {
        this.ID = ID;
        this.item_id = item_id;
        this.change_date = change_date;
        this.change_price = change_price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public LocalDateTime getChange_date() {
        return change_date;
    }

    public void setChange_date(LocalDateTime change_date) {
        this.change_date = change_date;
    }

    public double getChange_price() {
        return change_price;
    }

    public void setChange_price(double change_price) {
        this.change_price = change_price;
    }
}
