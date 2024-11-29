package acmplex;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class TheaterMain {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Create an instance of TheaterCRUD and pass the connection
            TheaterCRUD theaterCRUD = new TheaterCRUD(connection);
            Scanner scanner = new Scanner(System.in);

            // Test creating a new theater
            System.out.println("Enter Theater Name: ");
            String theaterName = scanner.nextLine();

            System.out.println("Enter Address ID: ");
            int addressID = scanner.nextInt();

            // Create Theater instance
            Theater newTheater = new Theater(theaterName, addressID);

            // Create the theater in the database
            theaterCRUD.createTheater(newTheater);

            // Print the created theater's ID
            System.out.println("Created Theater ID: " + newTheater.getTheaterID());

            // Test getting all theaters
            List<Theater> theaters = theaterCRUD.getAllTheaters();
            System.out.println("All Theaters:");
            for (Theater theater : theaters) {
                System.out.println(theater);
            }
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
