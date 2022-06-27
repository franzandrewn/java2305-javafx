package com.andrewn.java2305javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController extends SwitchController {
    private static final String LOGIN = "ADMIN";
    private static final String PASSWORD = "Qweasd123";

    private IndexController nextController;

    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label errorLabel;

    public LoginController() {
    }

    public void login(ActionEvent actionEvent) {
        String login = loginField.getText();
        String password = passwordField.getText();
        if (login.equals(LOGIN) && password.equals(PASSWORD)) {
            loginField.setText("");
            passwordField.setText("");
            errorLabel.setText("");
            nextController.setWelcomeText(login);
            nextScene();
        } else {
            errorLabel.setText("Неверный логин/пароль");
        }
    }

    public void setNextController(IndexController nextController) {
        this.nextController = nextController;
    }
}
