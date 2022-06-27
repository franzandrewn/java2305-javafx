package com.andrewn.java2305javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class IndexController extends SwitchController {
    @FXML
    private Label welcomeLabel;

    public IndexController() {
    }

    public void logout(ActionEvent actionEvent) {
        nextScene();
    }

    public void setWelcomeText(String login) {
        welcomeLabel.setText("Привет, " + login);
    }
}
