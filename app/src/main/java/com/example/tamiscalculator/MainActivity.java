package com.example.tamiscalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView result;
    int num1 = 0;
    int num2 = 0;
    char c; // Operator

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        result = findViewById(R.id.mytextView);
        result.setText("");
    }

    public void press(View view) {
        // Append pressed number to the TextView
        Button button = (Button) view;
        String value = button.getText().toString();
        result.append(value);
    }

    public void funcEqual(View view) {
        // Perform calculation when "=" is pressed
        String[] operands = result.getText().toString().split("[+\\-*/%]");
        if (operands.length < 2) return;

        num1 = Integer.parseInt(operands[0]);
        num2 = Integer.parseInt(operands[1]);

        switch (c) {
            case '+':
                result.setText(String.valueOf(num1 + num2));
                break;
            case '-':
                result.setText(String.valueOf(num1 - num2));
                break;
            case '*':
                result.setText(String.valueOf(num1 * num2));
                break;
            case '/':
                if (num2 != 0) {
                    result.setText(String.valueOf(num1 / num2));
                } else {
                    result.setText(" dividing by zero moron");
                }
                break;
            case '%':
                result.setText(String.valueOf(num1 % num2));
                break;
        }
    }

    public void funcPlus(View view) {
        c = '+';
        result.append("+");
    }

   public void funcMinus(View view) {
        c = '-';
        result.append("-");
    }

    public void funcMultiply(View view) {
        c = '*';
        result.append("*");
    }

    public void funcDevide(View view) {
        c = '/';
        result.append("/");
    }

    public void funcRoot(View view) {
        double value = Double.parseDouble(result.getText().toString());
        result.setText(String.valueOf(Math.sqrt(value)));
    }

    public void funcSquare(View view) {
        double value = Double.parseDouble(result.getText().toString());
        result.setText(String.valueOf(value * value));
    }

    public void funDelete(View view) {
        String currentText = result.getText().toString();
        if (!currentText.isEmpty()) {
            result.setText(currentText.substring(0, currentText.length() - 1));
        }
    }

    public void funcMoudulu(View view) {
        c = '%';
        result.append("%");
    }

    public void funcClear(View view) {
        result.setText("");
        num1 = 0;
        num2 = 0;
        c = '\0';
    }
}
