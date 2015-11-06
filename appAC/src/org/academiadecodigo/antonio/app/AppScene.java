package org.academiadecodigo.antonio.app;

import javafx.scene.Scene;

/**
 * Created by cadet on 03/11/15.
 */
public class AppScene {

    private Scene scene;
    private String name;

    public AppScene(String name, Scene scene){
        this.name = name;
        this.scene = scene;

    }

    public String getName() {
        return name;
    }

    public Scene getScene() {
        return scene;
    }
}
