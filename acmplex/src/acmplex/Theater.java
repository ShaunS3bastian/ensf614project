package acmplex;

public class Theater {
    private int theaterID;  // Auto-incremented ID
    private String Name;
    private int addressID;

    // Constructor to initialize Theater with name and addressID
    public Theater(String Name, int addressID) {
        this.Name = Name;
        this.addressID = addressID;
    }

    // Getters and setters

    public int getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(int theaterID) {
        this.theaterID = theaterID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    // To display theater details
    @Override
    public String toString() {
        return "Theater ID: " + theaterID + ", Name: " + Name + ", Address ID: " + addressID;
    }
}
