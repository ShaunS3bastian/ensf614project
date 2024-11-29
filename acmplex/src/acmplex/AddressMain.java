package acmplex;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class AddressMain {
    public static void main(String[] args) {
        // Create a Scanner object for taking runtime input
        Scanner scanner = new Scanner(System.in);

        try {
            // Assuming you have a valid connection here (Replace with actual DB connection)
            Connection connection = DatabaseConnection.getConnection();

            // Create an instance of AddressCRUD
            AddressCRUD addressCRUD = new AddressCRUD(connection);

            // Prompt the user to input address details for creating a new address
            System.out.println("Enter Street:");
            String street = scanner.nextLine();

            System.out.println("Enter City:");
            String city = scanner.nextLine();

            System.out.println("Enter Province:");
            String province = scanner.nextLine();

            System.out.println("Enter Country:");
            String country = scanner.nextLine();

            System.out.println("Enter Postal Code:");
            String postalCode = scanner.nextLine();

            // Create a new address with the user inputs
            Address newAddress = new Address(0, street, city, province, country, postalCode);
            addressCRUD.createAddress(newAddress); // Insert new address

            // Ask user for addressID to retrieve an address
            System.out.println("Enter AddressID to fetch the address details:");
            int addressID = scanner.nextInt(); // Read integer for addressID
            scanner.nextLine(); // Consume the newline character left by nextInt()

            Address address = addressCRUD.getAddressById(addressID); // Get address by ID
            if (address != null) {
                System.out.println("AddressID: " + address.getAddressID() +
                                   ", Street: " + address.getStreet() +
                                   ", City: " + address.getCity() +
                                   ", Province: " + address.getProvince() +
                                   ", Country: " + address.getCountry() +
                                   ", Postal Code: " + address.getPostalCode());
            } else {
                System.out.println("Address not found.");
            }

            // Select and print all addresses
            List<Address> addresses = addressCRUD.getAllAddresses();
            System.out.println("\nAll Addresses:");
            for (Address addr : addresses) {
                System.out.println("AddressID: " + addr.getAddressID() +
                                   ", Street: " + addr.getStreet() +
                                   ", City: " + addr.getCity() +
                                   ", Province: " + addr.getProvince() +
                                   ", Country: " + addr.getCountry() +
                                   ", Postal Code: " + addr.getPostalCode());
            }

            // Prompt user to update an address
            System.out.println("Enter AddressID to update:");
            int updateAddressID = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.println("Enter new Street for the address:");
            String newStreet = scanner.nextLine();

            Address addressToUpdate = new Address(updateAddressID, newStreet, null, null, null, null);
            addressCRUD.updateAddress(addressToUpdate); // Update address with new street

            // Prompt user to delete an address
            System.out.println("Enter AddressID to delete:");
            int deleteAddressID = scanner.nextInt();
            addressCRUD.deleteAddress(deleteAddressID); // Delete address by ID

        } catch (SQLException e) {
            // Handle SQLException here
            e.printStackTrace();
        } finally {
            // Close the scanner to avoid memory leak
            scanner.close();
        }
    }
}
