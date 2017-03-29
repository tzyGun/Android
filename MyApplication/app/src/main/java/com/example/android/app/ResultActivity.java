package com.example.android.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity {

    TextView result1;
    TextView result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result1 = (TextView) findViewById(R.id.result1);
        result2 = (TextView) findViewById(R.id.result2);

        Bundle extra = getIntent().getExtras();

        String value1 = extra.get(MainActivity.RESULT).toString();
        String value2 = extra.get(MainActivity.RESULT2).toString();

        result1.setText(value1);
        result2.setText(value2);
    }
}
