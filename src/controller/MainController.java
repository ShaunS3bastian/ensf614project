package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainController {
    private DatabaseManager dbManager;
    private MainView mainView;

    public MainController(DatabaseManager dbManager, MainView mainView) {
        this.dbManager = dbManager;
        this.mainView = mainView;

        setupViews();
    }

    private void setupViews() {
        // Search Movies Tab
        SearchMoviesPanel searchMoviesPanel = new SearchMoviesPanel();
        mainView.addTab("Search Movies", searchMoviesPanel);

        searchMoviesPanel.addSearchListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = searchMoviesPanel.getSearchQuery();
                if (query.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a movie title.");
                    return;
                }

                try {
                    ResultSet rs = dbManager.searchMovies(query);
                    StringBuilder results = new StringBuilder("Search Results:\n");
                    while (rs.next()) {
                        results.append(rs.getInt("id")).append(". ").append(rs.getString("title")).append("\n");
                    }
                    searchMoviesPanel.setSearchResults(results.toString());
                } catch (SQLException ex) {
                    searchMoviesPanel.setSearchResults("Error: " + ex.getMessage());
                }
            }
        });

        // Repeat similar logic for BookingPanel, RegisteredUserPanel, and CancellationPanel
    }
}
