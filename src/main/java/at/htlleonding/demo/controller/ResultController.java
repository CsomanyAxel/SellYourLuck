package at.htlleonding.demo.controller;

import at.htlleonding.demo.App;
import javafx.event.ActionEvent;

public class ResultController {
    public void onBackAction(ActionEvent actionEvent) {
        try {
            App.switchToScene("start", "Sell Your Luck!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
