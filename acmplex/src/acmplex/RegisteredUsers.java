package acmplex;

public class RegisteredUsers {
    public int userID;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public boolean annualFeePaid;
    public int addressID;

    // Constructor
    public RegisteredUsers(int userID, String firstName, String lastName, String email, String password, boolean annualFeePaid, int addressID) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.annualFeePaid = annualFeePaid;
        this.addressID = addressID;
    }

    
}
