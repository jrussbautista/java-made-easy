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
public class Exercises11cFragment extends Fragment {


    public Exercises11cFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exercises11c, container, false);

        TextView a = (TextView) view.findViewById(R.id.k7);
        a.setText(Html.fromHtml(getString(R.string.k7)));

        TextView b = (TextView) view.findViewById(R.id.k8);
        b.setText(Html.fromHtml(getString(R.string.k8)));

        TextView c = (TextView) view.findViewById(R.id.k9);
        c.setText(Html.fromHtml(getString(R.string.k9)));

        return view;

    }

}
