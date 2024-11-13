package beans;

import java.io.Serializable;

public class BookBean implements Serializable {
    private static final long serialVersionUID = 1L;
	private int bookID;
    private String title;
    private String author;
    private String genre;
    private double price;
    private int availability;
    private double rating;

    // Default constructor
    public BookBean() {}

    // Parameterized constructor
    public BookBean(int bookID, String title, String author, String genre, double price, int availability, double rating) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.availability = availability;
        this.rating = rating;
    }

    // Getters and Setters
    public int getBookID() { return bookID; }
    public void setBookID(int bookID) { this.bookID = bookID; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getAvailability() { return availability; }
    public void setAvailability(int availability) { this.availability = availability; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
}
