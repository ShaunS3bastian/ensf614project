package acmplex;


import java.sql.*;
import java.util.List;

public class MovieMain {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            MovieCRUD movieCRUD = new MovieCRUD(connection);

            // CREATE a new movie
            Movie newMovie = new Movie("AROMA", "DRAMA", 132, "PG-09", Date.valueOf("2010-09-19"));
            movieCRUD.createMovie(newMovie);

            // READ all movies
            List<Movie> movies = movieCRUD.getAllMovies();
            System.out.println("All Movies:");
            for (Movie movie : movies) {
                System.out.println(movie);
            }

            // UPDATE a movie
            Movie movieToUpdate = new Movie("HALOWEEN", "HORROR", 150, "PG-13", Date.valueOf("2022-07-16"));
            movieToUpdate.setMovieId(1); // Set the movie ID you want to update
            movieCRUD.updateMovie(movieToUpdate);

            // DELETE a movie
            movieCRUD.deleteMovie(1);

            // Get all movies after update and delete
            movies = movieCRUD.getAllMovies();
            System.out.println("Updated Movies:");
            for (Movie movie : movies) {
                System.out.println(movie);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
