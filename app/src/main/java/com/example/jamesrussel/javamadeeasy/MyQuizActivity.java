package com.example.jamesrussel.javamadeeasy;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import info.hoang8f.widget.FButton;

public class MyQuizActivity extends AppCompatActivity {

    private TextView mTextField;
    private MediaPlayer mp;
    public static String currentPlayer="Guest";
    private Player player = null;
    private FButton play;
    private FButton high;
    private FButton profile;
    private FButton back;
    private FButton rules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_quiz);
        play = (FButton)findViewById(R.id.play);
        high = (FButton)findViewById(R.id.high);
        profile = (FButton)findViewById(R.id.profile);
        rules = (FButton)findViewById(R.id.rules);
        back = (FButton)findViewById(R.id.back);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playClickSound();
                Intent intent = new Intent(MyQuizActivity.this, GameModeActivity.class);
                startActivity(intent);
            }
        });

        high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playClickSound();
                Intent i = new Intent(MyQuizActivity.this, HighscoreActivity.class);
                startActivity(i);
            }
        });


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playClickSound();
                Intent intent = new Intent(MyQuizActivity.this, ProfilesActivity.class);
                startActivity(intent);
            }
        });


     rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playClickSound();
                Rules();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playClickSound();
                onBackPressed();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });



        player = Player.getPlayerInstance("Guest");
        currentPlayer = player.getName();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }


    /**
     * A method used for making the buttons do a sound when clicked.
     */
    public void playClickSound() {
        mp = MediaPlayer.create(this, R.raw.test);
        mp.start();
    }

    public void Rules(){
       RulesDialog rulesDialog= new RulesDialog();
       rulesDialog.show(getSupportFragmentManager(), "Rules");
    }
}
