package acmplex;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class UserMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Create an instance of UserCRUD
            Connection connection = DatabaseConnection.getConnection(); // Ensure this is your connection
            UserCRUD userCRUD = new UserCRUD(connection);

            while (true) {
                // Display options
                System.out.println("\nSelect an operation:");
                System.out.println("1. Create User");
                System.out.println("2. Update User");
                System.out.println("3. Delete User");
                System.out.println("4. Exit");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1: // Create User
                        System.out.print("Enter User ID: ");
                        int userId = scanner.nextInt();
                        System.out.print("Enter if User is registered (true/false): ");
                        boolean isRegistered = scanner.nextBoolean();

                        User user = new User(userId, isRegistered);
                        userCRUD.createUser(user);
                        break;

                    case 2: // Update User
                        System.out.print("Enter User ID to update: ");
                        int updateUserId = scanner.nextInt();
                        System.out.print("Enter new registration status (true/false): ");
                        boolean newStatus = scanner.nextBoolean();

                        User updateUser = new User(updateUserId, newStatus);
                        userCRUD.updateUser(updateUser);
                        break;

                    case 3: // Delete User
                        System.out.print("Enter User ID to delete: ");
                        int deleteUserId = scanner.nextInt();
                        userCRUD.deleteUser(deleteUserId);
                        break;

                    case 4: // Exit
                        System.out.println("Exiting program.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                        break;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
