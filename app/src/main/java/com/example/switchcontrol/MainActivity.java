package com.example.switchcontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import java.security.cert.Extension;


public class MainActivity extends AppCompatActivity
{

  //  private Switch switchView;
    //private TextView StatusTV;
    //private CheckBox SwitchView1;
    //private TextView StatusTV1;
    //private Object View;


    public MainActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Switch switchView=findViewById(R.id.switch1);
       CheckBox SwitchView1=findViewById(R.id.checkBox2);
       TextView StatusTV = findViewById(R.id.textView);
        TextView StatusTV1=findViewById(R.id.textView2);
        RadioGroup radioGroup = findViewById(R.id.radiogroup);
        TextView resultTextView = findViewById(R.id.textView5);


        if(switchView.isChecked())
        {
            StatusTV.setText("Power is ON");
        }
        else
        {
            StatusTV.setText("Power is OFF");
        }

        switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isON) {
                if (isON)
                {
                    StatusTV.setText("Power is ON");
                }
                else
                {
                    StatusTV.setText("Power is OFF");
                }
            }
        });

           SwitchView1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean ischecked) {
                    if (ischecked)
                    {
                       StatusTV1.setText("Your option is selected successfully");
                    }
                    else
                    {
                        StatusTV1.setText("you haven't selected any option yet");
                    }

                }
           });

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
                    switch (checkId)
                    {
                        case R.id.radioButton1:
                            resultTextView.setText("Easy level selected");
                            break;
                        case R.id.radioButton2:
                            resultTextView.setText("Medium level selected");
                            break;
                        case R.id.radioButton3:
                            resultTextView.setText("Hard level selected");
                    }
                }
            });
    }
}
