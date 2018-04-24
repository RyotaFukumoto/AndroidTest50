package com.example.ryota.androidtest48;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText = findViewById(R.id.editText4);
        Button button = findViewById(R.id.button2);


        mDatabase = FirebaseDatabase.getInstance().getReference();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();

                writeNewData(text);
            }
        });

        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                DataRow dataRow = dataSnapshot.child("test").getValue(DataRow.class);
                Log.d("database",dataRow.txet);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Log.d("database","chang");

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.d("database","Remov");
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                Log.d("database","move");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("database","cancell");
            }
        });
    }


    private void writeNewData(String text){
        DataRow dataRow = new DataRow(text);
        mDatabase.child("test").push().setValue(dataRow);
    }
}
