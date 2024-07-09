package Models;

public class Customer {

    private int ID;
    private String fio;
    private String number;
    private String mail;

    public Customer(int ID, String fio, String number, String mail) {
        this.ID = ID;
        this.fio = fio;
        this.number = number;
        this.mail = mail;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
