package com.example.tabviewwithfragmentspager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.jetbrains.annotations.Nullable;


public class ChatFragment extends Fragment
        {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceSate) {
        view = inflater.inflate(R.layout.fragment_chat, container, false);

        Button button = (Button) view.findViewById(R.id.button);
        EditText editText = view.findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String getValue = editText.getText().toString();

                Bundle result = new Bundle();
                result.putString("text",getValue);
                CallFragment callFragment= new CallFragment();
                callFragment.setArguments(result);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.viewPager,callFragment).commit();
                getParentFragmentManager().setFragmentResult("editText", result);
                editText.setText(" ");
            }
        });
        return view;
    }

}