package Models;

public class Stock {
    private int ID;
    private int item_id;
    private int stock_amount;
    private String stock_address;

    public Stock() {
    }

    public Stock(int ID, int item_id, int stock_amount, String stock_address) {
        this.ID = ID;
        this.item_id = item_id;
        this.stock_amount = stock_amount;
        this.stock_address = stock_address;
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

    public int getStock_amount() {
        return stock_amount;
    }

    public void setStock_amount(int stock_amount) {
        this.stock_amount = stock_amount;
    }

    public String getStock_address() {
        return stock_address;
    }

    public void setStock_address(String stock_address) {
        this.stock_address = stock_address;
    }
}
