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

/**
 * This activity shows the result of the game.
 * Player can go to see the high score, replay again and go to the info.
 */
public class ResultActivity extends AppCompatActivity {

    private DBHelper db;
    private TextView tvRank;
    private MediaPlayer mp;
    public static final String FINAL_SCORE = "finalScore";
    public static final String CORRECT_ANSWERS = "correctAnswers";
    public static final String MINUTES = "minutes";
    public static final String SECONDS = "seconds";
    public static final String CATEGORY = "category" ;
    private String name="";
    private Player player;
    public static String currentPlayer = "Guest";
    private MediaPlayer mpb;
    private FButton high;
    private FButton play;
    private FButton back;

    /**
     * Displays the game results and saves the score in the high score table.
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_result);
        if(mp != null){
            if(mp.isPlaying()){
                mp.stop();
            }
         }

        high = (FButton)findViewById(R.id.high);
        high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playClickSound();
                Intent i = new Intent(ResultActivity.this, HighscoreActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        play = (FButton)findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playClickSound();
                Intent i = new Intent(ResultActivity.this, GameModeActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);

            }
        });
        back = (FButton)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playClickSound();
                Intent i = new Intent(ResultActivity.this, MyQuizActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });


        player = Player.getPlayerInstance("Guest");
        currentPlayer = player.getName();

        db=DBHelper.getDbHelperInstance(this);
        player = Player.getPlayerInstance("Guest");

        Intent intent = getIntent();

        int finalScore = intent.getIntExtra(FINAL_SCORE, 0);
        int correctAnswers = intent.getIntExtra(CORRECT_ANSWERS, 0);
        int minutes = intent.getIntExtra(MINUTES, 0);
        int seconds = intent.getIntExtra(SECONDS, 0);
        String category = intent.getStringExtra(CATEGORY);
        name = player.getName();
        int rank= db.getRank(db.getHighScore(category), finalScore);

        TextView tvRank = (TextView) findViewById(R.id.rank);
        tvRank.setText(String.format(getString(R.string.you_are_rank), rank));
        TextView scoreView = (TextView) findViewById(R.id.score);
        scoreView.setText(String.format(getString(R.string.total_score), finalScore + " /50"));
        TextView correctView = (TextView) findViewById(R.id.correct_anwsers);
        correctView.setText(String.format(getString(R.string.correct_answers), correctAnswers + " /10"));
        TextView timeView = (TextView) findViewById(R.id.time);
        timeView.setText(String.format(getString(R.string.minutes_seconds), minutes, seconds));;

        int lastDigit = rank % 10;

        if(finalScore > 0){
            tvRank = (TextView) findViewById(R.id.rank);
            if(lastDigit == 1) {
                tvRank.setText(String.format(getString(R.string.you_placed_xst_place_on_high_score), rank,category));
            }
            else if (lastDigit == 2 && rank != 12) {
                tvRank.setText(String.format(getString(R.string.you_placed_xnd_place_on_high_score), rank,category));
            }
            else if (lastDigit == 3 && rank != 13) {
                tvRank.setText(String.format(getString(R.string.you_placed_xrd_place_on_high_score), rank,category));
            } else {
                tvRank.setText(String.format(getString(R.string.you_placed_xth_place_on_high_score), rank,category));
            }
        db.addHighScore(name, finalScore, db.getIdByCategoryName(category));

        }else{
            tvRank = (TextView) findViewById(R.id.rank);
            tvRank.setText(R.string.you_can_not_be_ranked);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, GameModeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, GameModeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void playClickSound() {
        mpb = MediaPlayer.create(this, R.raw.test);
        mpb.start();
    }
}
