package com.example.simplemortgagecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class SettingsActivity extends AppCompatActivity  {
//implements AdapterView.OnItemSelectedListener
    RadioGroup radioGroupCurrency;
    RadioButton radioButtonCurrency;

    RadioGroup radioGroupFrequency;
    RadioButton radioButtonFrequency;

    public static String currencyType ="Dollar" ;
    public static String frequencyType ="Monthly" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        radioGroupCurrency = findViewById(R.id.radioGroupCurrency);
        radioGroupFrequency = findViewById(R.id.radioGroupFrequency);

        Button apply = findViewById(R.id.btApply);
        apply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToMain();
            }
        });

    }

    public void checkCurrency(View v){
        int radioCurId = radioGroupCurrency.getCheckedRadioButtonId();
        radioButtonCurrency = findViewById(radioCurId);

        currencyType = radioButtonCurrency.getText().toString();

        Toast.makeText(this, currencyType + " currency selected.", Toast.LENGTH_SHORT).show();
    }

    public void checkFrequency(View v){
        int radioFreqId = radioGroupFrequency.getCheckedRadioButtonId();
        radioButtonFrequency = findViewById(radioFreqId);

        frequencyType = radioButtonFrequency.getText().toString();

        Toast.makeText(this, frequencyType + " payment frequency selected.", Toast.LENGTH_SHORT).show();

    }

    protected void goToMain(){
        Intent intentMain = new Intent(SettingsActivity.this, MainActivity.class);
        startActivity(intentMain);
    }

}
