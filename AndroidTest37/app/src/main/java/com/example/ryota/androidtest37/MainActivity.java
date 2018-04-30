package com.example.ryota.androidtest37;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Validator.ValidationListener {
    private EditText titleEditText;
    private EditText contentEditText;


    @Email
    private EditText addressEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Validator validator = new Validator(this);
        validator.setValidationListener(this);


        this.addressEditText = (EditText) findViewById(R.id.addressEditTex);
        this.titleEditText = (EditText) findViewById(R.id.titleEditText);
        this.contentEditText = (EditText) findViewById(R.id.contentEditText);





        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validator.validate();
            }
        });
    }
    private void callMailer(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SENDTO);

        intent.setType("text/plain");
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{this.addressEditText.getText().toString()});
        intent.putExtra(Intent.EXTRA_SUBJECT, this.titleEditText.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT, this.contentEditText.getText().toString());

        startActivity(Intent.createChooser(intent, null));

    }

    @Override
    public void onValidationSucceeded() {
        Toast.makeText(this,"バリデーション通過",Toast.LENGTH_SHORT).show();
        callMailer();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for(ValidationError error:errors){
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            if(view instanceof EditText){
                ((EditText)view).setError(message);
                this.addressEditText.setError(message);
            }else {
                Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
            }
        }
    }
}
