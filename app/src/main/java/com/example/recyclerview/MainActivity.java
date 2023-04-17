package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerview);

        setMyData();


    }

    public void setMyData(){


        List<Item> items = new ArrayList<Item>();

        for(int i=0 ; i<9; i++) {

            items.add(new Item("Headphones"+i, "Rs 1450", R.drawable.a));
            

            Item model = new Item("SH","1290", R.drawable.a);
            items.add(model);


        }




        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));
    }
}



/*items.add(new Item("Headphones","Rs 1450",R.drawable.a));
        items.add(new Item("Charger","Rs 350",R.drawable.b));
        items.add(new Item("Mobile","Rs 12000",R.drawable.c));
        items.add(new Item("Wallet","Rs 500",R.drawable.d));

        items.add(new Item("Headphones","Rs 1450",R.drawable.a));
        items.add(new Item("Charger","Rs 350",R.drawable.b));
        items.add(new Item("Mobile","Rs 12000",R.drawable.c));
        items.add(new Item("Wallet","RS 500",R.drawable.d));*/