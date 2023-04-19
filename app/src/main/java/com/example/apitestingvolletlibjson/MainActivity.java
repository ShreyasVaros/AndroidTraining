package com.example.apitestingvolletlibjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView TV_APICall=findViewById(R.id.TV_APICall);
        String url = "https://jsonplaceholder.typicode.com/todos/1";
     //   String url ="http://www.mocky.io/v2/597c41390f0000d002f4dbd1";
      //  String url = "https://jsonplaceholder.typicode.com/users";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                /*try {
                    int userID = response.getInt("userID");
                    int id = response.getInt("id");
                    String title = response.getString("title");
                    boolean completed = response.getBoolean("completed");*/

                     TV_APICall.setText(response.toString());
              //  TV_APICall.setText(userID+"\n"+id+"\n"+title+"\n"+completed);



               /* } catch (JSONException e) {
                    e.printStackTrace();

                }*/
            }



        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                TV_APICall.setText("ERROR ");
              //  Log.e(" ",error.toString());

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }
}