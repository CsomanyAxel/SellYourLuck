package at.htlleonding.demo.controller;

import at.htlleonding.demo.model.ChemStyle;
import at.htlleonding.demo.model.CoffeeCounter;
import at.htlleonding.demo.model.CoffeeType;
import at.htlleonding.demo.model.Cup;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class StartController {

    public void onBtnStartAction(ActionEvent actionEvent) {
        System.out.println("Start button clicked");

        try {
            // Load the FXML file coffee.fxml and set it as the scene
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/coffee.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Coffee Counter");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
