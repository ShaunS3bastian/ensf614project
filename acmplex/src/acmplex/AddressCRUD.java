package acmplex;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressCRUD {
    private Connection connection;

    // Constructor to initialize the connection
    public AddressCRUD(Connection connection) {
        this.connection = connection;
    }

    // Create a new address
    public void createAddress(Address address) throws SQLException {
        String sql = "INSERT INTO Address (street, city, province, country, postalCode) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, address.getStreet());
            stmt.setString(2, address.getCity());
            stmt.setString(3, address.getProvince());
            stmt.setString(4, address.getCountry());
            stmt.setString(5, address.getPostalCode());
            stmt.executeUpdate();
            System.out.println("Address created successfully.");
        }
    }

    // Read all addresses
    public List<Address> getAllAddresses() throws SQLException {
        List<Address> addresses = new ArrayList<>();
        String sql = "SELECT * FROM Address";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Address address = new Address(
                        rs.getInt("addressID"),
                        rs.getString("street"),
                        rs.getString("city"),
                        rs.getString("province"),
                        rs.getString("country"),
                        rs.getString("postalCode")
                );
                addresses.add(address);
            }
        }
        return addresses;
    }

    // Read address details by ID
    public Address getAddressById(int addressID) throws SQLException {
        String sql = "SELECT * FROM Address WHERE addressID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, addressID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Address(
                            rs.getInt("addressID"),
                            rs.getString("street"),
                            rs.getString("city"),
                            rs.getString("province"),
                            rs.getString("country"),
                            rs.getString("postalCode")
                    );
                } else {
                    System.out.println("Address not found.");
                    return null;
                }
            }
        }
    }

    // Update address details
    public void updateAddress(Address address) throws SQLException {
        String sql = "UPDATE Address SET street = ?, city = ?, province = ?, country = ?, postalCode = ? WHERE addressID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, address.getStreet());
            stmt.setString(2, address.getCity());
            stmt.setString(3, address.getProvince());
            stmt.setString(4, address.getCountry());
            stmt.setString(5, address.getPostalCode());
            stmt.setInt(6, address.getAddressID());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Address updated successfully.");
            } else {
                System.out.println("Address not found.");
            }
        }
    }

    // Delete address by ID
    public void deleteAddress(int addressID) throws SQLException {
        String sql = "DELETE FROM Address WHERE addressID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, addressID);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Address deleted successfully.");
            } else {
                System.out.println("Address not found.");
            }
        }
    }
}
