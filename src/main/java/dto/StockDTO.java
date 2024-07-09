package dto;

import Models.Item;
import Models.Stock;
import Repositories.CategoryRepository;
import Repositories.ItemRepository;
import Repositories.ManufactureRepository;

public class StockDTO {
    private int ID;
    private Item item;
    private int stock_amount;
    private String stock_address;

    public StockDTO() {
    }

    public StockDTO(int ID, Item item, int stock_amount, String stock_address) {
        this.ID = ID;
        this.item = item;
        this.stock_amount = stock_amount;
        this.stock_address = stock_address;
    }
    public static StockDTO toStockDTO(Stock v) {
        StockDTO r = new StockDTO();
        try {
            r.setID(v.getID());
            r.setItem(ItemRepository.findItemById(v.getItem_id()).get(0));
            r.setStock_amount(v.getStock_amount());
            r.setStock_address(v.getStock_address());
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
