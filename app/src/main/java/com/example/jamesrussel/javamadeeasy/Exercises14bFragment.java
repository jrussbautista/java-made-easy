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
public class Exercises14bFragment extends Fragment {


    public Exercises14bFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exercises14b, container, false);

        TextView a = (TextView) view.findViewById(R.id.n4);
        a.setText(Html.fromHtml(getString(R.string.n4)));

        TextView b = (TextView) view.findViewById(R.id.n5);
        b.setText(Html.fromHtml(getString(R.string.n5)));

        TextView c = (TextView) view.findViewById(R.id.n6);
        c.setText(Html.fromHtml(getString(R.string.n6)));

        return view;

    }

}
