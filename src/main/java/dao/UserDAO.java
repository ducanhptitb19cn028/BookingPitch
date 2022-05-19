package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {
    public static boolean getAuthenticatedUser(User user){
        try {
            Connection conn = DBConnection.getConnection();
            Statement stm= conn.createStatement();
            String query = "SELECT*FROM tblusers WHERE username=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            stm.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
