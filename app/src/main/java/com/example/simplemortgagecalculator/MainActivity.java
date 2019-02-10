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
    TextView errorText;
    private EditText principal, interest, amort;
    public static double mortgagePayment;

    double entPrincipal, entInterest, entAmort, r, n;
    String currencyType , frequencyType;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Input Edittext :Principle, Interest, Amortization
        principal = (EditText)findViewById(R.id.editPrinciple);
        interest = (EditText)findViewById(R.id.editInterest);
        amort = (EditText)findViewById(R.id.editAmort);

        //Error Field
        errorText = (TextView)findViewById(R.id.mainError);

        avoidNullCurAndFreq();

        System.out.println("STARTUP"+currencyType);
        System.out.println("STARTUP"+frequencyType);



        //Calculate Button
        Button calculateButton = (Button) findViewById(R.id.btCalculate);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                try{
                    errorText.setText("");
                    boolean flag = validation();
                    calculateMortagePayment();
                    if (flag){
                        goToSummary();
                    }
                    System.out.println("NORMAL"+currencyType);
                    System.out.println("NORMAL"+frequencyType);
                }
                catch (NumberFormatException e){
                    errorText.setText("");
                    validation();
                }


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

    public void avoidNullCurAndFreq(){

        try{

            currencyType = SettingsActivity.currencyType;
            frequencyType = SettingsActivity.frequencyType;

            System.out.println("GOT NEW CURR"+currencyType);
            System.out.println("GOT NEW FREQ"+frequencyType);
        }
        catch(NullPointerException e){
            e.printStackTrace();

            currencyType = "Dollar";
            frequencyType = "Monthly";

            System.out.println("ERROR"+ currencyType);
            System.out.println("ERROR"+ frequencyType);
        }


    }

    public void calculateMortagePayment(){
        entPrincipal = Double.parseDouble(principal.getText().toString());
        entInterest = Double.parseDouble(interest.getText().toString());
        entAmort = Double.parseDouble(amort.getText().toString());

        // Frequency Type Conversion
        if(frequencyType.equals("Weekly")){
            r = (entInterest/100)/48;
            n = (48*entAmort);
        }
        else if(frequencyType.equals("Bi-Weekly")){
            r = (entInterest/100)/24;
            n = (24*entAmort);
        }
        else{
            r = (entInterest/100)/12;
            n = (12*entAmort);
        }

        //Currency Type conversion

        if(currencyType.equals("Euro")){
            entPrincipal = entPrincipal * 0.87; // USD TO EURO conversion rate as of 2/3/2019
        }
        else if (currencyType.equals("Pound")) {
            entPrincipal = entPrincipal * 0.76; // USD TO GBP conversion rate as of 2/3/2019
        }

        System.out.println("CALCULATING USING: "+currencyType);
        System.out.println("CALCULATING USING: "+frequencyType);

        mortgagePayment = entPrincipal * ((r*(Math.pow(1+r,n)))/((Math.pow(1+r,n)) -1));
    }

    public boolean validation(){

        String valiPrinciple = principal.getText().toString();
        String valiInterest = interest.getText().toString();
        String valiAmort = amort.getText().toString();

        //Validate Principle
        if(valiPrinciple.isEmpty() || valiPrinciple.length() == 0 || valiPrinciple.equals("") || valiPrinciple == null || valiPrinciple.equals("0")){
            errorText.setText("The principle field cannot be empty or zero.");
        }

        //Validate Interest
        else if(valiInterest.isEmpty() || valiInterest.length() == 0 || valiInterest.equals("") || valiInterest == null || valiInterest.equals("0")){
            errorText.setText("The interest field cannot be empty or zero.");
        }

        //Validate Amort
        else if(valiAmort.isEmpty() || valiAmort.length() == 0 || valiAmort.equals("") || valiAmort == null || valiAmort.equals("0")) {
            errorText.setText("The amortization field cannot be empty or zero.");
        }
        return (errorText.getText().equals(""));
    }



    protected void goToSummary(){
        Intent intentSummary = new Intent(MainActivity.this, SummaryActivity.class);
        //intentSummary.putExtra("Mortgage_Payment", mortgagePayment);
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
