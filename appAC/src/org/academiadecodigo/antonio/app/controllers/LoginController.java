package org.academiadecodigo.antonio.app.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.academiadecodigo.antonio.app.Navigation;
import org.academiadecodigo.antonio.app.model.User;
import org.academiadecodigo.antonio.app.model.UserService;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private UserService userService;

    @FXML
    TextField loginField;

    @FXML
    PasswordField passwordField;

    @FXML
    Label passwordChecker;

    @FXML
    PasswordField passCheckField;

    @FXML
    TextField emailField;

    @FXML
    Label emailLabel;

    @FXML
    Button button;

    @FXML
    Hyperlink register;

    @FXML
    Label liveMessage;

    private boolean registerMenu;




    public  void buttonOnAction(){

       if(registerMenu){
           if(loginField.getText().length() >= 4 && emailField.getText().matches("\\w+@[aA-zZ]+[.][aA-zZ]{2,3}") && passwordField.getText().equals(passCheckField.getText())){

               userService.addUser(new User(loginField.getText(), passwordField.getText(), emailField.getText()));

               if(userService.findbyName(loginField.getText()) != null) {
                   liveMessage.setText("Account created");
               } else {
                   liveMessage.setText("Failed to create account");
               }


               System.out.println(userService.count());

               System.out.println("User: " + loginField.getText() + "Pass: " + passwordField.getText() + "Email: " + emailField.getText());

           } else {

              liveMessage.setText("Failed to create account");

           }
       } else {

           if(userService.authenticate(loginField.getText(), passwordField.getText())) {


               liveMessage.setText("Logged in");
               Navigation.getInstance().changeView("main");

           } else {
               liveMessage.setText("Login failed. Check your credentials");
           }

       }

    }

    public  void registerOnAction(){

        registerMenu = !registerMenu;
        liveMessage.setText("");

        if(registerMenu){

            passwordChecker.setVisible(true);
            passCheckField.setVisible(true);
            emailLabel.setVisible(true);
            emailField.setVisible(true);
            button.setText("Create account");
            register.setText("Sign in");

        } else {

            passwordChecker.setVisible(false);
            passCheckField.setVisible(false);
            emailLabel.setVisible(false);
            emailField.setVisible(false);
            button.setText("Log in");
            register.setText("Register");
        }
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        registerMenu = false;
        emailLabel.setVisible(false);
        emailField.setVisible(false);
        passCheckField.setVisible(false);
        passwordChecker.setVisible(false);


    }


}
