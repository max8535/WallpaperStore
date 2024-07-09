package Models;

public class Item {
    private int ID;
    private int category_id;
    private int manufacture_id;
    private double price;

    public Item() {
    }

    public Item(int ID, int category_id, int manufacture_id, double price) {
        this.ID = ID;
        this.category_id = category_id;
        this.manufacture_id = manufacture_id;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getManufacture_id() {
        return manufacture_id;
    }

    public void setManufacture_id(int manufacture_id) {
        this.manufacture_id = manufacture_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
