package com.example.intentpassing;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button send_button;
    EditText text1;
    EditText text2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send_button=findViewById(R.id.BTN_submit);
        text1=findViewById(R.id.ET_FirstName);
        text2=findViewById(R.id.ET_LastName);

        send_button.setOnClickListener(view -> {
            String str1=text1.getText().toString();
            String str2=text2.getText().toString();

            Intent intent=new Intent(MainActivity.this,ReflectingData.class);
        //    Intent iNext2= new Intent(getApplicationContext(),ReflectingData.class);

                     intent.putExtra("FirstName",str1);
                     intent.putExtra("LastName",str2);


            startActivity(intent);
          //  startActivity(iNext2);
        });


    }
}

