package com.andrewn.java2305javafx;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public abstract class SwitchController {
    private Stage currentStage;
    private Scene nextScene;

    private final Map<String, Scene> scenes;

    public SwitchController() {
        scenes = new HashMap<>();
    }

    public void setNextScene(Scene nextScene) {
        this.nextScene = nextScene;
        scenes.put("index", nextScene);
    }

    public void setCurrentStage(Stage currentStage) {
        this.currentStage = currentStage;
    }

    public void nextScene() {
        currentStage.setScene(nextScene);
    }

    public void switchToScene(String sceneName) {
        currentStage.setScene(scenes.get(sceneName));
    }
}
