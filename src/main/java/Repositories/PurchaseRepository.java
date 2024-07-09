package Repositories;

import Connect.DBConnect;
import Models.Item;
import Models.Purchase;
import dto.ItemDTO;
import dto.PurchaseDTO;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PurchaseRepository {
    public static void add(Purchase purchase) throws UnsupportedEncodingException {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "insert into purchase(store_id, customer_id, purchase_date) values (?,?,?)"
            );
            ps.setInt(1,purchase.getStore_id());
            ps.setInt(2, purchase.getCustomer_id());
            ps.setTimestamp(3, Timestamp.valueOf(purchase.getPurchase_date()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps1 = connection.prepareStatement(
                    "delete from purchase_item where purchase_id = ?)"
            );
            ps1.setInt(1, id);
            ps1.executeUpdate();
            PreparedStatement ps2 = connection.prepareStatement(
                    "delete from purchase where purchase_id = ?"
            );
            ps2.setInt(1, id);
            ps2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Purchase purchase) throws UnsupportedEncodingException {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "Update purchase set store_id=?, customer_id=?, purchase_date=?" + "where purchase_id=?"
            );
            ps.setInt(1, purchase.getStore_id());
            ps.setInt(2, purchase.getCustomer_id());
            ps.setTimestamp(3, Timestamp.valueOf(purchase.getPurchase_date()));
            ps.setInt(4, purchase.getID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Purchase> findPurchaseById(int id) {
        List<Purchase> all = new LinkedList<>();
        try (Connection connection = DBConnect.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select * from purchase where purchase_id=" + id).executeQuery();
            while (rs.next())
                all.add(new Purchase(rs.getInt(1),rs.getInt(2),rs.getInt(3), rs.getTimestamp(4).toLocalDateTime()));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }
    /* public static int findCustomerQuery() {
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
    public static List<PurchaseDTO> getAll(){
        List<PurchaseDTO> all = new LinkedList<>();
        try (Connection connection = DBConnect.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select * from purchase").executeQuery();
            while (rs.next())
                all.add(PurchaseDTO.toPurchaseDTO(new Purchase(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getTimestamp(4).toLocalDateTime())));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }
}
