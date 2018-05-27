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
public class ProgramA extends Fragment {

    ArrayAdapter<String> dataAdapter = null;


    public ProgramA() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_program, container, false);

        //Array list of countries
        final List<String> countryList = new ArrayList<String>();
        countryList.add("Number is Even or Odd");
        countryList.add("Factorial");
        countryList.add("Prime Number");
        countryList.add("Largest Among n Digit");
        countryList.add("Swap Without using third variable");
        countryList.add("Fibonacci Series");
        countryList.add("Palindrome");
        countryList.add("Pascal Triangle");
        countryList.add("Leap Year");
        countryList.add("Perfect Number");
        countryList.add("Armstrong Number");
        countryList.add("Strong Number");
        countryList.add("Floyd Triangle");
        countryList.add("Reverse Number");
        countryList.add("Sum of Digit");
        countryList.add("Power of Given Number");
        countryList.add("Count the Digit in Number");
        countryList.add("Random Number Generator");
        countryList.add("Fahrenheit to Celsius");


        dataAdapter = new ArrayAdapter<String>(getContext(),
                R.layout.item_list, countryList);
        ListView listView = (ListView) v.findViewById(R.id.listView1);

        listView.setAdapter(dataAdapter);
        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new OnItemClickListener() {
                                            public void onItemClick(AdapterView<?> parent, View view,
                                                                    int position, long id) {
                                                String program = (String) parent.getItemAtPosition(position);
                                                if (program == "Number is Even or Odd") {
                                                    Intent i = new Intent(getContext(), Program1.class);
                                                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                    startActivity(i);
                                                }
                                                if (program == "Factorial") {
                                                    Intent i = new Intent(getContext(), Program2.class);
                                                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                    startActivity(i);
                                                }
                                                if (program == "Prime Number") {
                                                    Intent i = new Intent(getContext(), Program3.class);
                                                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                    startActivity(i);
                                                }
                                                if (program == "Largest Among n Digit") {
                                                    Intent i = new Intent(getContext(), Program4.class);
                                                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                    startActivity(i);
                                                }
                                                if (program == "Swap Without using third variable") {
                                                    Intent i = new Intent(getContext(), Program5.class);
                                                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                    startActivity(i);
                                                }
                                                if (program == "Fibonacci Series") {
                                                    Intent i = new Intent(getContext(), Program6.class);
                                                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                    startActivity(i);
                                                }
                                                if (program == "Palindrome") {
                                                    Intent i = new Intent(getContext(), Program7.class);
                                                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                    startActivity(i);
                                                }
                                                if (program == "Pascal Triangle") {
                                                    Intent i = new Intent(getContext(), Program8.class);
                                                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                    startActivity(i);
                                                }
                                                if (program == "Leap Year") {
                                                    Intent i = new Intent(getContext(), Program9.class);
                                                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                    startActivity(i);
                                                }
                                                if (program == "Perfect Number") {
                                                    Intent i = new Intent(getContext(), Program10.class);
                                                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                    startActivity(i);
                                                }
                                                if (program == "Armstrong Number") {
                                                    Intent i = new Intent(getContext(), Program11.class);
                                                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                    startActivity(i);
                                                }
                                                if (program == "Strong Number") {
                                                    Intent i = new Intent(getContext(), Program12.class);
                                                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                    startActivity(i);
                                                }
                                                if (program == "Floyd Triangle") {
                                                    Intent i = new Intent(getContext(), Program13.class);
                                                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                    startActivity(i);
                                                }
                                                if (program == "Reverse Number") {
                                                    Intent i = new Intent(getContext(), Program14.class);
                                                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                    startActivity(i);
                                                }
                                                if (program == "Sum of Digit") {
                                                    Intent i = new Intent(getContext(), Program15.class);
                                                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                    startActivity(i);
                                                }
                                                if (program == "Power of Given Number") {
                                                    Intent i = new Intent(getContext(), Program16.class);
                                                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                    startActivity(i);
                                                }
                                                if (program == "Count the Digit in Number") {
                                                    Intent i = new Intent(getContext(), Program17.class);
                                                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                    startActivity(i);
                                                }
                                                if (program == "Random Number Generator") {
                                                    Intent i = new Intent(getContext(), Program18.class);
                                                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                    startActivity(i);
                                                }
                                                if (program == "Fahrenheit to Celsius") {
                                                    Intent i = new Intent(getContext(), Program19.class);
                                                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                    startActivity(i);
                                                }

                                            }
                                        }

        );

        EditText myFilter = (EditText) v.findViewById(R.id.myFilter);
        myFilter.addTextChangedListener(new

                                                TextWatcher() {

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