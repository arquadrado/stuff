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
public class NextController implements Initializable {

    private UserService userService;

    @FXML
    Button logoutButton;

    @FXML
    Button goBackButton;


    public void logout(){
        Navigation.getInstance().changeView("login");

    }

    public void goBack(){
        Navigation.getInstance().back();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
