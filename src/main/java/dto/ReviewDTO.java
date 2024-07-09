package dto;

import Models.Customer;
import Models.Item;
import Models.Review;
import Repositories.CategoryRepository;
import Repositories.CustomerRepository;
import Repositories.ItemRepository;
import Repositories.ManufactureRepository;

import java.time.LocalDateTime;

public class ReviewDTO {
    private int ID;
    private Customer customer;
    private Item item;
    private LocalDateTime review_date;
    private String review_text;
    private int review_rate;

    public ReviewDTO() {
    }

    public ReviewDTO(int ID, Customer customer, Item item, LocalDateTime review_date, String review_text, int review_rate) {
        this.ID = ID;
        this.customer = customer;
        this.item = item;
        this.review_date = review_date;
        this.review_text = review_text;
        this.review_rate = review_rate;
    }
    public static ReviewDTO toReviewDTO(Review v) {
        ReviewDTO r = new ReviewDTO();
        try {
            r.setID(v.getID());
            r.setCustomer(CustomerRepository.findCustomerById(v.getCustomer_id()).get(0));
            r.setItem(ItemRepository.findItemById(v.getItem_id()).get(0));
            r.setReview_date(v.getReview_date());
            r.setReview_text(v.getReview_text());
            r.setReview_rate(v.getReview_rate());
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public LocalDateTime getReview_date() {
        return review_date;
    }

    public void setReview_date(LocalDateTime review_date) {
        this.review_date = review_date;
    }

    public String getReview_text() {
        return review_text;
    }

    public void setReview_text(String review_text) {
        this.review_text = review_text;
    }

    public int getReview_rate() {
        return review_rate;
    }

    public void setReview_rate(int review_rate) {
        this.review_rate = review_rate;
    }
}
