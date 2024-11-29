package acmplex;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsCRUD {
    private Connection connection;

    public NewsCRUD(Connection connection) {
        this.connection = connection;
    }

    

    // Create news
    public boolean createNews(News news) {
        String query = "INSERT INTO News (title, content, announcement_date, is_public) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, news.getTitle());
            preparedStatement.setString(2, news.getContent());
            preparedStatement.setDate(3, news.getAnnouncementDate());
            preparedStatement.setBoolean(4, news.isPublic());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get news by ID
    public News getNewsById(int newsId) {
        String query = "SELECT * FROM News WHERE news_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, newsId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                News news = new News(
                        resultSet.getString("title"),
                        resultSet.getString("content"),
                        resultSet.getDate("announcement_date"),
                        resultSet.getBoolean("is_public")
                );
                news.setNewsId(resultSet.getInt("news_id"));
                return news;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update news
    public boolean updateNews(int newsId, String title, String content, java.sql.Date announcementDate, boolean isPublic) {
        String query = "UPDATE News SET title = ?, content = ?, announcement_date = ?, is_public = ? WHERE news_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, content);
            preparedStatement.setDate(3, announcementDate);
            preparedStatement.setBoolean(4, isPublic);
            preparedStatement.setInt(5, newsId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete news
    public boolean deleteNews(int newsId) {
        String query = "DELETE FROM News WHERE news_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, newsId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all news
    public List<News> getAllNews() {
        List<News> newsList = new ArrayList<>();
        String query = "SELECT * FROM News";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                News news = new News(
                        resultSet.getString("title"),
                        resultSet.getString("content"),
                        resultSet.getDate("announcement_date"),
                        resultSet.getBoolean("is_public")
                );
                news.setNewsId(resultSet.getInt("news_id"));
                newsList.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newsList;
    }
}
