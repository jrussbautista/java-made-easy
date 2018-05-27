package com.example.jamesrussel.javamadeeasy;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * This activity has information about the Asobi team who created this application.
 */
public class AboutActivity extends AppCompatActivity {

    public static String currentPlayer = "Guest";
    private MediaPlayer mpb;
    private Player player = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        player = Player.getPlayerInstance("Guest");
        currentPlayer = player.getName();

    }



    @Override
    public void onBackPressed() {
        Intent homeIntent = new Intent(this, MyQuizActivity.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }
}
