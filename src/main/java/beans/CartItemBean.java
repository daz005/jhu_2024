package beans;

import java.io.Serializable;

public class CartItemBean implements Serializable {
    private static final long serialVersionUID = 1L;
	private int cartItemID;
    private int bookID;
    private int quantity;

    // Default constructor
    public CartItemBean() {}

    // Parameterized constructor
    public CartItemBean(int cartItemID, int bookID, int quantity) {
        this.cartItemID = cartItemID;
        this.bookID = bookID;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getCartItemID() { return cartItemID; }
    public void setCartItemID(int cartItemID) { this.cartItemID = cartItemID; }

    public int getBookID() { return bookID; }
    public void setBookID(int bookID) { this.bookID = bookID; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
