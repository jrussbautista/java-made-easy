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
public class Exercises15cFragment extends Fragment {


    public Exercises15cFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exercises15c, container, false);

        TextView a = (TextView) view.findViewById(R.id.o7);
        a.setText(Html.fromHtml(getString(R.string.o7)));

        TextView b = (TextView) view.findViewById(R.id.o8);
        b.setText(Html.fromHtml(getString(R.string.o8)));

        TextView c = (TextView) view.findViewById(R.id.o9);
        c.setText(Html.fromHtml(getString(R.string.o9)));

        return view;

    }

}
