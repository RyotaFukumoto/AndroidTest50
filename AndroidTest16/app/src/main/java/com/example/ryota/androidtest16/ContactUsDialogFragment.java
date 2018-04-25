package com.example.ryota.androidtest16;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

@SuppressLint("ValidFragment")
class ContactUsDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        CharSequence[] items = {"Facebook", "Twitter"};

        final Activity activity = getActivity();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        Toast.makeText(activity, "FacebookPush", Toast.LENGTH_SHORT).show();
                        Log.i("AlertDialog1", "touchFacebook");
                        break;
                    case 1:
                        Toast.makeText(activity, "TwitterPush", Toast.LENGTH_LONG).show();
                        Log.i("AlertDialog2", "touchTwitter");
                        break;

                    default:
                        break;
                }
            }
        });
        return builder.create();
    }
}


