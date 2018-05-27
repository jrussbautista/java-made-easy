package com.example.jamesrussel.javamadeeasy;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedbackFragment extends Fragment {

    private EditText txtTo;
    private EditText txtSubject;
    private EditText txtContent;


    public FeedbackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v = inflater.inflate(R.layout.fragment_feedback, container, false);
        txtContent = (EditText) v.findViewById(R.id.content);
        txtSubject = (EditText) v.findViewById(R.id.subject);
        txtTo = (EditText) v.findViewById(R.id.email);
        setHasOptionsMenu(true);
        return v;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem item=menu.findItem(R.id.context_menu);
        item.setVisible(false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuInflater inflater1 = getActivity().getMenuInflater();
        inflater1.inflate(R.menu.menu_message, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.send) {
            sendingEmail();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private String getText(EditText textView) {
        return textView.getText().toString().trim();
    }

    private void sendingEmail() {
        if (!checkEmailAddress(getText(txtTo))) {
            Toast.makeText(getContext(), "Receiver Email is invalid!", Toast.LENGTH_SHORT).show();
        } else if (getText(txtSubject).equals("")) {
            Toast.makeText(getContext(), "Please input Email Subject!", Toast.LENGTH_SHORT).show();
        } else {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);

            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{getText(txtTo)});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, getText(txtSubject));
            emailIntent.putExtra(Intent.EXTRA_TEXT, getText(txtContent));

            try {
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(getContext(), "There is no email client installed.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean checkEmailAddress(String emailAddress) {

        String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Boolean b = emailAddress.matches(EMAIL_REGEX);

        return b;
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

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){
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
