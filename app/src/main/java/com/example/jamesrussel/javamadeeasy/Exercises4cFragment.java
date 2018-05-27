package com.example.jamesrussel.javamadeeasy;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class Exercises4cFragment extends Fragment {
    TextView a = null;
    TextView a1= null;
    public Exercises4cFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exercises4c, container, false);

        setHasOptionsMenu(true);
        a = (TextView) view.findViewById(R.id.ex1a);
        a.setText(Html.fromHtml(getString(R.string.ex4e)));
        a1  = (TextView) view.findViewById(R.id.a1);
        a1.setText(Html.fromHtml(getString(R.string.ex4f)));


        a.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = getActivity().getMenuInflater();
                inflater.inflate(R.menu.share_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_item_share:
                        String selectedText = getSelectedText();
                        shareIntent(selectedText);
                        return true;
                    default:
                        break;
                }
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });

        a1.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = getActivity().getMenuInflater();
                inflater.inflate(R.menu.share_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_item_share:
                        String selectedText = getSelectedText1();
                        shareIntent1(selectedText);
                        return true;
                    default:
                        break;
                }
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });



        return view;
    }

    private String getSelectedText() {
        String selectedText = "";
        int min = 0;
        int max = a.getText().length();
        if (a.isFocused()) {
            final int textStartIndex = a.getSelectionStart();
            final int textEndIndex = a.getSelectionEnd();
            min = Math.max(0, Math.min(textStartIndex, textEndIndex));
            max = Math.max(0, Math.max(textStartIndex, textEndIndex));
            selectedText = a.getText().subSequence(min, max).toString().trim();
        }
        return selectedText;
    }

    private void shareIntent(String Text) {
        if (!Text.equals("")) {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject here");
            shareIntent.putExtra(Intent.EXTRA_TEXT, Text);
            startActivity(Intent.createChooser(shareIntent, "Share Via"));
        } else {
            Toast.makeText(getContext(), R.string.empty_text1, Toast.LENGTH_LONG).show();
        }
    }

    private String getSelectedText1() {
        String selectedText = "";
        int min = 0;
        int max = a.getText().length();
        if (a1.isFocused()) {
            final int textStartIndex = a1.getSelectionStart();
            final int textEndIndex = a1.getSelectionEnd();
            min = Math.max(0, Math.min(textStartIndex, textEndIndex));
            max = Math.max(0, Math.max(textStartIndex, textEndIndex));
            selectedText = a1.getText().subSequence(min, max).toString().trim();
        }
        return selectedText;
    }

    private void shareIntent1(String Text) {
        if (!Text.equals("")) {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject here");
            shareIntent.putExtra(Intent.EXTRA_TEXT, Text);
            startActivity(Intent.createChooser(shareIntent, "Share Via"));
        } else {
            Toast.makeText(getContext(), R.string.empty_text1, Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

        }
        return super.onOptionsItemSelected(item);
    }
}



