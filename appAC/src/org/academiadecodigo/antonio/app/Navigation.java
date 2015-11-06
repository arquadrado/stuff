package org.academiadecodigo.antonio.app;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

/**
 * Created by cadet on 03/11/15.
 */
public final class Navigation {

    private static Navigation instance = null;

    private Navigation() {
    }

    public static Navigation getInstance() {

        if(instance == null) {
            instance = new Navigation();
        }

        return instance;
    }

    private final int MIN_WIDTH = 1024; // window width
    private final int MIN_HEIGHT = 768; // window height
    private final String VIEW_PATH = "views";

    private LinkedList<AppScene> scenes = new LinkedList<>();
    private Map<String, Initializable> controllers = new HashMap<>();
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void changeView(String view) {

        ListIterator sceneIterator = scenes.listIterator();

        while(sceneIterator.hasNext()){

            AppScene currentScene = (AppScene) sceneIterator.next();

            if (currentScene.getName().equals(view)) {

                setScene(currentScene);
                sceneIterator.add(currentScene);
                return;

            }

        }

        loadView(view);


    }

    public void loadView(String view) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource( VIEW_PATH + "/" + view + ".fxml"));



            Parent root = fxmlLoader.load();


            System.out.println("bora");

            controllers.put(view, fxmlLoader.getController());

            AppScene scene = new AppScene(view, new Scene(root, MIN_WIDTH, MIN_HEIGHT));
            scenes.push(scene);

            setScene(scene);

        } catch (IOException e) {
            System.out.println("Failure to load view " + view + " : " + e.getMessage());
        }
    }

    public void back() {

        if (scenes.isEmpty()) {
            return;
        }

        // remove the current scene from the stack
        scenes.pop();

        // load the scene at the top of the stack
        setScene(scenes.peek());
    }

    public Initializable getController(String view){

        return controllers.get(view);
    }

    private void setScene(AppScene scene) {

        scene.getScene().getStylesheets().add("styles.css");
        // set the scene
        stage.setScene(scene.getScene());

        // show the stage to reload
        stage.show();
    }
}

