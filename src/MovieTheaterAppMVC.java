public class MovieTheaterAppMVC {
    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();
        MainView mainView = new MainView();
        new MainController(dbManager, mainView);
    }
}