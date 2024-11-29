package acmplex;

public class User {
    private int userID;
    private boolean isRegistered;

    // Constructor
    public User(int userID, boolean isRegistered) {
        this.userID = userID;
        this.isRegistered = isRegistered;
    }

    // Getters and Setters
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }
}
