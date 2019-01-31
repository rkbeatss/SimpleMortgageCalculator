package com.example.simplemortgagecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        System.out.print("i made it");

        result = (TextView)findViewById(R.id.summaryResult);

        result.setText("Your monthly mortgage payment is: $" + new DecimalFormat("##.##").format(mortgagePayment));

    }

}
