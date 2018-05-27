package com.example.jamesrussel.javamadeeasy;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

/**
 * This activity shows high scores.
 * It shows rank, name and scores.
 */
public class ShowHighScoreActivity extends AppCompatActivity {
    private ListView listview;
    private DBHelper db;
    private SimpleCursorAdapter adapter;
    public static final String CATEGORY= "category";
    private String category;
    private  Cursor cursor;
    public static String currentPlayer = "Guest";
    private MediaPlayer mpb;
    private Player player = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_show_high_score);
        player = Player.getPlayerInstance("Guest");
        currentPlayer = player.getName();

        listview = (ListView) findViewById(R.id.show_high_score);
        db=DBHelper.getDbHelperInstance(this);

        Intent intent = getIntent();
        category = intent.getStringExtra(CATEGORY);

            if (category.equals("ALL")){
                cursor = db.getHighScoreTable();
            }else{
                cursor= db.getCategorisedTable(category);
            }

        String [] from = {db.getNameKey(),db.getScoreKey()};
        int [] to = {R.id.high_score_name,R.id.high_score_point};
        adapter = new SimpleCursorAdapter(this, R.layout.high_scores_list_item,cursor,from, to, 0);

        listview.setAdapter(adapter);

        //refresh RANK_TABLE
        db.deleteRank();
        ArrayList<Integer> highscore = db.getHighScore(category);

            if(highscore.get(0)!= 0) {

                for (int i = 0; i < highscore.size(); i++) {
                    db.insertRank(db.getRank(highscore, highscore.get(i)));
                }
                cursor = db.getOneTable(db.getRankTable());
                ListView rank = (ListView) findViewById(R.id.show_rank);

                String[] from2 = {db.getRankKey()};
                int[] to2 = {R.id.high_score_rank_test};
                adapter = new SimpleCursorAdapter(this, R.layout.rank_list_item, cursor, from2, to2, 0);
                rank.setAdapter(adapter);
            }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                Intent k = new Intent(ShowHighScoreActivity.this, HighscoreActivity.class);
                k.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(k);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void playClickSound() {
        mpb = MediaPlayer.create(this, R.raw.test);
        mpb.start();
    }

    @Override
    public void onBackPressed() {
        Intent k = new Intent(ShowHighScoreActivity.this, HighscoreActivity.class);
        k.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(k);
    }
}
