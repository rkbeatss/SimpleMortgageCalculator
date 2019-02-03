package com.example.simplemortgagecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class SummaryActivity extends AppCompatActivity {

    private TextView result;


    //MainActivity main = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Bundle extras = getIntent().getExtras();
        double mortgagePayment = extras.getDouble("Mortgage_Payment");

        result = (TextView)findViewById(R.id.summaryResult);

        result.setText("Your monthly mortgage payment is: $" + new DecimalFormat("##.##").format(mortgagePayment));

        Button btReturn = (Button) findViewById(R.id.btReturnToMain);
        btReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                returnToMain();
            }
        });
    }
    protected void returnToMain(){
        Intent intentMain = new Intent(SummaryActivity.this, MainActivity.class);
        startActivity(intentMain);
    }
}
