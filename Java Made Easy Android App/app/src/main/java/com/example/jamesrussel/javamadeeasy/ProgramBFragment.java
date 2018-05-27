package com.example.jamesrussel.javamadeeasy;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProgramBFragment extends Fragment {

    ArrayAdapter<String> dataAdapter = null;


    public ProgramBFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_program_b, container, false);

        //Array list of countries final List<String> countryList = new ArrayList<String>();
        final List<String> countryList = new ArrayList<String>();
        countryList.add("Pattern 1");
        countryList.add("Pattern 2");
        countryList.add("Pattern 3");
        countryList.add("Pattern 4");
        countryList.add("Pattern 5");
        countryList.add("Pattern 6");
        countryList.add("Pattern 7");
        countryList.add("Pattern 8");
        countryList.add("Pattern 9");
        countryList.add("Pattern 10");
        countryList.add("Pattern 11");
        countryList.add("Pattern 12");
        countryList.add("Pattern 13");
        countryList.add("Pattern 14");
        countryList.add("Pattern 15");
        countryList.add("Pattern 16");
        countryList.add("Pattern 17");
        countryList.add("Pattern 18");
        countryList.add("Pattern 19");
        countryList.add("Pattern 20");

        dataAdapter = new ArrayAdapter<String>(getContext(),
                R.layout.pattern, countryList);
        ListView listView = (ListView) v.findViewById(R.id.listView1);
        listView.setAdapter(dataAdapter);;


        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String program = (String) parent.getItemAtPosition(position);
                if (program == "Pattern 1") {
                    Intent i = new Intent(getContext(), Pattern1.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                if (program == "Pattern 2") {
                    Intent i = new Intent(getContext(), Pattern2.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                if (program == "Pattern 3") {
                    Intent i = new Intent(getContext(),  Pattern3.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                if (program == "Pattern 4") {
                    Intent i = new Intent(getContext(),  Pattern4.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                if (program == "Pattern 5") {
                    Intent i = new Intent(getContext(),  Pattern5.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                if (program == "Pattern 6") {
                    Intent i = new Intent(getContext(),  Pattern6.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                if (program == "Pattern 7") {
                    Intent i = new Intent(getContext(),  Pattern7.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                if (program == "Pattern 8") {
                    Intent i = new Intent(getContext(),  Pattern8.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                if (program == "Pattern 9") {
                    Intent i = new Intent(getContext(),  Pattern9.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                if (program == "Pattern 10") {
                    Intent i = new Intent(getContext(),  Pattern10.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                if (program == "Pattern 11") {
                    Intent i = new Intent(getContext(),  Pattern11.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                if (program == "Pattern 12") {
                    Intent i = new Intent(getContext(),  Pattern12.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                if (program == "Pattern 13") {
                    Intent i = new Intent(getContext(),  Pattern13.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                if (program == "Pattern 14") {
                    Intent i = new Intent(getContext(),  Pattern14.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                if (program == "Pattern 15") {
                    Intent i = new Intent(getContext(),  Pattern15.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                if (program == "Pattern 16") {
                    Intent i = new Intent(getContext(),  Pattern16.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                if (program == "Pattern 17") {
                    Intent i = new Intent(getContext(),  Pattern17.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                if (program == "Pattern 18") {
                    Intent i = new Intent(getContext(),  Pattern18.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                if (program == "Pattern 19") {
                    Intent i = new Intent(getContext(),  Pattern19.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                if (program == "Pattern 20") {
                    Intent i = new Intent(getContext(),  Pattern20.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }



    }
        });

        EditText myFilter = (EditText) v.findViewById(R.id.myFilter);
        myFilter.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                dataAdapter.getFilter().filter(s.toString());
            }
        });

        return v;
    }
}