package com.example.simplemortgagecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView principal = (TextView)findViewById(R.id.etPrincipal);
        Button nextButton = (Button) findViewById(R.id.btNext);
        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                goToNext();
            }
        });
    }
   protected void goToNext(){
       Intent myIntent = new Intent(MainActivity.this, SummaryActivity.class);
       startActivity(myIntent);
   }
}
