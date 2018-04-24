package com.example.ryota.androidtest20;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExampleFragment extends Fragment {
    private static final String text = "0";
    private static final String BACKGROUND_COLOR = "background_color";
    public static ExampleFragment newInstance(@ColorRes int IdRes,String str) {
        ExampleFragment frag = new ExampleFragment();
        Bundle bundle = new Bundle();
        bundle.putString(text,str);
        bundle.putInt(BACKGROUND_COLOR, IdRes);
        frag.setArguments(bundle);
        return frag;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frament_main,container,false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.fragment_main_linearlayout);
        linearLayout.setBackgroundResource(getArguments().getInt(BACKGROUND_COLOR));
        TextView textView = view.findViewById(R.id.textView);
        textView.setText(getArguments().getString(text));

        return view;
    }
}