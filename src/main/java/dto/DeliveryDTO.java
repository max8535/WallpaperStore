package dto;

import Models.Delivery;
import Models.Item;
import Models.Store;
import Repositories.CategoryRepository;
import Repositories.ItemRepository;
import Repositories.ManufactureRepository;
import Repositories.StoreRepository;

import java.time.LocalDateTime;

public class DeliveryDTO {
    private int ID;
    private Store store;
    private Item item;
    private LocalDateTime delivery_date;
    private int delivery_amount;

    public DeliveryDTO() {
    }

    public DeliveryDTO(int ID, Store store, Item item, LocalDateTime delivery_date,int delivery_amount) {
        this.ID = ID;
        this.store = store;
        this.item = item;
        this.delivery_date = delivery_date;
        this.delivery_amount = delivery_amount;
    }
    public static DeliveryDTO toDeliveryDTO(Delivery v) {
        DeliveryDTO r = new DeliveryDTO();
        try {
            r.setID(v.getID());
            r.setStore(StoreRepository.findStoreById(v.getStore_id()).get(0));
            r.setItem(ItemRepository.findItemById(v.getItem_id()).get(0));
            r.setDelivery_date(v.getDelivery_date());
            r.setDelivery_amount(v.getDelivery_amount());
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
