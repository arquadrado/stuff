package org.academiadecodigo.antonio.Calculator;

/**
 * Created by cadet on 28/10/15.
 */
public class CalculatorButton {

    private String buttonValue;
    private Element elementType;


    public CalculatorButton(String buttonValue, Element element){
        this.buttonValue = buttonValue;
        this.elementType = element;


    }

    public String getButtonValue() {
        return buttonValue;
    }

    public void setButtonValue(String buttonValue) {
        this.buttonValue = buttonValue;
    }

    public Element getElementType() {
        return elementType;
    }

    public void setElementType(Element elementType) {
        this.elementType = elementType;
    }
}
