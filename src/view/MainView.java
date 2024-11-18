package view;

import javax.swing.*;

public class MainView {
    private JFrame frame;
    private JTabbedPane tabbedPane;

    public MainView() {
        frame = new JFrame("AcmePlex Ticket Reservation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        tabbedPane = new JTabbedPane();
        frame.add(tabbedPane);

        frame.setVisible(true);
    }

    public void addTab(String title, JPanel panel) {
        tabbedPane.addTab(title, panel);
    }
}
