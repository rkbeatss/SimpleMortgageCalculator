package com.example.simplemortgagecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import org.w3c.dom.Text;



public class MainActivity extends AppCompatActivity {

    private EditText principal, interest, amort;
    double mortgagePayment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Input Edittext :Principle, Interest, Amortization
        principal = (EditText)findViewById(R.id.editPrinciple);
        interest = (EditText)findViewById(R.id.editInterest);
        amort = (EditText)findViewById(R.id.editAmort);

        //Calculate Button
        Button calculateButton = (Button) findViewById(R.id.btCalculate);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                calculateMortagePayment();
                goToSummary();

            }
        });

        //Settings Button
        Button settingsButton = (Button) findViewById(R.id.btSettings);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                goToSettings();

            }
        });

        //Help Button
        Button helpButton = (Button) findViewById(R.id.btHelp);
        helpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                goToHelp();

            }
        });

    }

    public void calculateMortagePayment(){
        double entPrincipal = Integer.parseInt(principal.getText().toString());
        double entInterest = Integer.parseInt(interest.getText().toString());
        double entAmort = Integer.parseInt(amort.getText().toString());

        double r = (entInterest/100)/12;
        double n = (12*entAmort);

        mortgagePayment = entPrincipal * ((r*(Math.pow(1+r,n)))/((Math.pow(1+r,n)) -1));
    }


    protected void goToSummary(){
        Intent intentSummary = new Intent(MainActivity.this, SummaryActivity.class);
        intentSummary.putExtra("Mortgage_Payment", mortgagePayment);
        startActivity(intentSummary);
    }

    protected void goToSettings(){
        Intent intentSettings = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intentSettings);
    }

    protected void goToHelp(){
        Intent intentHelp = new Intent(MainActivity.this, HelpActivity.class);
        startActivity(intentHelp);
    }
}
