package com.example.sharedpreferance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    EditText et_username, et_password;
    Button BTN_button;
    boolean isAllFieldsCheck = false;
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

        String username = sharedPreferences.getString(KEY_USERNAME,null);
        if (username != null) {
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }

        BTN_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String username = et_username.getText().toString();
                String password = et_password.getText().toString();


                boolean check = validateInfo(username, password);

                if (check == true) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_USERNAME,et_username.getText().toString());
                    editor.putString(KEY_PASSWORD,et_password.getText().toString());
                    editor.apply();
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Username and password verified!", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), "Check your username and password once again", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    private boolean validateInfo(@NonNull String username, String password) {

        if (username.length() <= 2) {
            et_username.requestFocus();
            et_username.setError("Minimum 3 characters required ");
            return false;
        } else if (password.length() <=7) {
            et_password.requestFocus();
            et_password.setError("MINIMUM 8 CHARACTERS REQUIRED");
            return false;
        } else {
            return true;
        }

    }

}