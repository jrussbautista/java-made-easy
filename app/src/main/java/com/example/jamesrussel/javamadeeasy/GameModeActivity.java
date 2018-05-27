package com.example.jamesrussel.javamadeeasy;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

/**
 * From this activity player can choose with which categories she wants to play
 */
public class GameModeActivity extends AppCompatActivity {

    private ListView listview;
    private DBHelper db;
    private MediaPlayer mp;
    public static String currentPlayer="Guest";
    private Player player = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game_mode);
        player = Player.getPlayerInstance("Guest");
        currentPlayer = player.getName();

        db=DBHelper.getDbHelperInstance(this);

        listview = (ListView) findViewById(R.id.category_list);

        Cursor categories = db.getOneTable(db.getAllCategoryTable());
        String [] from = {db.getCategoryKey()};
        int [] to = {R.id.category};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.category_list_item,categories ,from, to, 0);

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(listListener);


    }

    private AdapterView.OnItemClickListener listListener = new AdapterView.OnItemClickListener(){

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){

            Cursor cur = (Cursor) parent.getItemAtPosition(position);
            cur.moveToPosition(position);
            String category = cur.getString(cur.getColumnIndex(db.getCategoryKey()));

            int length=db.getLengthOfQuestions(category) ;

            if(length<5){
                Toast.makeText(GameModeActivity.this, R.string.you_need_at_least_five_questions, Toast.LENGTH_SHORT).show();
            } else{

            Intent intent = new Intent(GameModeActivity.this, GameActivity.class);

            intent.putExtra(GameActivity.CATEGORY,category);
            startActivity(intent);
            }
        }
    };

    /**
     * Gets the actionbar.
     * @param menu the actionbar menu.
     * @return true so you can see the actionbar.
     */

    /**
     * Handles the item clicks here.
     * @param item is the symbol showed up on the actionbar.
     * @return returns true if clicked and takes you to the next activity.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                Intent k = new Intent(GameModeActivity.this, MyQuizActivity.class);
                k.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(k);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void getQuestionsFromAll(View view) {
        Intent intent = new Intent(GameModeActivity.this, GameActivity.class);
        intent.putExtra(GameActivity.CATEGORY,"ALL");
        startActivity(intent);
    }



    @Override
    public void onBackPressed() {
        Intent k = new Intent(GameModeActivity.this, MyQuizActivity.class);
        k.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(k);
    }
}
