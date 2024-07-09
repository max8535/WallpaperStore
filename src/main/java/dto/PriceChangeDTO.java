package dto;

import Models.Item;
import Models.Price_change;
import Repositories.CategoryRepository;
import Repositories.ItemRepository;
import Repositories.ManufactureRepository;

import java.time.LocalDateTime;

public class PriceChangeDTO {
    private int ID;
    private Item item;
    private LocalDateTime change_date;
    private double change_price;

    public PriceChangeDTO() {
    }

    public PriceChangeDTO(int ID, Item item, LocalDateTime change_date, double change_price) {
        this.ID = ID;
        this.item = item;
        this.change_date = change_date;
        this.change_price = change_price;
    }
    public static PriceChangeDTO toPriceChangeDTO(Price_change v) {
        PriceChangeDTO r = new PriceChangeDTO();
        try {
            r.setID(v.getID());
            r.setItem(ItemRepository.findItemById(v.getItem_id()).get(0));
            r.setChange_date(v.getChange_date());
            r.setChange_price(v.getChange_price());
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
