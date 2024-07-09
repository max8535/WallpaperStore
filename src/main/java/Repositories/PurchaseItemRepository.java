package Repositories;

import Connect.DBConnect;
import Models.Purchase;
import Models.Purchase_item;
import dto.PurchaseDTO;
import dto.PurchaseItemDTO;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PurchaseItemRepository {
    public static void add(Purchase_item purchase_item) throws UnsupportedEncodingException {
            double price=0;
        try (Connection connection = DBConnect.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select price from item where item_id=" + purchase_item.getItem_id()).executeQuery();
            while (rs.next())
                price = rs.getDouble(1);
            PreparedStatement ps = connection.prepareStatement(
                    "insert into purchase_item(purchase_id,item_id, item_amount, item_price) values (?,?,?,?)"
            );
            ps.setInt(1,purchase_item.getPurchase_id());
            ps.setInt(2, purchase_item.getItem_id());
            ps.setInt(3, purchase_item.getItem_amount());
            ps.setDouble(4, purchase_item.getItem_amount()* price);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int purchase_id, int item_id ) {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "delete from purchase_item where purchase_id=? and item_id=?"
            );
            ps.setInt(1, purchase_id);
            ps.setInt(2, item_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Purchase_item purchase_item) throws UnsupportedEncodingException {
double price = 0;
        try (Connection connection = DBConnect.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select price from item where item_id=" + purchase_item.getItem_id()).executeQuery();
            while (rs.next())
                price = rs.getDouble(1);
            PreparedStatement ps = connection.prepareStatement(
                    "Update purchase_item set purchase_id=?,item_id=?, item_amount=?, item_price=? where purchase_id=? and item_id=?"
            );
            ps.setInt(1, purchase_item.getPurchase_id());
            ps.setInt(2, purchase_item.getItem_id());
            ps.setInt(3, purchase_item.getItem_amount());
            ps.setDouble(4, purchase_item.getItem_amount()*price);
            ps.setInt(5, purchase_item.getPurchase_id());
            ps.setInt(6, purchase_item.getItem_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Purchase_item> findPurchaseItemById(int purchase_id,int item_id) {
        List<Purchase_item> all = new LinkedList<>();
        try (Connection connection = DBConnect.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select * from purchase_item where purchase_id=" + purchase_id+"and item_id="+item_id).executeQuery();
            while (rs.next())
                all.add(new Purchase_item(rs.getInt(1),rs.getInt(2),rs.getInt(3), rs.getDouble(4)));
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
    public static List<PurchaseItemDTO> getAll(){
        List<PurchaseItemDTO> all = new LinkedList<>();
        try (Connection connection = DBConnect.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select * from purchase_item").executeQuery();
            while (rs.next())
                all.add(PurchaseItemDTO.toPurchaseItemDTO(new Purchase_item(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getDouble(4))));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }
}
