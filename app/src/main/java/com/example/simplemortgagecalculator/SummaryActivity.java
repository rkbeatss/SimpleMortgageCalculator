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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        double mortgagePayment = MainActivity.mortgagePayment;
        result = (TextView)findViewById(R.id.summaryResult);

        textAppender();
        result.append(new DecimalFormat("##.##").format(mortgagePayment));

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

    public void textAppender(){
        if(SettingsActivity.frequencyType.equals("Weekly")){
            result.append("Your weekly mortgage payment is: ");
        }
        else if(SettingsActivity.frequencyType.equals("Bi-Weekly")){
            result.append("Your bi-weekly mortgage payment is: ");
        }
        else{
            result.append("Your monthly mortgage payment is: ");
        }

        if(SettingsActivity.currencyType.equals("Euro")){
            result.append("€");
        }
        else if(SettingsActivity.currencyType.equals("Pound")){
            result.append("£");
        }
        else{
            result.append("$");
        }

    }
}
