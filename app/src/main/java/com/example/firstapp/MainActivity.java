package com.example.firstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputname;
    private TextView textViewName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputname = findViewById(R.id.inputname);
        textViewName=findViewById(R.id.textViewName);

        Button b1 = findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                String NameStored=inputname.getText().toString();

                textViewName.setText("Welcome "+NameStored+" to Skroman App");
                Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_LONG).show();
            }
        });


    }
}