package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MathPage extends AppCompatActivity implements View.OnClickListener {
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
    Button sinus;
    Button cosinus;
    Button power;
    Button root;
    Button clear;
    Button equals;
    Button transition;

    String act;
    boolean fnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_page);

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
        sinus = findViewById(R.id.sinus);
        cosinus = findViewById(R.id.cosinus);
        power = findViewById(R.id.power);
        root = findViewById(R.id.root);
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
        sinus.setOnClickListener(this);
        cosinus.setOnClickListener(this);
        power.setOnClickListener(this);
        root.setOnClickListener(this);
        clear.setOnClickListener(this);
        equals.setOnClickListener(this);
        transition.setOnClickListener((view -> {
            Intent intent = new Intent(MathPage.this, MainActivity.class);
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
                if (fnum) {
                    numtext = firstNumber.getText().toString();
                    numtext += button.getText().toString();
                    firstNumber.setText(numtext);
                } else {
                    numtext = secondNumber.getText().toString();
                    numtext += button.getText().toString();
                    secondNumber.setText(numtext);
                }
                break;
            case R.id.power:
            case R.id.root:
                Button button1 = (Button) view;
                act = button1.getText().toString();
                action.setText(act);
                fnum = !fnum;
                break;
            case R.id.sinus:
            case R.id.cosinus:
                Button button2 = (Button) view;
                act = button2.getText().toString();
                firstNumber.setText(act);
                fnum = !fnum;
                break;
            case R.id.equals:
                if (!firstNumber.getText().toString().equals("")) {
                    if (!secondNumber.getText().toString().equals("")) {
                        double num2 = Double.valueOf(secondNumber.getText().toString());
                        double res = 0;
                        if (firstNumber.getText().toString().equals("sin")) {
                            res = Math.sin(num2);
                        } else if (firstNumber.getText().toString().equals("cos")) {
                            res = Math.cos(num2);
                        } else {
                            double num1 = Float.valueOf(firstNumber.getText().toString());
                            if (act.equals("^")) {
                                res = Math.pow(num1, num2);
                            }
                            if (act.equals("√")) {
                                res = Math.pow(num1, 1 / num2);
                            }
                        }
                        fnum = true;
                        equaly.setText("=");
                        result.setText(String.valueOf(res));
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