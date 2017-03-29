package com.example.android.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class MainActivity extends Activity{

    EditText a, b, c;
    TextView sol1,sol2;
    Button calculate;

    double numA, numB, numC , x1, x2, delta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numA = Double.parseDouble(a.getText().toString());
                numB = Double.parseDouble(b.getText().toString());
                numC = Double.parseDouble(c.getText().toString());

                delta = pow(numB,2) - 4*numC*numA;

                if(delta == 0){
                    x1 = -numB / (2*numA);
                    sol1.setText("x = " + String.valueOf(x1));
                    sol2.setText("");
                }else if(delta<0){

                    sol1.setText("Delta <0");
                    sol2.setText("");
                }
                else{
                    x1 = (-numB - sqrt(delta) )/ (2*numA);
                    x2 = (-numB + sqrt(delta) )/ (2*numA);

                    sol1.setText("x1 = " + String.valueOf(x1));
                    sol2.setText("x2 = " + String.valueOf(x2));
                }

            }
        });

    }

    void init(){

        a = (EditText) findViewById(R.id.editText);
        b = (EditText) findViewById(R.id.editText2);
        c = (EditText) findViewById(R.id.editText3);

        sol1 = (TextView) findViewById(R.id.textView);
        sol2 = (TextView) findViewById(R.id.textView2);
        calculate = (Button) findViewById(R.id.button);

    };

}
