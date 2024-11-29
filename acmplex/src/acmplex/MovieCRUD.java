package acmplex;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MovieCRUD {
    private Connection connection;

    public MovieCRUD(Connection connection) {
        this.connection = connection;
    }

    // CREATE a new movie
    public void createMovie(Movie movie) throws SQLException {
        String query = "INSERT INTO Movies (title, genre, duration, rating, release_date) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, movie.getTitle());
            statement.setString(2, movie.getGenre());
            statement.setInt(3, movie.getDuration());
            statement.setString(4, movie.getRating());
            statement.setDate(5, movie.getReleaseDate());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    movie.setMovieId(generatedKeys.getInt(1)); // Get auto-generated movieId
                    System.out.println("Movie created with ID: " + movie.getMovieId());
                }
            }
        }
    }

    // READ all movies
    public List<Movie> getAllMovies() throws SQLException {
        List<Movie> movies = new ArrayList<>();
        String query = "SELECT * FROM Movies";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getString("title"),
                        resultSet.getString("genre"),
                        resultSet.getInt("duration"),
                        resultSet.getString("rating"),
                        resultSet.getDate("release_date")
                );
                movie.setMovieId(resultSet.getInt("movie_id")); // Set movieId after fetching it from DB
                movies.add(movie);
            }
        }
        return movies;
    }

    // UPDATE a movie
    public void updateMovie(Movie movie) throws SQLException {
        String query = "UPDATE Movies SET title = ?, genre = ?, duration = ?, rating = ?, release_date = ? WHERE movie_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, movie.getTitle());
            statement.setString(2, movie.getGenre());
            statement.setInt(3, movie.getDuration());
            statement.setString(4, movie.getRating());
            statement.setDate(5, movie.getReleaseDate());
            statement.setInt(6, movie.getMovieId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Movie updated with ID: " + movie.getMovieId());
            }
        }
    }

    // DELETE a movie
    public void deleteMovie(int movieId) throws SQLException {
        String query = "DELETE FROM Movies WHERE movie_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, movieId);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Movie deleted with ID: " + movieId);
            }
        }
    }
}
