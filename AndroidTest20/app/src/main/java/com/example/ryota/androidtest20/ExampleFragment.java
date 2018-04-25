package com.example.ryota.androidtest20;

import android.os.Bundle;
import android.support.annotation.ColorRes;
<<<<<<< HEAD
=======
import android.support.annotation.NonNull;
>>>>>>> AndroidTest20
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

<<<<<<< HEAD
public class ExampleFragment extends Fragment {
    TextView textView;
    private static final String string = "0";
    private static final String BACKGROUND_COLOR = "background_color";
    public static ExampleFragment newInstance(@ColorRes int IdRes,String str) {
        ExampleFragment frag = new ExampleFragment();
        Bundle b = new Bundle();
        b.putString(string,str);
        b.putInt(BACKGROUND_COLOR, IdRes);
        frag.setArguments(b);
=======
import com.example.ryota.androidtest20.R.id;
import com.example.ryota.androidtest20.R.layout;

public class ExampleFragment extends Fragment {
    private static final String text = "0";
    private static final String BACKGROUND_COLOR = "background_color";
    public static ExampleFragment newInstance(@ColorRes int IdRes,String str) {
        ExampleFragment frag = new ExampleFragment();
        Bundle bundle = new Bundle();
        bundle.putString(text,str);
        bundle.putInt(BACKGROUND_COLOR, IdRes);
        frag.setArguments(bundle);
>>>>>>> AndroidTest20
        return frag;
    }

    @Override
<<<<<<< HEAD
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_main,container,false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.fragment_main_linearlayout);
        linearLayout.setBackgroundResource(getArguments().getInt(BACKGROUND_COLOR));
        textView = view.findViewById(R.id.textView);
        textView.setText(getArguments().getString(string));
=======
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(layout.frament_main,container,false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(id.fragment_main_linearlayout);
        linearLayout.setBackgroundResource(getArguments().getInt(BACKGROUND_COLOR));
        TextView textView = view.findViewById(id.textView);
        textView.setText(getArguments().getString(text));
>>>>>>> AndroidTest20

        return view;
    }
}