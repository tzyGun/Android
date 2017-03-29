package com.example.android.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView tv;
    EditText et, et2;
    Button b;
    CheckBox checkBox;

    float value = 0;
    float etNum1 = 0;
    float etNum2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init() {

        b = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.textView);
        et = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        checkBox= (CheckBox) findViewById(R.id.checkBox);

    }


    public void calculate(View v){

        if (checkBox.isChecked()){

            etNum1 = Math.round(Float.parseFloat(et.getText().toString()));
            etNum2= Math.round(Float.parseFloat(et2.getText().toString()));

            value = etNum1 + etNum2;

        }
        else{

            etNum1 = Float.parseFloat(et.getText().toString());
            etNum2 = Float.parseFloat(et2.getText().toString());

            value = etNum1 + etNum2;

        }
        String valueString = String.valueOf(value);
        tv.setText(valueString);
    }
}