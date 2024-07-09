package dto;

import Models.Category;
import Models.Item;
import Models.Manufacture;
import Repositories.CategoryRepository;
import Repositories.ManufactureRepository;

public class ItemDTO {
    private int ID;
    private Category category;
    private Manufacture manufacture;
    private double price;

    public ItemDTO() {
    }

    public ItemDTO(int ID, Category category, Manufacture manufacture, double price) {
        this.ID = ID;
        this.category = category;
        this.manufacture = manufacture;
        this.price = price;
    }
    public static ItemDTO toItemDTO(Item v) {
        ItemDTO r = new ItemDTO();
        try {
            r.setID(v.getID());
            r.setCategory(CategoryRepository.findCategoryById(v.getCategory_id()).get(0));
            r.setManufacture(ManufactureRepository.findManufactureById(v.getManufacture_id()).get(0));
            r.setPrice(v.getPrice());
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
