package org.academiadecodigo.antonio.Calculator;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    private int rows = 0;
    private int operationCount = 0;
    private boolean operand = false;
    private boolean hasOperator = false;
    String firstValue = "";
    String secondValue = "";
    String operatorString = "";
    String preOperator = "";
    Brain brain = new Brain();

    @Override
    public void start(Stage primaryStage) throws Exception{


        GridPane grid = new GridPane();
        //grid.setAlignment(Pos.CENTER);

        Label display = new Label();
        display.setText("Display");
        display.setPrefHeight(50);
        display.setFont(Font.font("Century Gothic", FontWeight.NORMAL, 20));



        Button[] buttons = new Button[16];
        CalculatorButton[] buttonPressed = new CalculatorButton[]{

                newButton("7", Element.OPERAND), newButton("8", Element.OPERAND), newButton("9", Element.OPERAND), newButton("+", Element.OPERATOR),
                newButton("4", Element.OPERAND), newButton("5", Element.OPERAND), newButton("6", Element.OPERAND), newButton("-", Element.OPERATOR),
                newButton("1", Element.OPERAND), newButton("2", Element.OPERAND), newButton("3", Element.OPERAND), newButton("*", Element.OPERATOR),
                newButton("DEL", Element.CLEANER), newButton("0", Element.OPERAND), newButton("=", Element.OPERATOR), newButton("/", Element.OPERATOR),

        };




        for(int i = 0; i < buttons.length; i++){

            if(i % 4 == 0)rows++;

            buttons[i] = new Button();
            buttons[i].setPrefSize(50, 50);
            buttons[i].setText(buttonPressed[i].getButtonValue());
            final int finalI = i;
            buttons[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    switch (buttonPressed[finalI].getElementType()) {

                        case CLEANER:
                            display.setText("0");
                            firstValue = "";
                            secondValue = "";
                            hasOperator = false;
                            operatorString = "";
                            break;

                        case OPERAND:
                            if (hasOperator) {

                                secondValue += buttonPressed[finalI].getButtonValue();
                                display.setText(secondValue);

                            } else {
                                firstValue += buttonPressed[finalI].getButtonValue();
                                display.setText(firstValue);

                            }
                            break;

                        case OPERATOR:

                            if (hasOperator) {

                                if (firstValue.length() > 0 && secondValue.length() > 0) {

                                    display.setText(Integer.toString(brain.operation(firstValue, operatorString, secondValue)));

                                    firstValue = Integer.toString(brain.operation(firstValue, operatorString, secondValue));

                                    operatorString = buttonPressed[finalI].getButtonValue();


                                    secondValue = "";
                                } else {
                                    operatorString = buttonPressed[finalI].getButtonValue();
                                }

                                System.out.println("has operator");

                            } else {
                                if (firstValue.length() > 0) {


                                    operatorString = buttonPressed[finalI].getButtonValue();
                                    hasOperator = true;
                                    display.setText(operatorString);
                                    System.out.println("first operator");
                                } else {

                                    preOperator = buttonPressed[finalI].getButtonValue();

                                }
                            }
                            break;


                    }

                    System.out.println("first value: " + firstValue + " operator: " + operatorString + " second value: " + secondValue);


                }
            });
            grid.add(buttons[i], i % 4, rows);

        }





        grid.add(display, 0, 0, 4, 1);


        Scene scene = new Scene(grid);


        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public CalculatorButton newButton(String id, Element type){

        return new CalculatorButton(id, type);
    }




    public static void main(String[] args) {
        launch(args);
    }
}
