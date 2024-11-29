package acmplex;

import java.sql.*;

public class Seats {
    private int seatID;
    private int showtimeid;
    private String seatNumber;
    private boolean isReserved;
    private int reservedBy;

    public Seats(int seatID, int showtimeid, String seatNumber, boolean isReserved, int reservedBy) {
        this.seatID = seatID;
        this.showtimeid = showtimeid;
        this.seatNumber = seatNumber;
        this.isReserved = isReserved;
        this.reservedBy = reservedBy;
    }

    // Getters and setters
    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public int getShowtimeid() {
        return showtimeid;
    }

    public void setShowtimeid(int showtimeid) {
        this.showtimeid = showtimeid;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public int getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(int reservedBy) {
        this.reservedBy = reservedBy;
    }
}
