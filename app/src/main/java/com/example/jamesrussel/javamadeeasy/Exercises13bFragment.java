package com.example.jamesrussel.javamadeeasy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Exercises13bFragment extends Fragment {


    public Exercises13bFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exercises13b, container, false);

        TextView a = (TextView) view.findViewById(R.id.m4);
        a.setText(Html.fromHtml(getString(R.string.m4)));

        TextView b = (TextView) view.findViewById(R.id.m5);
        b.setText(Html.fromHtml(getString(R.string.m5)));

        TextView c = (TextView) view.findViewById(R.id.m6);
        c.setText(Html.fromHtml(getString(R.string.m6)));

        return view;

    }
}