package com.example.emailvalidator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etMail;
    Button bValidate;
   



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMail = findViewById(R.id.emailField);
        bValidate = findViewById(R.id.validateButton);

        bValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailValidator(etMail);
            }
        });
    }

    public void emailValidator(EditText etMail)
    {
        String emailToText = etMail.getText().toString();
        if (!emailToText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailToText).matches()) {

            Toast.makeText(this, "Email Verified !", Toast.LENGTH_SHORT).show();
        } else {
            etMail.requestFocus();
            etMail.setError("Enter valid email");

           // Toast.makeText(this, "Enter valid Email address !", Toast.LENGTH_SHORT).show();
        }
    }
}