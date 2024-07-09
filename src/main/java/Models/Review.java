package Models;

import java.time.LocalDateTime;

public class Review {
    private int ID;
    private int customer_id;
    private int item_id;
    private LocalDateTime review_date;
    private String review_text;
    private int review_rate;

    public Review() {
    }

    public Review(int ID, int customer_id, int item_id, LocalDateTime review_date, String review_text, int review_rate) {
        this.ID = ID;
        this.customer_id = customer_id;
        this.item_id = item_id;
        this.review_date = review_date;
        this.review_text = review_text;
        this.review_rate = review_rate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
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
