package com.example.sylwek.app;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    public final static String PASSING_VALUE= "PASSING_VALUE";
    public final static String RETURNED_VALUE= "RETURNED_VALUE";
    public final static int REQUEST_CODE= 1;
    EditText first;
    EditText second;
    TextView addidtion;
    TextView multiplication;
    TextView subtraction;
    TextView division;
    Button callResultActivityButton;
    Button callChartActivity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first = (EditText) findViewById(R.id.first_input);
        second = (EditText) findViewById(R.id.second_input);

        callResultActivityButton = (Button) findViewById(R.id.startintent);
        callChartActivity = (Button) findViewById(R.id.chartActivity);

        addidtion = (TextView) findViewById(R.id.addidtion);
        multiplication = (TextView) findViewById(R.id.multiplication);
        division = (TextView) findViewById(R.id.division);
        subtraction = (TextView) findViewById(R.id.subtraction);




    }
    public void onClick(View view) {

        if(first.getText().length()> 0 && second.getText().length() > 0) {
            String stringToPass= first.getText()
                    .toString()
                    .concat(",")
                    .concat(second.getText().toString());
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra(PASSING_VALUE, stringToPass);
            startActivityForResult(intent, REQUEST_CODE);
        } else {
            Toast.makeText(this, "Fill empty fields", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {

            if (data.hasExtra(RETURNED_VALUE)) {
                String result = data.getExtras().getString(RETURNED_VALUE).toString();

                String returnedValues [] = result.split(",");
                if (result != null && result.length() > 0) {
                    Toast.makeText(getApplicationContext(), "Results calculated in previous activity", Toast.LENGTH_LONG).show();
                }

                addidtion.setText("Addidtion: "+ returnedValues[0]);
                subtraction.setText("Subtraction: "+ returnedValues[1]);
                multiplication.setText("Multiplication: "+ returnedValues[2]);
                division.setText("Division: "+ returnedValues[3]);




            }

        }
    }

    public void onClickChartButton ( View v){
        Intent intent = new Intent(this, ChartActivity.class);

        startActivity(intent);

    }
}