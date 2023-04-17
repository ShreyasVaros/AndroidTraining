package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.awt.font.TextAttribute;

public class SecondActivity extends AppCompatActivity {

    TextView TV_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TV_message=findViewById(R.id.TV_message);
        Intent intent = getIntent();
        String str = intent.getStringExtra("Login");
        TV_message.setText("Welcome "+str+" to Skroman App");
    }
}