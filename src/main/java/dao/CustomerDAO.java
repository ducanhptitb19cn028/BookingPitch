package dao;

import model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class CustomerDAO {
    public static void AddCustomer(Customer customer){
        try {
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO tblcustomers (name, email, phonenumber) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getPhonenumber());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean CustomerExists(Customer customer){
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT*FROM tblcustomers WHERE name = ? OR email = ? OR phonenumber = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getPhonenumber());
            ResultSet rs = ps.executeQuery();
            conn.close();
            if (rs.next()) return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
