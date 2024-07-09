package Repositories;

import Connect.DBConnect;
import Models.Category;
import Models.Manufacture;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ManufactureRepository {
    public static void add(Manufacture manufacture) throws UnsupportedEncodingException {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "insert into manufacture(manufacture_name,manufacture_adress) values (?,?)"
            );
            ps.setString(1,manufacture.getName());
            ps.setString(2,manufacture.getAddress());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "delete from manufacture where manufacture_id=?"
            );
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Manufacture manufacture) throws UnsupportedEncodingException {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "Update manufacture set manufacture_name=?, manufacture_adress=?" + "where manufacture_id=?"
            );
            ps.setString(1, manufacture.getName());
            ps.setString(2, manufacture.getAddress());
            ps.setInt(3,manufacture.getID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Manufacture> findManufactureById(int id) {
        List<Manufacture> all = new LinkedList<>();
        try (Connection connection = DBConnect.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select * from manufacture where manufacture_id=" + id).executeQuery();
            while (rs.next())
                all.add(new Manufacture(rs.getInt(1),rs.getString(2),rs.getString(3)));
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
    public static List<Manufacture> getAll(){
        List<Manufacture> all = new LinkedList<>();
        try (Connection connection = DBConnect.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select * from manufacture").executeQuery();
            while (rs.next())
                all.add(new Manufacture(rs.getInt(1),rs.getString(2),rs.getString(3)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }
}
