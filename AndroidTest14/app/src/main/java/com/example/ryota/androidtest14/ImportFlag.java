package com.example.ryota.androidtest14;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ImportFlag extends Fragment {
    private EditText editText;
    private Button button;
    private TextView textView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.input, container, false);

    }
    @Override
    public void onStart() {
        super.onStart();
        findViews();

        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImportFlag.this.textView.setText(ImportFlag.this.editText.getText());
            }
        });
    }

    private void findViews(){
        this.editText = (EditText)getActivity().findViewById(R.id.editText);
        this.button = (Button)getActivity().findViewById(R.id.button);
        this.textView = (TextView)getActivity().findViewById(R.id.textView);
    }
}

