package com.example.simplemortgagecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class SettingsActivity extends AppCompatActivity  {
//implements AdapterView.OnItemSelectedListener
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

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

}
