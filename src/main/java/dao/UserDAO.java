package dao;

import beans.UserBean;
import utils.DatabaseUtil;

import java.sql.*;

public class UserDAO {

    // Validates user by checking email and password in the database
    public static UserBean validateUser(String email, String password) {
        UserBean user = null;
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Users WHERE email=? AND password=?")) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new UserBean();
                user.setUserID(rs.getInt("userID"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // Adds a new user to the database
    public static boolean registerUser(UserBean user) {
        String query = "INSERT INTO Users (name, email, password, address) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getAddress());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
