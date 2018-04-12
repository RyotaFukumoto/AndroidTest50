package com.example.ryota.androidtest14;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Output extends Fragment{
    TextView textView;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.output, container, false);
        this.textView = view.findViewById(R.id.textView);
        return view;
    }


    public void setTextView(String text) {
        this.textView.setText(text);
    }

}
