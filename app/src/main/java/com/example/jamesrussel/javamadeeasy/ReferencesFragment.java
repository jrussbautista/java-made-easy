package com.example.jamesrussel.javamadeeasy;


import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jamesrussel.javamadeeasy.link_builder.Link;
import com.example.jamesrussel.javamadeeasy.link_builder.LinkBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReferencesFragment extends Fragment {

    private static final String INTRO_LINK = "https://studyinfinity.com";
    private static final String LINK2 = "https://tutorialspoint.com";
    private static final String LINK3 = "https://javabasicsjavaprogrammingtutorial.com";
    private static final String LINK4 = "https://www.cengage/javaprogramming.pdf";
    private static final String LINK5 = "https://www.youtube.com/programmingknowledge";
    public ReferencesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v = inflater.inflate(R.layout.fragment_references, container, false);
        setHasOptionsMenu(true);

        TextView demoText = (TextView) v.findViewById(R.id.test_text);
        TextView text1 = (TextView) v.findViewById(R.id.test_text1);
        TextView text2 = (TextView) v.findViewById(R.id.test_text2);
        TextView text3 = (TextView) v.findViewById(R.id.test_text3);
        TextView text4 = (TextView) v.findViewById(R.id.test_text4);


        LinkBuilder.on(demoText)
                .addLinks(getExampleLinks())
                .build();

        LinkBuilder.on(text1)
                .addLinks(getExampleLinks1())
                .build();

        LinkBuilder.on(text2)
                .addLinks(getExampleLinks2())
                .build();

        LinkBuilder.on(text3)
                .addLinks(getExampleLinks3())
                .build();


        LinkBuilder.on(text4)
                .addLinks(getExampleLinks4())
                .build();

        return v;
    }

    private List<Link> getExampleLinks() {
        final List<Link> links = new ArrayList<>();

        Link intro = new Link( "http//www.studyinfinity.com");
        intro.setUnderlined(true);
        intro.setTypeface(Typeface.DEFAULT_BOLD)
                .setOnClickListener(new Link.OnClickListener() {
                    @Override
                    public void onClick(String clickedText) {
                        openLink(INTRO_LINK);
                    }
                });

        links.add(intro);

        return links;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem item=menu.findItem(R.id.context_menu);
        item.setVisible(false);
    }

    private List<Link> getExampleLinks1() {
        final List<Link> links = new ArrayList<>();

        Link intro = new Link( "www.tutorialspoint.com");
        intro.setUnderlined(true);
        intro.setTypeface(Typeface.DEFAULT_BOLD)
                .setOnClickListener(new Link.OnClickListener() {
                    @Override
                    public void onClick(String clickedText) {
                        openLink(LINK2);
                    }
                });

        links.add(intro);

        return links;
    }

    private List<Link> getExampleLinks2() {
        final List<Link> links = new ArrayList<>();

        Link intro = new Link( "www.javabasicsjavaprogrammingtutorial.com");
        intro.setUnderlined(true);
        intro.setTypeface(Typeface.DEFAULT_BOLD)
                .setOnClickListener(new Link.OnClickListener() {
                    @Override
                    public void onClick(String clickedText) {
                        openLink(LINK3);
                    }
                });

        links.add(intro);

        return links;
    }

    private List<Link> getExampleLinks3() {
        final List<Link> links = new ArrayList<>();

        Link intro = new Link( "www.cengage/javaprogramming.pdf");
        intro.setUnderlined(true);
        intro.setTypeface(Typeface.DEFAULT_BOLD)
                .setOnClickListener(new Link.OnClickListener() {
                    @Override
                    public void onClick(String clickedText) {
                        openLink(LINK4);
                    }
                });

        links.add(intro);

        return links;
    }

    private List<Link> getExampleLinks4() {
        final List<Link> links = new ArrayList<>();

        Link intro = new Link( "www.youtube.com/programmingknowledge");
        intro.setUnderlined(true);
        intro.setTypeface(Typeface.DEFAULT_BOLD)
                .setOnClickListener(new Link.OnClickListener() {
                    @Override
                    public void onClick(String clickedText) {
                        openLink(LINK5);
                    }
                });

        links.add(intro);

        return links;
    }

    private void openLink(String link) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        startActivity(browserIntent);
    }

    @Override
    public void onResume() {
        super.onResume();

        if(getView() == null){
            return;
        }
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                    getActivity().finish();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

    }

}
