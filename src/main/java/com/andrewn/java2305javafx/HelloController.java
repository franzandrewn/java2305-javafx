package com.andrewn.java2305javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button firstButton;
    @FXML
    private Button secondButton;

    @FXML
    protected void onHelloButtonClick() {
        // Изменение текста текстового поля
        welcomeText.setText("Welcome to JavaFX Application!");
        // Изменение цвета текста второй кнопки
        secondButton.setTextFill(Color.RED);
    }

    @FXML
    protected void onByeButtonClick() {
        // Изменение текста текстового поля
        welcomeText.setText("Пока, это конец");
        // Изменение текста первой кнопки
        String oldText = firstButton.getText();
        firstButton.setText(oldText + "!");
    }

    // task1
//    Отредактировать hello-view.fxml: добавить ещё одну кнопку,
//    которая будет влиять на текстовое поле welcomeText,
//    проставляя туда строку "Пока, это конец"
//    Важно проставить onAction параметр, который будет ссылаться на новый метод внутри HelloController
    // task2
//     Нажатие второй кнопки должно в дополнение к изменению текста в текстовом поле
//     должно поменять текст внутри первой кнопки
    // task3
//    Нажатие на первую кнопку должно менять цвет шрифта второй
}