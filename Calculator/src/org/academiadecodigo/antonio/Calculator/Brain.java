package org.academiadecodigo.antonio.Calculator;

/**
 * Created by cadet on 28/10/15.
 */
public class Brain {



    public Brain(){

    }

    public int operation(String operand, String operator, String secondOperand){
        int finalResult = 0;

        int op = Integer.parseInt(operand);
        int op2 = Integer.parseInt(secondOperand);

        switch (operator){

            case "*":
                finalResult = op * op2;
                break;

            case "/":
                finalResult = op / op2;
                break;
            case "+":
                finalResult = op + op2;
                break;
            case "-":
                finalResult = op - op2;
                break;

        }


        return finalResult;
    }
}
