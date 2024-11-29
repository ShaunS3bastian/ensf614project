package acmplex;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class RegisteredUsersMain {
    public static void main(String[] args) {
        Connection connection = null;
        Scanner scanner = new Scanner(System.in);

        try {
            // Get the database connection using DatabaseConnection class
            connection = DatabaseConnection.getConnection();

            // Create an instance of RegisteredUsersCRUD
            RegisteredUsersCRUD userCRUD = new RegisteredUsersCRUD(connection);

            // Taking user input to create a new user
            System.out.print("Enter UserID: ");
            int userID = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            System.out.print("Has the annual fee been paid (true/false)? ");
            boolean annualFeePaid = scanner.nextBoolean();

            System.out.print("Enter AddressID: ");
            int addressID = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            // Create a new user
            RegisteredUsers newUser = new RegisteredUsers(userID, firstName, lastName, email, password, annualFeePaid, addressID);
            userCRUD.createUser(newUser);  // Now calling instance method
            System.out.println("User created successfully.");

            // Read user details
            System.out.print("Enter UserID to fetch details: ");
            int searchUserID = scanner.nextInt();
            RegisteredUsers user = userCRUD.getUserById(searchUserID);  // Calling instance method
            if (user != null) {
                System.out.println("UserID: " + user.userID + ", Name: " + user.firstName + " " + user.lastName);
            } else {
                System.out.println("User not found.");
            }

            // Update user details
            System.out.print("Enter UserID to update: ");
            int updateUserID = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
            RegisteredUsers updateUser = userCRUD.getUserById(updateUserID);  // Calling instance method
            if (updateUser != null) {
                System.out.print("Enter new First Name: ");
                updateUser.firstName = scanner.nextLine();
                System.out.print("Enter new Last Name: ");
                updateUser.lastName = scanner.nextLine();
                System.out.print("Enter new Email: ");
                updateUser.email = scanner.nextLine();
                System.out.print("Enter new Password: ");
                updateUser.password = scanner.nextLine();
                System.out.print("Has the annual fee been paid (true/false)? ");
                updateUser.annualFeePaid = scanner.nextBoolean();

                // Perform the update
                userCRUD.updateUser(updateUser);  // Calling instance method
                System.out.println("User updated successfully.");
            } else {
                System.out.println("User not found for updating.");
            }

            // Delete user
            System.out.print("Enter UserID to delete: ");
            int deleteUserID = scanner.nextInt();
            userCRUD.deleteUser(deleteUserID);  // Calling instance method
            System.out.println("User deleted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (connection != null) {
                    connection.close();
                }
                scanner.close(); // Close scanner
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
