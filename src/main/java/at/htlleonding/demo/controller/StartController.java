package at.htlleonding.demo.controller;

import at.htlleonding.demo.App;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class StartController {

    public Label labelRules;

    public void onBtnStartAction(ActionEvent actionEvent) {
        System.out.println("Start button clicked");
        try {
            App.switchToScene("game", "Sell Your Luck!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onBtnRulesAction(ActionEvent actionEvent) {
        labelRules.setVisible(!labelRules.isVisible());
    }

    public void onBtnHistoryAction(ActionEvent actionEvent) {
        try {
            App.switchToScene("history", "Sell Your Luck!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
