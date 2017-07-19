package com.uapps.sreelal.calculator;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    double display_num = 0.0, number1=0.0, number2 =0.0;
    boolean opClicked = false;
    boolean pointClicked = false;
    boolean signClicked = false;
    String operator;
    int numpointClick=0;
    double result=0.0;
    boolean equalClicked;

    public void buNumberEvent(View v) {

        EditText display = (EditText) findViewById(R.id.display);
        Button b = (Button) v;
        String s = b.getText().toString();
        double  num =0;

        if(opClicked) {
            display.setText("");
        }
        opClicked = false;

        try {

            if (s.equals("+/-") ) {
                signClicked = true;
                display_num = display_num * -1;
                display.setText(Double.toString(display_num));
                return;
            }
            if(s.equals(".")){
                pointClicked = true;
                return;
            }
            if(pointClicked){
                numpointClick++;
                num = Integer.parseInt(s);
                display_num = display_num + (num/Math.pow(10,numpointClick));
            }

            else {
               num =  Double.parseDouble(s);
                if(signClicked)
                    display_num = display_num *10 - num;
                else
                display_num = display_num * 10 + num;
            }
            display.setText(Double.toString(display_num));

        }
        catch (Exception e) {
            display.setText("Error Occured");
        }
    }

    public void opEvent(View v) {
        EditText display = (EditText) findViewById(R.id.display);
        Button b = (Button) v;
        operator = b.getText().toString();
        if(equalClicked)
            number2 = display_num;
        else
            number1 = display_num;
        display.setText(Double.toString(number1) + " " +  operator);
        pointClicked=false;
        display_num=0;
        opClicked=true;
        signClicked = false;
        numpointClick=0;
       // display.setText(Double.toString(number1) + operator + Double.toString(number2)+  " = " + Double.toString(result));

    }

    public void cleanEvent(View v){
        EditText display = (EditText) findViewById(R.id.display);
        display.setText("0");
        display_num=0;
        number1=0;
        number2=0;
        result=0;
        operator="";
        opClicked=false;
        pointClicked=false;
        numpointClick=0;
        signClicked=false;
        equalClicked=false;
    }

    public void equalEvent(View v) {
        equalClicked=true;
        number2 = display_num;
        EditText display = (EditText) findViewById(R.id.display);
        try {
            if (operator.equals("+"))
                result = number1 + number2;
            else if (operator.equals("-"))
                result = number1 - number2;
            else if (operator.equals("*"))
                result = number1 * number2;
            else if (operator.equals("/") && number2 != 0.0)
                result = number1 / number2;
            else if(number2 == 0) {
                display.setText("Cant Divide by 0");
                number1 = 0;
                display_num=0;
                return;
            }
            number1 = result;
            display.setText(Double.toString(result));
            display_num=0;
        }
        catch (Exception e) {
         display.setText("Enter Digits");
        }

    }

    public void percentEvent(View v) {
        EditText display = (EditText) findViewById(R.id.display);
        number1 = Double.parseDouble(display.getText().toString());
        result = number1 /100;
        display.setText(Double.toString(result));
        display_num = 0;
        number1 =0;
    }

}
