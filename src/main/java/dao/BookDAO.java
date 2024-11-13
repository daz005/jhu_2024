package dao;

import beans.BookBean;
import utils.DatabaseUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    // Retrieves all books from the database
    public static List<BookBean> getAllBooks() {
        List<BookBean> books = new ArrayList<>();
        String query = "SELECT * FROM Books";
        try (
        		Connection conn = DatabaseUtil.getConnection();
        		PreparedStatement stmt = conn.prepareStatement(query);
        		ResultSet rs = stmt.executeQuery()
            ) 
        {
            while (rs.next()) {
                BookBean book = new BookBean();
                book.setBookID(rs.getInt("bookID"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setGenre(rs.getString("genre"));
                book.setPrice(rs.getDouble("price"));
                book.setAvailability(rs.getInt("availability"));
                book.setRating(rs.getDouble("rating"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    // Retrieves a specific book by ID
    public static BookBean getBookById(int bookID) {
        BookBean book = null;
        String query = "SELECT * FROM Books WHERE bookID=?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, bookID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    book = new BookBean();
                    book.setBookID(rs.getInt("bookID"));
                    book.setTitle(rs.getString("title"));
                    book.setAuthor(rs.getString("author"));
                    book.setGenre(rs.getString("genre"));
                    book.setPrice(rs.getDouble("price"));
                    book.setAvailability(rs.getInt("availability"));
                    book.setRating(rs.getDouble("rating"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
}
