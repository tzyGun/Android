package com.example.sylwek.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button calculate;

    TextView home;
    TextView resultText;
    TextView result;

    RadioButton additionRadio;
    RadioButton multiplicationRadio;
    RadioButton substractionRadio;
    RadioButton divisionRadio;

    EditText firstNumber;
    EditText secondNumber;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.calculate = (Button) findViewById(R.id.button);

        this.home = (TextView) findViewById(R.id.home);
        this.resultText = (TextView) findViewById(R.id.resultVar);
        this.result = (TextView) findViewById(R.id.result);

        this.additionRadio = (RadioButton) findViewById(R.id.addition);
        this.multiplicationRadio = (RadioButton) findViewById(R.id.multiplication);
        this.divisionRadio = (RadioButton) findViewById(R.id.division);
        this.substractionRadio = (RadioButton) findViewById(R.id.substraction);

        this.firstNumber = (EditText) findViewById(R.id.firstNumber);
        this.secondNumber = (EditText) findViewById(R.id.secondNumber);





        this.calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    float a = Float.parseFloat(firstNumber.getText().toString());
                    float b = Float.parseFloat(secondNumber.getText().toString());


                    if(additionRadio.isChecked()){
                        resultText.setText(additionRadio.getText().toString() + ": " +
                                new Addition().calculate(a,b) );
                    }

                    if(substractionRadio.isChecked()){
                    resultText.setText(substractionRadio.getText().toString() + ": " +
                            new Substraction().calculate(a,b) );
                    }

                    if(divisionRadio.isChecked()){
                    resultText.setText(divisionRadio.getText().toString() + ": " +
                            new Division().calculate(a,b) );
                    }

                    if(multiplicationRadio.isChecked()){
                    resultText.setText(multiplicationRadio.getText().toString() + ": " +
                            new Multiplication().calculate(a,b) );
                }
            }
        });
    }
}
