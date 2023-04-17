package com.example.intentpassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReflectingData extends AppCompatActivity {

    TextView reciver_msg;
    TextView reciver_msg2;

    TextView mResultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflecting_data);

        reciver_msg=findViewById(R.id.textView3);
        reciver_msg2=findViewById(R.id.textView4);

        // Intent intent =  getIntent();
        // Intent iNext2 = getIntent();

         String str1 =getIntent().getStringExtra("FirstName");
         String str2 =getIntent().getStringExtra("LastName");
       //  String str2 =iNext2.getStringExtra("LastName");


         reciver_msg.setText(str1);
         reciver_msg2.setText(str2);

        
    }
}