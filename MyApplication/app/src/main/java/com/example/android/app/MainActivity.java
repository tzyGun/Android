package com.example.android.app;

import android.app.Activity;
import android.content.Intent;
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

    public final static String RESULT= "result";
    public final static String RESULT2= "result2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.android.app.R.layout.activity_main);

        convert = (Button) findViewById(com.example.android.app.R.id.convert);
        field = (EditText) findViewById(com.example.android.app.R.id.field);
        fahrenheit = (RadioButton) findViewById(com.example.android.app.R.id.radioFahrenheit);
        celsius = (RadioButton) findViewById(com.example.android.app.R.id.radioCelsius);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result = 0;
                if(fahrenheit.isChecked()) {
                    double tempVar = Double.parseDouble(field.getText().toString());
                     result = (tempVar-32)*5/9;
                    field.setText(String.format("%.2f",result));
                }else if (celsius.isChecked()) {
                    double tempVar = Double.parseDouble(field.getText().toString());
                   result = tempVar*9/5 + 32;
                    field.setText(String.format("%.2f",result));
                }else {

                }
                Intent toResultActivity = new Intent(getApplicationContext(), ResultActivity.class);
                toResultActivity.putExtra(RESULT, result);
                toResultActivity.putExtra(RESULT2,result-1);

                startActivity(toResultActivity);

            }
        });
    }
}
