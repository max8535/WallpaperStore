package Repositories;

import Connect.DBConnect;
import Models.Customer;
import Models.Store;
import Utils.Utils;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class StoreRepository {
    public static void add(Store store) throws UnsupportedEncodingException {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "insert into store(store_name, store_number, store_adress,open_time,close_time) values (?,?,?,?,?)"
            );
            ps.setString(1,store.getName());
            ps.setString(2,store.getNumber());
            ps.setString(3, store.getAddress());
            ps.setInt(4, store.getOpen_time());
            ps.setInt(5, store.getClose_time());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps1 = connection.prepareStatement(
                    "delete from purchase_item where purchase_id in (select purchase_id from purchase where store_id = ?)"
            );
            ps1.setInt(1, id);
            ps1.executeUpdate();
            PreparedStatement ps2 = connection.prepareStatement(
                    "delete from delivery where store_id = ?"
            );
            ps2.setInt(1, id);
            ps2.executeUpdate();
            PreparedStatement ps3 = connection.prepareStatement(
                    "delete from purchase where store_id=?"
            );
            ps3.setInt(1, id);
            ps3.executeUpdate();
            PreparedStatement ps4 = connection.prepareStatement(
                    "delete from store where store_id=?"
            );
            ps3.setInt(1, id);
            ps3.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Store store) throws UnsupportedEncodingException {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "Update store set store_name=?, store_number=?, store_adress=?,open_time=?,close_time=?" + "where store_id=?"
            );
            ps.setString(1, store.getName());
            ps.setString(2, store.getNumber());
            ps.setString(3, store.getAddress());
            ps.setInt(4, store.getOpen_time());
            ps.setInt(5, store.getClose_time());
            ps.setInt(6, store.getID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Store> findStoreById(int id) {
        List<Store> all = new LinkedList<>();
        try (Connection connection = DBConnect.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select * from store where store_id=" + id).executeQuery();
            while (rs.next())
                all.add(new Store(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5),rs.getInt(6)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }

    public static List<Store> getAll(){
        List<Store> all = new LinkedList<>();
        try (Connection connection = DBConnect.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select * from store").executeQuery();
            while (rs.next())
                all.add(new Store(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5),rs.getInt(6)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }
}
