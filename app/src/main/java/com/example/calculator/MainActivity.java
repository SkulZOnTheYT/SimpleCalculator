package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView resultTextView;
    private double firstNumber = 0;
    private String operator = "";
    private boolean isOperatorClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
    }

    public void onDigitClick(View view) {
        Button button = (Button) view;
        String digit = button.getText().toString();
        String currentText = resultTextView.getText().toString();

        if (currentText.equals("0") || isOperatorClicked) {
            resultTextView.setText(digit);
            isOperatorClicked = false;
        } else {
            resultTextView.setText(currentText + digit);
        }
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        String newOperator = button.getText().toString();

        if (!operator.isEmpty()) {
            return;
        }

        firstNumber = Double.parseDouble(resultTextView.getText().toString());
        operator = newOperator;
        isOperatorClicked = true;
    }

    public void onEqualsClick(View view) {
        if (operator.isEmpty()) {
            return;
        }

        double secondNumber = Double.parseDouble(resultTextView.getText().toString());
        double result = 0;

        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                }
                break;
        }

        resultTextView.setText(String.valueOf(result));
        operator = "";
    }

    public void onClearClick(View view) {
        resultTextView.setText("0");
        firstNumber = 0;
        operator = "";
    }
}
