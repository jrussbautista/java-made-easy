package com.example.jamesrussel.javamadeeasy;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextSwitcher;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private FeatureCoverFlow coverFlow;
    private CoverFlowAdapter adapter;
    private ArrayList<Game> games;
    private TextSwitcher mTitle;



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        coverFlow = (FeatureCoverFlow) view.findViewById(R.id.coverflow);
        settingDummyData();
        adapter = new CoverFlowAdapter((AppCompatActivity) getContext(), games);
        coverFlow.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(onScrollListener());
        return view;
    }



    private FeatureCoverFlow.OnScrollPositionListener onScrollListener() {
        return new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                Log.v("MainActivity", "position: " + position);
            }

            @Override
            public void onScrolling() {
                Log.i("MainActivity", "scrolling");
            }
        };
    }

    private void settingDummyData() {
        games = new ArrayList<>();
        games.add(new Game(R.drawable.program, "Programs"));
        games.add(new Game(R.drawable.glassary, "Glossary"));
        games.add(new Game(R.drawable.lesson, "Lessons"));
        games.add(new Game(R.drawable.quiz, "Quiz"));
        games.add(new Game(R.drawable.video, "Video Tutorials"));
        games.add(new Game(R.drawable.question, "Important Questions"));
        games.add(new Game(R.drawable.exercises, "Exercises"));
    }





}


