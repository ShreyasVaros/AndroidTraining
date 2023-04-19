package com.example.apitestingvolleylibstring;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    RequestQueue queue;
    TextView TV_String;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TV_String = findViewById(R.id.TV_String);

        String url = "https://jsonplaceholder.typicode.com/users";
       // String url = "https://jsonplaceholder.typicode.com/todos/1";
       // String url = "http://www.mocky.io/v2/597c41390f0000d002f4dbd1";
        queue = Volley.newRequestQueue(this);       
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            TV_String.setText(response.toString());

            }
        },new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
            TV_String.setText("Error");
                //Log.d("error",error.toString());
            }
        });
        queue.add(stringRequest);
    }
}