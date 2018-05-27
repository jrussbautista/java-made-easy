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
public class Exercises12bFragment extends Fragment {


    public Exercises12bFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exercises12b, container, false);

        TextView a = (TextView) view.findViewById(R.id.l4);
        a.setText(Html.fromHtml(getString(R.string.l4)));

        TextView b = (TextView) view.findViewById(R.id.l5);
        b.setText(Html.fromHtml(getString(R.string.l5)));

        TextView c = (TextView) view.findViewById(R.id.l6);
        c.setText(Html.fromHtml(getString(R.string.l6)));

        return view;

    }
}