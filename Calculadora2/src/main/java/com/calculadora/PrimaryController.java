package com.calculadora;

import java.io.IOException;
import static java.lang.constant.ConstantDescs.NULL;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class PrimaryController {

    @FXML
    private Button bt1;
    @FXML
    private Button bt2;
    @FXML
    private Button bt3;
    @FXML
    private Button bt4;
    @FXML
    private Button bt5;
    @FXML
    private Button bt6;
    @FXML
    private Button bt7;
    @FXML
    private Button bt8;
    @FXML
    private Button bt9;
    @FXML
    private Button btIgual;
    @FXML
    private Button btDiv;
    @FXML
    private Button btMult;
    @FXML
    private Button btSum;
    @FXML
    private Button btMinus;


    @FXML
    private TextField textIn;
    
    @FXML
    private TextField textOut;

    @FXML
    private Text tx_titulo;

    private float result = 0f;
    private float numOut = 0f;
    private float numIn = 0f;
    String ope = "";
    private ArrayList<String> numbers = new ArrayList<String>(9);
    


    
    @FXML
    private void btImput(ActionEvent event) throws IOException {

        Button curButton = (Button) event.getSource();
        
        numbers.add("bt1");
        numbers.add("bt2");
        numbers.add("bt3");
        numbers.add("bt4");
        numbers.add("bt5");
        numbers.add("bt6");
        numbers.add("bt7");
        numbers.add("bt8");
        numbers.add("bt9");
        
        boolean isNumber = numbers.contains(curButton.getId());
        if(isNumber){
            textIn.appendText(curButton.getText());
            numIn = Float.parseFloat(textIn.getText());
        }else{
            switch(curButton.getId()){
                    case "btDiv":   ope = "/" ;break;
                    case "btMult":  ope = "*" ;break;
                    case "btMinus": ope = "-" ;break;
                    case "btSum":   ope = "+" ;break;
            }
            if(textOut.getText().isBlank()){
                textOut.setText(textIn.getText());
                textIn.clear();
                numOut = Float.parseFloat(textOut.getText());
                textOut.appendText(ope);
            }else{
                textIn.clear();
                switch(ope){
                    case "/":  result = numOut / numIn; ope = "/";break;
                    case "*":  result = numOut * numIn; ope = "*";break;
                    case "-":  result = numOut - numIn; ope = "-";break;
                    case "+":  result = numOut + numIn; ope = "+";break;
                }
                System.out.println(numOut + ope + numIn);
                textOut.setText(String.valueOf(result));
                numOut = Float.parseFloat(textOut.getText());
                textOut.appendText(ope);
            }
            
            
        }
/*
        
        num2 = Float.parseFloat(textIn.getText());
        if(isNumber){
            
            if(textOut.getText().isBlank()){
                num1 = Float.parseFloat(textIn.getText());
                result = Float.parseFloat(textIn.getText());
            }else{
                num2 = Float.parseFloat(textIn.getText());
            }
        }else{
            textIn.clear();
            textOut.setText(String.valueOf(result));
            textOut.appendText(curButton.getText());
            switch(curButton.getId()){
                case "btDiv":   result =  num2 / num1 ;break;
                case "btMult":  result =  num2 * num1 ;break;
                case "btMinus": result =  num2 - num1 ;break;
                case "btSum":   result =  num2 + num1 ;break;
                case "btIgual": textOut.setText(String.valueOf(result)); break; 
            }

            num1 = result;
            
        }
*/
    }
}
