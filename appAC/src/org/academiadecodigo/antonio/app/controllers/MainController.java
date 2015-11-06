package org.academiadecodigo.antonio.app.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.academiadecodigo.antonio.app.Navigation;
import org.academiadecodigo.antonio.app.model.UserService;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by cadet on 03/11/15.
 */
public class MainController implements Initializable {

    private UserService userService;

    @FXML
    Button backButton;

    @FXML
    Button goNextWindowButton;

    public void goNextWindow(){

        Navigation.getInstance().changeView("next");
    }


    public void goBack(){


        Navigation.getInstance().back();
    }

    public void goToLogin(){

        Navigation.getInstance().changeView("login");
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
