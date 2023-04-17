package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] months={"Jan","Feb","Mar","April","May","June","July",
    "Aug","Sep","Oct","Nov","Dec"};

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView LV_month=findViewById(R.id.LV_months);

    ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,months);


       ListView LV_months=findViewById(R.id.LV_months);
       LV_months.setAdapter(adapter);

       LV_month.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

               String text = "Selected item is "+((TextView)view).getText().toString();
               Toast.makeText(MainActivity.this,text,Toast.LENGTH_SHORT).show();

           }
       });
    }
}