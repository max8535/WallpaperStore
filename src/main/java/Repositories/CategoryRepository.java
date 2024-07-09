package Repositories;

import Connect.DBConnect;
import Models.Category;
import Models.Customer;
import Utils.Utils;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CategoryRepository {

    public static void add(Category category) throws UnsupportedEncodingException {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "insert into category(category_name) values (?)"
            );
            ps.setString(1,category.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps1 = connection.prepareStatement(
                    "delete from purchase_item where item_id in (select item_id from item where category_id = ?)"
            );
            ps1.setInt(1, id);
            ps1.executeUpdate();
            PreparedStatement ps2 = connection.prepareStatement(
                    "delete from price_change where item_id in (select item_id from item where category_id = ?)"
            );
            ps2.setInt(1, id);
            ps2.executeUpdate();
            PreparedStatement ps = connection.prepareStatement(
                    "delete from delivery where item_id in (select item_id from item where category_id = ?)"
            );
            ps.setInt(1, id);
            ps.executeUpdate();
            PreparedStatement ps3 = connection.prepareStatement(
                    "delete from stock where item_id in (select item_id from item where category_id = ?)"
            );
            ps3.setInt(1, id);
            ps3.executeUpdate();
            PreparedStatement ps4 = connection.prepareStatement(
                    "delete from review where item_id in (select item_id from item where category_id = ?)"
            );
            ps4.setInt(1, id);
            ps4.executeUpdate();
            PreparedStatement ps5 = connection.prepareStatement(
                    "delete from item where category_id = ?"
            );
            ps5.setInt(1, id);
            ps5.executeUpdate();
            PreparedStatement ps6 = connection.prepareStatement(
                    "delete from category where category_id = ?"
            );
            ps6.setInt(1, id);
            ps6.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Category category) throws UnsupportedEncodingException {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "Update category set category_name=?" + "where category_id=?"
            );
            ps.setString(1, category.getName());
            ps.setInt(2, category.getID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Category> findCategoryById(int id) {
        List<Category> all = new LinkedList<>();
        try (Connection connection = DBConnect.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select * from category where category_id=" + id).executeQuery();
            while (rs.next())
                all.add(new Category(rs.getInt(1),rs.getString(2)));
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
    public static List<Category> getAll(){
        List<Category> all = new LinkedList<>();
        try (Connection connection = DBConnect.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select * from category").executeQuery();
            while (rs.next())
                all.add(new Category(rs.getInt(1),rs.getString(2)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }
}
