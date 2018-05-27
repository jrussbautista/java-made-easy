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
public class Exercises11aFragment extends Fragment {


    public Exercises11aFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exercises11a, container, false);

        TextView a = (TextView) view.findViewById(R.id.k1);
        a.setText(Html.fromHtml(getString(R.string.k1)));

        TextView b = (TextView) view.findViewById(R.id.k2);
        b.setText(Html.fromHtml(getString(R.string.k2)));

        TextView c = (TextView) view.findViewById(R.id.k3);
        c.setText(Html.fromHtml(getString(R.string.k3)));

        return view;

    }

}
