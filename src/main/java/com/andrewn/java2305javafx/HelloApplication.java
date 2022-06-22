package com.andrewn.java2305javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // "Привет мир" + 3 задания из HelloController
//        helloView(stage);
        // Создание интерфейса напрямую с помощью создания объектов
//        manualCreation(stage);
        task456(stage);
    }

    private void manualCreation(Stage stage) {
        // Создание и настройка контейнера
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20.0);
        root.setPadding(new Insets(20.0));
        // Создание и настройка элементов интерфейса
        Label welcomeText = new Label();

        Button firstButton = new Button();
        firstButton.setText("Hello!");
        firstButton.setTextFill(Color.BLUE);

        Button secondButton = new Button();
        secondButton.setText("Bye!");

        // Наследование
        firstButton.setOnAction(new FirstButtonActionHandler(welcomeText, secondButton));

        // Анонимный класс
        secondButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(getClass().getName());
                // Изменение текста текстового поля
                welcomeText.setText("Пока, это конец");
                // Изменение текста первой кнопки
                String oldText = firstButton.getText();
                firstButton.setText(oldText + "!");
            }
        });

        // Лямбда-выражение
        welcomeText.setOnMouseClicked(mouseEvent -> {
            System.out.println(getClass().getName());
            firstButton.setTextFill(Color.BLACK);
            secondButton.setTextFill(Color.BLACK);
        });

        welcomeText.setOnMouseEntered(mouseEvent -> {
            welcomeText.setTextFill(
                    new Color(Math.random(),Math.random(),Math.random(), 1));
        });

        welcomeText.setOnMouseExited(mouseEvent -> {
            welcomeText.setTextFill(Color.BLACK);
        });
        // Добавление элементов в контейнер
        root.getChildren().addAll(welcomeText, firstButton, secondButton);
        // Добавление всей иерархии интерфейса в сцену
        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    private void task456(Stage stage) {
        // task4
//         Создать объект Pane с именем root
//         Создать два объекта класса Label с текстами "label1" и "label2"
//         Поместить их как потомков внутрь AnchorPane
//         С помощью методов setLayoutX и setLayoutY поместить лейблы в правый верхний и левый нижний угол
        // task5
//        Привязать к label1 нажатие клавиши мыши, которое должно менять текст label2:
//        добавить ещё одну "2" в конец
        // task6*
//        Привязать к label2 MouseEntered событие,
//        которое устанавливает координаты label2 на случайные в диапазоне от 0 до 350
//        Получить случайное число от 0 до 350: Math.random()*351
        Pane root = new Pane();
        // код создания и размещения Label
        Label label1 = new Label("label1");
        Label label2 = new Label("label2");
        label1.setLayoutX(200);
        label2.setLayoutY(350);

        root.getChildren().addAll(label1, label2);

        label1.setOnMouseClicked(mouseEvent -> {
            String oldText = label2.getText();
            label2.setText(oldText + "2");
        });

        label2.setOnMouseEntered(mouseEvent -> {
            double newX = Math.random()*351;
            double newY = Math.random()*351;

            label2.setLayoutX(newX);
            label2.setLayoutY(newY);
            label1.setText(String.format("%5.2f %5.2f", newX, newY));
        });

        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    private void helloView(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
//        scene.getStylesheets().add("test.css");
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}