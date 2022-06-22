package com.andrewn.java2305javafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class FirstButtonActionHandler implements EventHandler<ActionEvent> {
    private final Label welcomeText;
    private final Button secondButton;

    public FirstButtonActionHandler(Label welcomeText, Button secondButton) {
        this.welcomeText=welcomeText;
        this.secondButton=secondButton;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println(getClass().getName());
        // Изменение текста текстового поля
        welcomeText.setText("Welcome to JavaFX Application!");
        // Изменение цвета текста второй кнопки
        secondButton.setTextFill(Color.RED);
    }
}
