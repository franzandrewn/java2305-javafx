package com.andrewn.java2305javafx;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
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
//        task456(stage);
        // Переключение между экранами
//        changeScenes(stage);
//        startWithoutThread(stage);
        startWithThread(stage);
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
//        scene.getStylesheets().add("test.css");
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    private void changeScenes(Stage stage) throws IOException {
        FXMLLoader fxmlLoginLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        FXMLLoader fxmlIndexLoader = new FXMLLoader(getClass().getResource("index.fxml"));

        Scene loginScene = new Scene(fxmlLoginLoader.load(), 400, 400);
        Scene indexScene = new Scene(fxmlIndexLoader.load(), 400, 400);

        LoginController loginController = fxmlLoginLoader.getController();
        IndexController indexController = fxmlIndexLoader.getController();
        loginController.setNextController(indexController);

        loginController.setNextScene(indexScene);
        loginController.setCurrentStage(stage);

        indexController.setNextScene(loginScene);
        indexController.setCurrentStage(stage);

        stage.setTitle("Switching scenes");
        stage.setScene(loginScene);
        stage.show();
    }

    private void startWithThread(Stage stage) {
        VBox root =  new VBox(5);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        ProgressBar progressBar = new ProgressBar(0.0);

        Label barProgress = new Label();
        Label powProgress = new Label();

        Button buttonProgress = new Button("Start progress bar");
        buttonProgress.setOnAction(event -> startProgressBar(progressBar, barProgress));

        Button buttonPow = new Button("Start 2.9^100 calculate");
        buttonPow.setOnAction(event -> startPow(powProgress));

        HBox temp = new HBox(5);
        temp.setAlignment(Pos.CENTER);
        temp.getChildren().addAll(
                new Label("Current step: "),
                barProgress
        );

        root.getChildren().addAll(
                progressBar,
                temp,
                buttonProgress,
                powProgress,
                buttonPow
        );

        stage.setWidth(300);
        stage.setHeight(300);
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void startProgressBar(ProgressBar progressBar, Label barProgress) {
        Task<Void> task = new Task<>() {
            @Override
            protected Void call() throws Exception {
                int steps = 1000;
                for (int i = 0; i < steps; i++) {
                    Thread.sleep(10);
                    updateProgress(i, steps);
                    updateMessage(String.valueOf(i));
                }
                return null;
            }
        };

        task.setOnFailed(workerStateEvent -> {
            workerStateEvent.getSource().getException().printStackTrace();
        });

        task.setOnSucceeded(workerStateEvent -> {
            System.out.println("Done!");
        });

        progressBar.progressProperty().bind(task.progressProperty());
        barProgress.textProperty().bind(task.messageProperty());

        new Thread(task).start();
    }

    private void startPow(Label powProgress) {
        Task<Void> task = new Task<>() {
            @Override
            protected Void call() throws Exception {
                int steps = 99;
                double initValue = 2.9;
                for (int i = 0; i < steps; i++) {
                    initValue *= 2.9;
                    Thread.sleep(100);
                    updateProgress(i, steps);
                    updateMessage(String.valueOf(initValue));
                }
                return null;
            }
        };

        task.setOnFailed(workerStateEvent -> {
            workerStateEvent.getSource().getException().printStackTrace();
        });

        task.setOnSucceeded(workerStateEvent -> {
            System.out.println("Pow done!");
        });

        powProgress.textProperty().bind(task.messageProperty());

        new Thread(task).start();
    }

    private void startWithoutThread(Stage stage) {
        VBox root =  new VBox(5);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        ProgressBar progressBar = new ProgressBar(0.0);

        Label barProgress = new Label();
        Label powProgress = new Label();

        Button buttonProgress = new Button("Start progress bar");
        buttonProgress.setOnAction(event -> startProgressBarAlt(progressBar, barProgress));

        Button buttonPow = new Button("Start 2.9^100 calculate");
        buttonPow.setOnAction(event -> startPowAlt(powProgress));

        HBox temp = new HBox(5);
        temp.setAlignment(Pos.CENTER);
        temp.getChildren().addAll(
                new Label("Current step: "),
                barProgress
        );

        root.getChildren().addAll(
                progressBar,
                temp,
                buttonProgress,
                powProgress,
                buttonPow
        );

        stage.setWidth(300);
        stage.setHeight(300);
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void startPowAlt(Label powProgress) {
        double initValue = 2.9;
        for (int i = 0; i < 99; i++) {
            initValue *= 2.9;
            powProgress.setText(String.valueOf(initValue));
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void startProgressBarAlt(ProgressBar progressBar, Label barProgress) {
        int steps = 1000;
        for (int i = 0; i < steps; i++) {
            progressBar.progressProperty().setValue((double) i / steps);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}