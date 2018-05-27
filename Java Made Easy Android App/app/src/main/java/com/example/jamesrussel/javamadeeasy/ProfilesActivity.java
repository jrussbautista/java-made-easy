package com.example.jamesrussel.javamadeeasy;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import mehdi.sakout.fancybuttons.FancyButton;


/**
 * Player can create your own player from this activity.
 * Player can log in as own name you create.
 * Player can also delete your profile.
 */
public class ProfilesActivity extends AppCompatActivity {

    private ListView listView;
    private DBHelper dbHelper;
    private EditText nameInput;
    SimpleCursorAdapter adapter;
    private String z;
    private String name;
    private Player player;
    public static String currentPlayer = "Guest";
    private MediaPlayer mpb;
    private FancyButton add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profiles);
        player = Player.getPlayerInstance("Guest");
        currentPlayer = player.getName();

        //Create profile
        listView = (ListView) findViewById(R.id.profile_list);
        dbHelper = DBHelper.getDbHelperInstance(this);

        Cursor players = dbHelper.getOneTable(dbHelper.getPlayerTable());

        String [] from = {dbHelper.getNameKey()};
        int [] to = {R.id.profile_name};
        adapter = new SimpleCursorAdapter(this, R.layout.profile_list_item,players ,from, to, 0);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listListener);
        listView.setOnItemLongClickListener(listListenerLong);

        player = Player.getPlayerInstance(name);

        add = (FancyButton)findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameInput = (EditText) findViewById(R.id.enter_name);
                String name = nameInput.getText().toString();

                Cursor cursor = dbHelper.getOneTable(dbHelper.getPlayerTable());
                int sameName = 0;

                if(cursor.moveToFirst()){
                    String existName;
                    do{
                        existName = cursor.getString(1);
                        if(name.equals(existName)){
                            sameName++;
                        }
                    }while(cursor.moveToNext());
                }

                if(sameName > 0){
                    Toast.makeText(getApplicationContext(), R.string.this_name_already_exists, Toast.LENGTH_SHORT).show();
                    nameInput.getText().clear();
                } else {
                    dbHelper.addProfile(name);
                    cursor = dbHelper.getOneTable(dbHelper.getPlayerTable());
                    adapter.changeCursor(cursor);
                    nameInput.getText().clear();
                    Toast.makeText(getApplicationContext(), R.string.profile_created, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private AdapterView.OnItemClickListener listListener = new AdapterView.OnItemClickListener(){

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Cursor cur = (Cursor) parent.getItemAtPosition(position);
            cur.moveToPosition(position);
            name = cur.getString(cur.getColumnIndex(dbHelper.getNameKey()));
            player.setName(name);

            Context context = getApplicationContext();
            CharSequence text = (String.format("Logged in as %s", name));
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            Intent i = new Intent(ProfilesActivity.this, MyQuizActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        }
    };

    private AdapterView.OnItemLongClickListener listListenerLong = new AdapterView.OnItemLongClickListener(){

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id){

            Cursor cur = (Cursor) parent.getItemAtPosition(position);
            cur.moveToPosition(position);
            z = cur.getString(cur.getColumnIndex(dbHelper.getNameKey()));

            AlertDialog diaBox = AskOption();
            diaBox.show();

            return true;
        }

    };


    private AlertDialog AskOption() {
        AlertDialog myQuittingDialogBox =new AlertDialog.Builder(this)
                //set message, title, and icon
                .setTitle(R.string.delete)
                .setMessage(R.string.do_you_want_to_delete)
                .setIcon(R.drawable.ic_delete)

                .setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        dbHelper.deleteProfile(z);
                        Cursor cursor = dbHelper.getOneTable(dbHelper.getPlayerTable());
                        adapter.changeCursor(cursor);
                        dialog.dismiss();
                    }

                })



                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                })
                .create();
        return myQuittingDialogBox;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
           case android.R.id.home:
                Intent k = new Intent(ProfilesActivity.this, MyQuizActivity.class);
               k.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(k);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Creates a profile from the used input used in the EditText field.
     * @param view collects the input from the user.
     */
    /**
     * A method used for making the actionbar buttons do a sound when clicked.
     */
    public void playClickSound() {
        mpb = MediaPlayer.create(this, R.raw.test);
        mpb.start();
    }
}
