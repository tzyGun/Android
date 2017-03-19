package com.example.sylwek.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends Activity {

    Button convert;

    EditText field;

    RadioButton fahrenheit;

    RadioButton celsius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convert = (Button) findViewById(R.id.convert);
        field = (EditText) findViewById(R.id.field);
        fahrenheit = (RadioButton) findViewById(R.id.radioFahrenheit);
        celsius = (RadioButton) findViewById(R.id.radioCelsius);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fahrenheit.isChecked()) {
                    double tempVar = Double.parseDouble(field.getText().toString());
                    double result = (tempVar-32)*5/9;
                    field.setText(String.format("%.2f",result));
                }else if (celsius.isChecked()) {
                    double tempVar = Double.parseDouble(field.getText().toString());
                    double result = tempVar*9/5 + 32;
                    field.setText(String.format("%.2f",result));
                }else {

                }
            }
        });
    }
}
