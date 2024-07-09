package Repositories;

import Connect.DBConnect;
import Models.Stock;
import Models.Store;
import dto.StockDTO;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class StockRepository {
    public static void add(Stock stock) throws UnsupportedEncodingException {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "insert into stock(item_id, stock_amount, stock_adress) values (?,?,?)"
            );
            ps.setInt(1,stock.getItem_id());
            ps.setInt(2,stock.getStock_amount());
            ps.setString(3, stock.getStock_address());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "delete from stock where stock_id=?"
            );
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Stock stock) throws UnsupportedEncodingException {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "Update stock set item_id=?, stock_amount=?, stock_adress=?" + "where stock_id=?"
            );
            ps.setInt(1, stock.getItem_id());
            ps.setInt(2, stock.getStock_amount());
            ps.setString(3, stock.getStock_address());
            ps.setInt(4, stock.getID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Stock> findStockById(int id) {
        List<Stock> all = new LinkedList<>();
        try (Connection connection = DBConnect.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select * from stock where stock_id=" + id).executeQuery();
            while (rs.next())
                all.add(new Stock(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getString(4)));
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
    public static List<StockDTO> getAll(){
        List<StockDTO> all = new LinkedList<>();
        try (Connection connection = DBConnect.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select * from stock").executeQuery();
            while (rs.next())
                all.add(StockDTO.toStockDTO(new Stock(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getString(4))));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }
}
