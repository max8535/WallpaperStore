package Repositories;

import Connect.DBConnect;
import Models.Delivery;
import Models.Store;
import dto.DeliveryDTO;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DeliveryRepository {
    public static void add(Delivery delivery) throws UnsupportedEncodingException {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "insert into delivery(store_id, item_id, delivery_date,delivery_amount) values (?,?,?,?)"
            );
            ps.setInt(1,delivery.getStore_id());
            ps.setInt(2,delivery.getItem_id());
            ps.setTimestamp(3, Timestamp.valueOf(delivery.getDelivery_date()));
            ps.setInt(4, delivery.getDelivery_amount());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "delete from delivery where delivery_id=?"
            );
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Delivery delivery) throws UnsupportedEncodingException {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "Update delivery set store_id=?, item_id=?, delivery_date=?,delivery_amount=?" + "where delivery_id=?"
            );
            ps.setInt(1, delivery.getStore_id());
            ps.setInt(2, delivery.getItem_id());
            ps.setTimestamp(3, Timestamp.valueOf(delivery.getDelivery_date()));
            ps.setInt(4, delivery.getDelivery_amount());
            ps.setInt(5, delivery.getID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Delivery> findDeliveryById(int id) {
        List<Delivery> all = new LinkedList<>();
        try (Connection connection = DBConnect.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select * from delivery where delivery_id=" + id).executeQuery();
            while (rs.next())
                all.add(new Delivery(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getTimestamp(4).toLocalDateTime(),rs.getInt(5)));
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
    public static List<DeliveryDTO> getAll(){
        List<DeliveryDTO> all = new LinkedList<>();
        try (Connection connection = DBConnect.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select * from delivery").executeQuery();
            while (rs.next())
                all.add(DeliveryDTO.toDeliveryDTO(new Delivery(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getTimestamp(4).toLocalDateTime(),rs.getInt(5))));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }
}
