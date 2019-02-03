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

    String currencyType;
    String frequencyType;


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
                //System.out.println(currencyType);
                //System.out.println(frequencyType);
                goToMain();
            }
        });

//        //Currency Spinner
//        Spinner currency = findViewById(R.id.settingsCurSpinner);
//        ArrayAdapter<CharSequence> adapterCur = ArrayAdapter.createFromResource(this,R.array.currency, android.R.layout.simple_spinner_item);
//        adapterCur.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        currency.setAdapter(adapterCur);
//        currency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                String text = adapterView.getItemAtPosition(i).toString();
//                Toast.makeText(adapterView.getContext(),text, Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//        //Pay Frequency Spinner
//        Spinner frequency = findViewById(R.id.settingsFreqSpinner);
//        ArrayAdapter<CharSequence> adapterFreq = ArrayAdapter.createFromResource(this,R.array.frequency, android.R.layout.simple_spinner_item);
//        adapterFreq.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        frequency.setAdapter(adapterFreq);
//        frequency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                String text = adapterView.getItemAtPosition(i).toString();
//                Toast.makeText(adapterView.getContext(),text, Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

    }

    public void checkCurrency(View v){
        int radioCurId = radioGroupCurrency.getCheckedRadioButtonId();
        radioButtonCurrency = findViewById(radioCurId);

       // currencyType =

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

        Bundle bundle = new Bundle();

        bundle.putString("currencyType", currencyType);
        bundle.putString("frequencyType",frequencyType);

        intentMain.putExtras(bundle);

        //intentMain.putExtra("currencyType", currencyType);
        //intentMain.putExtra("frequencyType",frequencyType);
        startActivity(intentMain);
    }

}
