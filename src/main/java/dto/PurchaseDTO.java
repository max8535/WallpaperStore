package dto;

import Models.Customer;
import Models.Item;
import Models.Purchase;
import Models.Store;
import Repositories.CategoryRepository;
import Repositories.CustomerRepository;
import Repositories.ManufactureRepository;
import Repositories.StoreRepository;

import java.time.LocalDateTime;

public class PurchaseDTO {
    private int ID;
    private Store store;
    private Customer customer;
    private LocalDateTime purchase_date;

    public PurchaseDTO() {
    }

    public PurchaseDTO(int ID, Store store, Customer customer, LocalDateTime purchase_date) {
        this.ID = ID;
        this.store = store;
        this.customer = customer;
        this.purchase_date = purchase_date;
    }
    public static PurchaseDTO toPurchaseDTO(Purchase v) {
        PurchaseDTO r = new PurchaseDTO();
        try {
            r.setID(v.getID());
            r.setStore(StoreRepository.findStoreById(v.getStore_id()).get(0));
            r.setCustomer(CustomerRepository.findCustomerById(v.getCustomer_id()).get(0));
            r.setPurchase_date(v.getPurchase_date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(LocalDateTime purchase_date) {
        this.purchase_date = purchase_date;
    }
}
