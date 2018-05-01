package com.example.ryota.androidtest31;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;


public class WeatherDialogFragment extends DialogFragment {
    interface WeatherDialogFragmentListener{
        void onClicked(int position);
    }

    private WeatherDialogFragmentListener listener;

    public void setListener(WeatherDialogFragmentListener listener) {
        this.listener = listener;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        CharSequence[] items = {"今日", "明日", "明後日"};


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                Activity activity = getActivity();
                if(listener != null){
                    listener.onClicked(which);

                }
                else {
                    Log.e("System.err","listenerがセットされていません。");
                }
            }
        });
        return builder.create();
    }
}