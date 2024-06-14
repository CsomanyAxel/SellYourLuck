package at.htlleonding.demo.controller;

import at.htlleonding.demo.App;
import at.htlleonding.demo.database.DatabaseConnection;
import at.htlleonding.demo.database.DatabaseOperations;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;

public class HistoryController {
    public ListView listViewHistory;

    public void initialize() {
        DatabaseOperations.getAllGames().forEach(game -> listViewHistory.getItems().add(0, game));
    }

    public void onBackAction(ActionEvent actionEvent) {
        try {
            App.switchToScene("start", "Sell Your Luck!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
