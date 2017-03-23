package com.example.sylwek.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Float2;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/*
 Just for tests GraphView library  http://www.android-graphview.org/
 */
public class ResultActivity extends Activity {

    TextView first;
    TextView second;

    String toPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        this.toPass=null;

        first = (TextView) findViewById(R.id.first_var);
        second = (TextView) findViewById(R.id.second_var);



        Bundle extraMessage = getIntent().getExtras();

        String message = extraMessage.getString(MainActivity.PASSING_VALUE);

        String values [] = message.split(",");

        float a = Float.parseFloat(values[0]);
        float b = Float.parseFloat(values[1]);
        first.setText(Float.toString(a));
        second.setText(Float.toString(b));
        this.toPass=calculate(a,b);



        Toast.makeText(this,message , Toast.LENGTH_SHORT).show();
    }

    public void  finish(){
        Intent intent = new Intent();

        intent.putExtra(MainActivity.RETURNED_VALUE, this.toPass );

        setResult(RESULT_OK,intent);
        super.finish();

    }

    private String calculate(float a , float b) {
        String result = null;
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    result = Float.toString(a + b).concat(",");
                    break;
                case 1:
                    result += Float.toString(a - b).concat(",");
                    break;
                case 2:
                    result += Float.toString(a * b).concat(",");
                    break;
                case 3:
                    if (b != 0) {
                        result += Float.toString(a / b);
                    } else {
                        result+= result.concat("0");
                    }
                    break;

            }

        }
        return result;
    }

}
