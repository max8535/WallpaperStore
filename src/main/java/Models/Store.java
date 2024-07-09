package Models;

public class Store {
    private int ID;
    private String name;
    private String number;
    private String address;
    private int open_time;
    private int close_time;

    public Store() {
    }

    public Store(int ID, String name, String number, String address, int open_time, int close_time) {
        this.ID = ID;
        this.name = name;
        this.number = number;
        this.address = address;
        this.open_time = open_time;
        this.close_time = close_time;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOpen_time() {
        return open_time;
    }

    public void setOpen_time(int open_time) {
        this.open_time = open_time;
    }

    public int getClose_time() {
        return close_time;
    }

    public void setClose_time(int close_time) {
        this.close_time = close_time;
    }
}
