package com.example.jamesrussel.javamadeeasy;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Exercises14cFragment extends Fragment {

    public Exercises14cFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exercises14c, container, false);

        TextView a = (TextView) view.findViewById(R.id.n7);
        a.setText(Html.fromHtml(getString(R.string.n7)));

        TextView b = (TextView) view.findViewById(R.id.n8);
        b.setText(Html.fromHtml(getString(R.string.n8)));

        TextView c = (TextView) view.findViewById(R.id.n9);
        c.setText(Html.fromHtml(getString(R.string.n9)));

        return view;

    }

}
