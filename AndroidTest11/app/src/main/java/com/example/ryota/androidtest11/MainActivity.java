package com.example.ryota.androidtest11;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    private InputMethodManager inputMethodManager;
    private ConstraintLayout mainLayout;
    private EditText editText;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mainLayout = (ConstraintLayout) findViewById(R.id.layout);

        this.inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_DOWN
                        && keyCode == KeyEvent.KEYCODE_ENTER) {
                    if (editText.length() > 0) {

                        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(),
                                InputMethodManager.RESULT_SHOWN);
                        return true;
                    }
                }

                return false;
            }
        });

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        hideKeyboard();
        return true;
    }

    private void hideKeyboard() {

        this.inputMethodManager.hideSoftInputFromWindow(this.mainLayout.getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
        this.mainLayout.requestFocus();

    }

}