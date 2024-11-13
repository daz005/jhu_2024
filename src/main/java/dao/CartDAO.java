package dao;

import beans.CartItemBean;
import utils.DatabaseUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {

    // Adds a book to the cart
    public static boolean addToCart(int userID, int bookID, int quantity) {
        String query = "INSERT INTO Cart (userID, bookID, quantity) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userID);
            stmt.setInt(2, bookID);
            stmt.setInt(3, quantity);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Retrieves all items in a user's cart
    public static List<CartItemBean> getCartItems(int userID) {
        List<CartItemBean> cartItems = new ArrayList<>();
        String query = "SELECT * FROM Cart WHERE userID=?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userID);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    CartItemBean cartItem = new CartItemBean();
                    cartItem.setCartItemID(rs.getInt("cartItemID"));
                    cartItem.setBookID(rs.getInt("bookID"));
                    cartItem.setQuantity(rs.getInt("quantity"));
                    cartItems.add(cartItem);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartItems;
    }
}
