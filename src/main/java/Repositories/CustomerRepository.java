package Repositories;

import Connect.DBConnect;
import Models.Customer;
import Utils.Utils;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CustomerRepository {
    public static void add(Customer customer) throws UnsupportedEncodingException {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "insert into customer(customer_fio, customer_number, customer_mail) values (?,?,?)"
            );
            ps.setString(1,customer.getFio());
            ps.setString(2, Utils.convertToUTF8(customer.getNumber()));
            ps.setString(3, Utils.convertToUTF8(customer.getMail()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps1 = connection.prepareStatement(
                    "delete from purchase_item where purchase_id in (select purchase_id from purchase where customer_id = ?)"
            );
            ps1.setInt(1, id);
            ps1.executeUpdate();
            PreparedStatement ps2 = connection.prepareStatement(
                    "delete from purchase where customer_id = ?"
            );
            ps2.setInt(1, id);
            ps2.executeUpdate();
            PreparedStatement ps = connection.prepareStatement(
                    "delete from customer where customer_id=?"
            );
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Customer customer) throws UnsupportedEncodingException {

        try (Connection connection = DBConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "Update customer set customer_fio=?, customer_number=?, customer_mail=?" + "where customer_id=?"
            );
            ps.setString(1, customer.getFio());
            ps.setString(2, Utils.convertToUTF8(customer.getNumber()));
            ps.setString(3, Utils.convertToUTF8(customer.getMail()));
            ps.setInt(4, customer.getID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> findCustomerById(int id) {
        List<Customer> all = new LinkedList<>();
        try (Connection connection = DBConnect.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select * from customer where customer_id=" + id).executeQuery();
            while (rs.next())
                all.add(new Customer(rs.getInt(1),rs.getString(2), Utils.convertToUTF8(rs.getString(3)), Utils.convertToUTF8(rs.getString(4))));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }
    public static List<Customer> getAll(){
        List<Customer> all = new LinkedList<>();
        try (Connection connection = DBConnect.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select * from customer").executeQuery();
            while (rs.next())
                all.add(new Customer(rs.getInt(1),rs.getString(2), Utils.convertToUTF8(rs.getString(3)), Utils.convertToUTF8(rs.getString(4))));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }
    public static List<Customer> findCustomerQuery(int query_id) {
        List<Customer> customer = new LinkedList<>();
        try (Connection connection = DBConnect.getConnection()) {
            switch (query_id){
                case 1:
                    ResultSet rs = connection.prepareStatement("select finaltabl.customer_id from" +
                            " (select pu.customer_id,sum(summ) as finalsum from purchase as pu," +
                            "(select a.purchase_id,sum(item_amount)as summ from purchase_item a , purchase k where a.purchase_id = k.purchase_id group by a.purchase_id)as pa " +
                            "where pu.purchase_id = pa.purchase_id and date_part('year',pu.purchase_date) = date_part('year',CURRENT_DATE) and date_part('month',pu.purchase_date) = date_part('month',CURRENT_DATE)" +
                            " group by pu.customer_id order by finalsum desc)as finaltabl limit 1").executeQuery();
                    while (rs.next()){
                        customer.add(CustomerRepository.findCustomerById(rs.getInt(1)).get(0));}
                    break;
                case 2:
                    ResultSet rs1 = connection.prepareStatement("select customer.customer_id from customer left join purchase on customer.customer_id = purchase.customer_id where purchase_id is NULL").executeQuery();
                    while (rs1.next()){
                        customer.add(CustomerRepository.findCustomerById(rs1.getInt(1)).get(0));}
                    break;

                case 3:
                    ResultSet rs2 = connection.prepareStatement("select customer.customer_id,count(*) as Количество_отзывов from customer inner join review on customer.customer_id = review.customer_id group by customer.customer_id order by Количество_отзывов desc limit 1").executeQuery();
                    while (rs2.next())
                        customer.add(CustomerRepository.findCustomerById(rs2.getInt(1)).get(0));
                    break;
                case 4:
                    ResultSet rs3 = connection.prepareStatement("select customer.customer_id,count(customer.customer_id) as Количество_покупок from customer inner join purchase on customer.customer_id = purchase.customer_id group by customer.customer_id having count(customer.customer_id)=1 ").executeQuery();
                    while (rs3.next())
                        customer.add(CustomerRepository.findCustomerById(rs3.getInt(1)).get(0));
                    break;
                /*case 5:
                    ResultSet rs = connection.prepareStatement("select finaltabl.customer_id from" +
                            " (select pu.customer_id,sum(summ) as finalsum from purchase as pu," +
                            "(select a.purchase_id,sum(item_amount)as summ from purchase_item a , purchase k where a.purchase_id = k.purchase_id group by a.purchase_id)as pa " +
                            "where pu.purchase_id = pa.purchase_id and date_part('year',pu.purchase_date) = date_part('year',CURRENT_DATE) and date_part('month',pu.purchase_date) = date_part('month',CURRENT_DATE)" +
                            " group by pu.customer_id order by finalsum desc)as finaltabl limit 1").executeQuery();
                    while (rs.next())
                        id.add (rs.getInt(1));*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return customer;
        }
    }

}
