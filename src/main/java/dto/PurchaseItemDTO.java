package dto;

import Models.Item;
import Models.Purchase;
import Models.Purchase_item;
import Repositories.*;

public class PurchaseItemDTO {
    private Purchase purchase;
    private Item item;
    private int item_amount;
    private double price;

    public PurchaseItemDTO() {
    }

    public PurchaseItemDTO(Purchase purchase, Item item, int item_amount, double price) {
        this.purchase = purchase;
        this.item = item;
        this.item_amount = item_amount;
        this.price = price;
    }
    public static PurchaseItemDTO toPurchaseItemDTO(Purchase_item v) {
        PurchaseItemDTO r = new PurchaseItemDTO();
        try {
            r.setPurchase(PurchaseRepository.findPurchaseById(v.getPurchase_id()).get(0));
            r.setItem(ItemRepository.findItemById(v.getItem_id()).get(0));
            r.setItem_amount(v.getItem_amount());
            r.setPrice(v.getPrice());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
