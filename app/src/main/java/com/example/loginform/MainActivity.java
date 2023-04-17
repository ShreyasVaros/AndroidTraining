package com.example.loginform;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {



    EditText et_username, et_password;
    Button BTN_button;
    boolean isAllfieldschecke = false;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME="myPref";
    private static final String KEY_USERNAME="et_username";
    private static final String KEY_PASSWORD="et_password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BTN_button = findViewById(R.id.BTN_button);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        BTN_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = et_username.getText().toString();
                String password = et_password.getText().toString();


                boolean check = validateinfo(username, password);

                if (check == true) {


                    String str = et_username.getText().toString();
                    Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                    intent.putExtra("Login", str);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Check your username and password once again", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    protected void onResume() {
        super.onResume();
        SharedPreferences sh = getSharedPreferences("MySharedPref",MODE_PRIVATE);



    }

    private boolean validateinfo(@NonNull String username, String password) {

        if (username.length() <= 2) {
            et_username.requestFocus();
            et_username.setError("Minimum 3 characters required ");
            return false;
        } else if (password.length() <= 7) {
            et_password.requestFocus();
            et_password.setError("MINIMUM 8 CHARACTERS REQUIRED");
            return false;
        } else {
            return true;
        }

    }

}
