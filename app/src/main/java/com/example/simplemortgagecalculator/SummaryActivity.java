package com.example.simplemortgagecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class SummaryActivity extends AppCompatActivity {

    private TextView result;

    String mortgagePayment = getIntent().getStringExtra("Mortgage_Payment");

    //MainActivity main = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);


        //result = (TextView)findViewById(R.id.summaryResult);

        //result.setText("Your monthly mortgage payment is:" + new DecimalFormat("##.##").format(mortgagePayment));
    }
}
