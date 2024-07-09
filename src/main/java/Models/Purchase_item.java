package Models;

public class Purchase_item {
    private int purchase_id;
    private int item_id;
    private int item_amount;
    private double price;

    public Purchase_item() {
    }

    public Purchase_item(int purchase_id, int item_id, int item_amount) {
        this.purchase_id = purchase_id;
        this.item_id = item_id;
        this.item_amount = item_amount;
    }
    public Purchase_item(int purchase_id, int item_id, int item_amount,double price) {
        this.purchase_id = purchase_id;
        this.item_id = item_id;
        this.item_amount = item_amount;
        this.price = price;
    }
    public int getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(int purchase_id) {
        this.purchase_id = purchase_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getItem_amount() {
        return item_amount;
    }

    public void setItem_amount(int item_amount) {
        this.item_amount = item_amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
