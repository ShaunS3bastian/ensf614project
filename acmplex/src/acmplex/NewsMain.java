package acmplex;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class NewsMain {

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            NewsCRUD newsCRUD = new NewsCRUD(connection); // Fixed variable name
            Scanner scanner = new Scanner(System.in);

            // Menu loop
            while (true) {
                System.out.println("\n--- News CRUD Operations ---");
                System.out.println("1. Create News");
                System.out.println("2. View News");
                System.out.println("3. Update News");
                System.out.println("4. Delete News");
                System.out.println("5. Display All News");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:  // Create News
                        System.out.print("Enter Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Content: ");
                        String content = scanner.nextLine();
                        System.out.print("Enter Announcement Date (yyyy-MM-dd): ");
                        String announcementDateStr = scanner.nextLine();
                        Date announcementDate = Date.valueOf(announcementDateStr);
                        System.out.print("Is it public? (true/false): ");
                        boolean isPublic = scanner.nextBoolean();

                        News news = new News(title, content, announcementDate, isPublic);
                        if (newsCRUD.createNews(news)) {
                            System.out.println("News created successfully.");
                        } else {
                            System.out.println("Failed to create news.");
                        }
                        break;

                    case 2:  // View News
                        System.out.print("Enter News ID to view: ");
                        int viewNewsId = scanner.nextInt();
                        News viewNews = newsCRUD.getNewsById(viewNewsId);
                        if (viewNews != null) {
                            System.out.println("News Details: " + viewNews);
                        } else {
                            System.out.println("News not found.");
                        }
                        break;

                    case 3:  // Update News
                        System.out.print("Enter News ID to update: ");
                        int updateNewsId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter New Title: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("Enter New Content: ");
                        String newContent = scanner.nextLine();
                        System.out.print("Enter New Announcement Date (yyyy-MM-dd): ");
                        String newDateStr = scanner.nextLine();
                        Date newAnnouncementDate = Date.valueOf(newDateStr);
                        System.out.print("Is it public? (true/false): ");
                        boolean newIsPublic = scanner.nextBoolean();

                        if (newsCRUD.updateNews(updateNewsId, newTitle, newContent, newAnnouncementDate, newIsPublic)) {
                            System.out.println("News updated successfully.");
                        } else {
                            System.out.println("Failed to update news.");
                        }
                        break;

                    case 4:  // Delete News
                        System.out.print("Enter News ID to delete: ");
                        int deleteNewsId = scanner.nextInt();
                        if (newsCRUD.deleteNews(deleteNewsId)) {
                            System.out.println("News deleted successfully.");
                        } else {
                            System.out.println("News not found.");
                        }
                        break;

                    case 5:  // Display All News
                        List<News> allNews = newsCRUD.getAllNews();
                        if (allNews != null && !allNews.isEmpty()) {
                            for (News n : allNews) {
                                System.out.println(n);
                            }
                        } else {
                            System.out.println("No news available.");
                        }
                        break;

                    case 6:  // Exit
                        System.out.println("Exiting the application.");
                        return;  // Exit the loop and program

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
