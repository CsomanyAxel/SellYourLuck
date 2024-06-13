package at.htlleonding.demo.controller;

import at.htlleonding.demo.database.DatabaseConnection;
import at.htlleonding.demo.database.DatabaseOperations;
import javafx.scene.control.ListView;

public class HistoryController {
    public ListView listViewHistory;

    public void initialize() {
        DatabaseOperations.getAllGames().forEach(game -> listViewHistory.getItems().add(0, game));
    }
}
