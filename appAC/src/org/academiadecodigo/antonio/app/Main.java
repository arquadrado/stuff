package org.academiadecodigo.antonio.app;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.antonio.app.controllers.LoginController;
import org.academiadecodigo.antonio.app.model.JdbcUserService;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Navigation.getInstance().setStage(primaryStage);
        Navigation.getInstance().loadView("login");

        ((LoginController) Navigation.getInstance().getController("login")).setUserService(new JdbcUserService());


    }


    public static void main(String[] args) {
        launch(args);
    }
}
