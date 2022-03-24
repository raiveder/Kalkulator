package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner spinner;
    String[] str_array;

    TextView firstNumber;
    TextView action;
    TextView secondNumber;
    TextView equaly;
    TextView result;

    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button plus;
    Button minus;
    Button multiply;
    Button divide;
    Button clear;
    Button equals;
    Button transition;

    String act;
    boolean fnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.array_spinner);
        str_array = new String[]{"История","","","","","","","","","",""};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, str_array);
        spinner.setAdapter(adapter1);

        act = "";
        fnum = true;

        firstNumber = findViewById(R.id.firstNumber);
        action = findViewById(R.id.action);
        secondNumber = findViewById(R.id.secondNumber);
        equaly = findViewById(R.id.equaly);
        result = findViewById(R.id.result);

        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        clear = findViewById(R.id.clear);
        equals = findViewById(R.id.equals);
        transition = findViewById(R.id.transition);

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        clear.setOnClickListener(this);
        equals.setOnClickListener(this);
        transition.setOnClickListener((view -> {
            Intent intent = new Intent(MainActivity.this,MathPage.class);
            startActivity(intent);
        }));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zero:
            case R.id.one:
            case R.id.two:
            case R.id.three:
            case R.id.four:
            case R.id.five:
            case R.id.six:
            case R.id.seven:
            case R.id.eight:
            case R.id.nine:
                Button button = (Button) view;
                String numtext;
                if (fnum){
                    numtext = firstNumber.getText().toString();
                    numtext += button.getText().toString();
                    firstNumber.setText(numtext);
                }
                else{
                    numtext = secondNumber.getText().toString();
                    numtext += button.getText().toString();
                    secondNumber.setText(numtext);
                }
                break;
            case R.id.plus:
            case R.id.minus:
            case R.id.multiply:
            case R.id.divide:
                Button button1 = (Button) view;
                act = button1.getText().toString();
                action.setText(act);
                fnum = !fnum;
                break;
            case R.id.equals:
                if (!firstNumber.getText().toString().equals(""))
                {
                    if (!secondNumber.getText().toString().equals("")) {
                        float res = 0;
                        float num1 = Float.valueOf(firstNumber.getText().toString());
                        float num2 = Float.valueOf(secondNumber.getText().toString());
                        if (act.equals("*")) {
                            res = num1 * num2;
                        }
                        if (act.equals("/")) {
                            res = num1 / num2;
                        }
                        if (act.equals("+")) {
                            res = num1 + num2;
                        }
                        if (act.equals("-")) {
                            res = num1 - num2;
                        }
                        fnum = true;
                        equaly.setText("=");
                        result.setText(String.valueOf(res));

                        for (int i = 10; i>0;i--)
                        {
                            str_array[i] = str_array[i-1];
                        }
                        str_array[1] = String.valueOf(res);
                    }

                }
                break;
            case R.id.clear:
                firstNumber.setText("");
                action.setText("");
                secondNumber.setText("");
                equaly.setText("");
                result.setText("");
                fnum = true;
                break;
        }
    }
}