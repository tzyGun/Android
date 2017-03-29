package com.example.sylwek.app;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity{

    TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        view = (TextView) findViewById(R.id.view);

        Bundle extras = getIntent().getExtras();

        String inputString = extras.getString("ResultText");

        view.setText(inputString);

    }
}
