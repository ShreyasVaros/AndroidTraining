package com.example.sharedpreferance;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView username,password;
    Button bt_logout;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME="myPref";
    private static final String KEY_USERNAME="et_username";
    private static final String KEY_PASSWORD="et_password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        bt_logout=findViewById(R.id.bt_logout);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String user = sharedPreferences.getString(KEY_USERNAME,null);
        String pass = sharedPreferences.getString(KEY_PASSWORD,null);

        if (username !=null || pass !=null) {
            username.setText("username:--"+user);
            password.setText("password:--"+pass);
        }

        bt_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(SecondActivity.this,"Logout successfully",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}