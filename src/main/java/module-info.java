module at.htlleonding.demo {
    requires javafx.controls;
    requires javafx.fxml;

    opens at.htlleonding.demo to javafx.fxml;
    exports at.htlleonding.demo;
    exports at.htlleonding.demo.controller;
    opens at.htlleonding.demo.controller to javafx.fxml;
}
