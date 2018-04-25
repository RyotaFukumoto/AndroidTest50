package com.example.ryota.androidtest26;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

public class DeleteflgDialogFragment extends DialogFragment {
    private DialogListerer listerer;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){    // Use the Builder class for convenient dialog construction

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("削除しますか？");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // OK button pressed

                DeleteflgDialogFragment.this.listerer.doPositiveClick();
                Log.i("AlertDialog1", "ok");

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Log.i("AlertDialog2", "cancel");
            }
        });
        // Create the AlertDialog object and return it
        return builder.create();
    }
    public void setDialogListener(DialogListerer listener){
        this.listerer = listener;
    }

}