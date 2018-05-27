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
public class Exercises15aFragment extends Fragment {


    public Exercises15aFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exercises15a, container, false);

        TextView a = (TextView) view.findViewById(R.id.o1);
        a.setText(Html.fromHtml(getString(R.string.o1)));

        TextView b = (TextView) view.findViewById(R.id.o2);
        b.setText(Html.fromHtml(getString(R.string.o2)));

        TextView c = (TextView) view.findViewById(R.id.o3);
        c.setText(Html.fromHtml(getString(R.string.o3)));

        return view;

    }

}
