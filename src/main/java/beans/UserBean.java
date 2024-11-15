package beans;

import java.io.Serializable;

public class UserBean implements Serializable {
    private static final long serialVersionUID = 1L;
	private int userID;
    private String name;
    private String email;
    private String password;
    private String address;

    // Default constructor
    public UserBean() {}

    // Parameterized constructor
    public UserBean(int userID, String name, String email, String password, String address) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    // Getters and Setters
    public int getUserID() { return userID; }
    public void setUserID(int userID) { this.userID = userID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
