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
 int num1=0;
 int num2=0;
 char c;
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
        TextView result=findViewById(R.id.mytextView);
        result.setText("");


//view describes who called function,casting to our button
//        index 0 and that way reads all string

    }

    public void press(View view) {

        Button button = (Button) view; //value of view=the button that has been pressed
        result.append(button.getText().toString());//3,5->35







    }

    public void funcEqual(View view) {
    }

    public void funcPlus(View view) {
    }

    public void funcMinus(View view) {
    }

    public void funcMultiply(View view) {
    }

    public void funcDevide(View view) {
    }

    public void funcRoot(View view) {
    }

    public void funcSquare(View view) {
    }

    public void funDelete(View view) {
    }

    public void funcMoudulu(View view) {
    }
}