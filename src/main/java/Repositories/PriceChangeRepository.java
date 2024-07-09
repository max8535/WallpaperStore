package Repositories;

import Connect.DBConnect;
import Models.Item;
import Models.Price_change;
import dto.ItemDTO;
import dto.PriceChangeDTO;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PriceChangeRepository {
    public static void add(Price_change change) throws UnsupportedEncodingException {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "insert into price_change(item_id, change_date, change_price) values (?,?,?)"
            );
            ps.setInt(1,change.getItem_id());
            ps.setTimestamp(2, Timestamp.valueOf(change.getChange_date()));
            ps.setDouble(3, change.getChange_price());
            ps.executeUpdate();
            PreparedStatement ch = connection.prepareStatement(
                    "update item set price=? where item_id = ?"
            );
            ch.setDouble(1,change.getChange_price());
            ch.setInt(2,change.getItem_id());
            ch.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "delete from price_change where change_id=?"
            );
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   /* public static void update(Price_change change) throws UnsupportedEncodingException {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "Update price_change set item_id=?, change_date=?, change_price=?" + "where change_id=?"
            );
            ps.setInt(1, change.getItem_id());
            ps.setTimestamp(2, Timestamp.valueOf(change.getChange_date()));
            ps.setDouble(3, change.getChange_price());
            ps.setInt(4, change.getID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    public static List<Price_change> findChangeById(int id) {
        List<Price_change> all = new LinkedList<>();
        try (Connection connection = DBConnect.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select * from price_change where change_id=" + id).executeQuery();
            while (rs.next())
                all.add(new Price_change(rs.getInt(1),rs.getInt(2), rs.getTimestamp(3).toLocalDateTime(),rs.getDouble(4)));
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
    public static List<PriceChangeDTO> getAll(){
        List<PriceChangeDTO> all = new LinkedList<>();
        try (Connection connection = DBConnect.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select * from price_change").executeQuery();
            while (rs.next())
                all.add(PriceChangeDTO.toPriceChangeDTO(new Price_change(rs.getInt(1),rs.getInt(2), rs.getTimestamp(3).toLocalDateTime(), rs.getDouble(4))));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }
}
