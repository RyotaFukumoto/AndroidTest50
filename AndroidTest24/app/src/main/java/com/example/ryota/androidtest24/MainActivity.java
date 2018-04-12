package com.example.ryota.androidtest24;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private SharedPreferences dataStore;
    private EditText intText,doubleText,stringText;
    private TextView intView,doubleView,stringView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.dataStore = getSharedPreferences("DataStore",MODE_PRIVATE);

        this.intText = findViewById(R.id.editText);
        this.doubleText = findViewById(R.id.editText2);
        this.stringText = findViewById(R.id.editText3);

        this.intView = findViewById(R.id.textView);
        this.doubleView = findViewById(R.id.textView2);
        this.stringView = findViewById(R.id.textView3);
        Button buttonWrite = findViewById(R.id.button);
        buttonWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(MainActivity.this.intText.getText().toString());
                double d = Double.parseDouble(MainActivity.this.doubleText.getText().toString());
                String str = MainActivity.this.stringText.getText().toString();

                SharedPreferences.Editor editor = MainActivity.this.dataStore.edit();
                editor.putInt("inputint",i);
                editor.putLong("inputdouble",Double.doubleToRawLongBits(d));
                editor.putString("inputstring",str);

                editor.apply();

            }
        });

        Button buttonRead = findViewById(R.id.button2);
        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = MainActivity.this.dataStore.getInt("inputint",0);
                double d = Double.longBitsToDouble(MainActivity.this.dataStore.getLong("inputdouble", (long) 0.0));
                String str = MainActivity.this.dataStore.getString("inputstring","No");
                Log.i("int",i + " ");
                String finaleInt = Integer.valueOf(i).toString();
                MainActivity.this.intView.setText(finaleInt);
                String finaleDouble = Double.valueOf(d).toString();
                MainActivity.this.doubleView.setText(finaleDouble);
                MainActivity.this.stringView.setText(str);
            }
        });
    }
}
