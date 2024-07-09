package Repositories;

import Connect.DBConnect;
import Models.Delivery;
import Models.Review;
import dto.DeliveryDTO;
import dto.ReviewDTO;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ReviewRepository {
    public static void add(Review review) throws UnsupportedEncodingException {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "insert into review(customer_id, item_id, review_date,review_text,review_rate) values (?,?,?,?,?)"
            );
            ps.setInt(1,review.getCustomer_id());
            ps.setInt(2,review.getItem_id());
            ps.setTimestamp(3, Timestamp.valueOf(review.getReview_date()));
            ps.setString(4,review.getReview_text());
            ps.setInt(5, review.getReview_rate());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "delete from review where review_id=?"
            );
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Review review) throws UnsupportedEncodingException {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "Update review set customer_id=?, item_id=?, review_date=?,review_text=?,review_rate=?" + "where review_id=?"
            );
            ps.setInt(1, review.getCustomer_id());
            ps.setInt(2, review.getItem_id());
            ps.setTimestamp(3, Timestamp.valueOf(review.getReview_date()));
            ps.setString(4, review.getReview_text());
            ps.setInt(5,review.getReview_rate());
            ps.setInt(6, review.getID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Review> findReviewById(int id) {
        List<Review> all = new LinkedList<>();
        try (Connection connection = DBConnect.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select * from review where review_id=" + id).executeQuery();
            while (rs.next())
                all.add(new Review(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getTimestamp(4).toLocalDateTime(),rs.getString(5),rs.getInt(6)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }
    /*public static int findCustomerQuery() {
        int id = 0;
        try (Connection connection = DBConnect.getConnection()) {
            ResultSet rs = connection.prepareStatement("select finaltabl.customer_id from" +
                    " (select pu.customer_id,sum(summ) as finalsum from purchase as pu," +
                    "(select a.purchase_id,sum(item_amount)as summ from purchase_item a , purchase k where a.purchase_id = k.purchase_id group by a.purchase_id)as pa " +
                    "where pu.purchase_id = pa.purchase_id and date_part('year',pu.purchase_date) = date_part('year',CURRENT_DATE) and date_part('month',pu.purchase_date) = date_part('month',CURRENT_DATE)" +
                    " group by pu.customer_id order by finalsum desc)as finaltabl limit 1").executeQuery();
            while (rs.next())
                id = rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return id;
        }
    }*/
    public static List<ReviewDTO> getAll(){
        List<ReviewDTO> all = new LinkedList<>();
        try (Connection connection = DBConnect.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select * from review").executeQuery();
            while (rs.next())
                all.add(ReviewDTO.toReviewDTO(new Review(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getTimestamp(4).toLocalDateTime(),rs.getString(5),rs.getInt(6))));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }
}
