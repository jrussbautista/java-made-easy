package com.example.jamesrussel.javamadeeasy;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings.System;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class SettingsActivity extends AppCompatActivity {

    SeekBar brightbar;
    private SeekBar volumeSeekBar;
    private AudioManager audioManager;
    private TextView mTextView;
    private DNToggleButton mToggleBtn;
    TextView see;
    TextView share;
    private int brightness;
    private ContentResolver cResolver;
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings2);
        Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.action_settings);
        getSupportActionBar().setIcon(R.drawable.ic_action_settings);

        see = (TextView) findViewById(R.id.see);
        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

        share = (TextView) findViewById(R.id.apps2);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareApplication();
            }
        });

        int resId = (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
                ? R.drawable.ic_moon2 : R.drawable.ic_day2;
        Drawable drawable = getResources().getDrawable(resId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());

        mTextView = (TextView) findViewById(R.id.tv);
        mTextView.setCompoundDrawables(drawable, null, null, null);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToggleBtn.setChecked(!mToggleBtn.isChecked(), true);
            }
        });

        mToggleBtn = (DNToggleButton) findViewById(R.id.dnBtn);
        mToggleBtn.setChecked(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO);
        mToggleBtn.setOnCheckedChangeListener(new DNToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(DNToggleButton toggleButton, boolean isChecked) {

                // filter recreate
                int curMode = isChecked ? AppCompatDelegate.MODE_NIGHT_NO : AppCompatDelegate.MODE_NIGHT_YES;
                if (AppCompatDelegate.getDefaultNightMode() == curMode) {
                    return;
                }

                getDelegate().setLocalNightMode(isChecked ? AppCompatDelegate.MODE_NIGHT_NO : AppCompatDelegate.MODE_NIGHT_YES);
                AppCompatDelegate.setDefaultNightMode(isChecked ? AppCompatDelegate.MODE_NIGHT_NO : AppCompatDelegate.MODE_NIGHT_YES);
                recreate();
            }
        });

        brightbar = (SeekBar) findViewById(R.id.brightbar);

        cResolver = getContentResolver();

        //Get the current window
        window = getWindow();

        //Set the seekbar range between 0 and 255
        brightbar.setMax(255);

        //Set the seek bar progress to 1
        brightbar.setKeyProgressIncrement(1);

        try {
            //Get the current system brightness
            brightness = System.getInt(cResolver, System.SCREEN_BRIGHTNESS);
        } catch (Exception e) {
            // TODO: handle exception
            //Throw an error case it couldn't be retrieved
            Log.e("Error", "cannot access system brightness.");
            e.printStackTrace();
        }

        brightbar.setProgress(brightness);


        //Register OnSeekBarChangeListener, so it can actually change values
        brightbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

                //Set the system brightness using the brightness variable value
                System.putInt(cResolver, System.SCREEN_BRIGHTNESS, brightness);
                //Get the current window attributes
                LayoutParams layoutpars = window.getAttributes();

                //Set the brightness of this window
                layoutpars.screenBrightness = brightness / (float)255;
                //Apply attribute changes to this window
                window.setAttributes(layoutpars);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

                //Nothing handled here
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                //Set the minimal brightness level
                //if seek bar is 20 or any value below
                if(progress<=20)
                {
                    //Set the brightness to 20
                    brightness=20;
                }
                else //brightness is greater than 20
                {
                    //Set brightness variable based on the progress bar
                    brightness = progress;
                }

            }
        });


        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        initControls();
    }




    private void initControls() {
        // TODO Auto-generated method stub
        try {
            volumeSeekBar = (SeekBar) findViewById(R.id.sb);
            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            volumeSeekBar.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            volumeSeekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
            volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    // TODO Auto-generated method stub
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);

                }
            });

        } catch (Exception e) {
            // TODO: handle exception
        }


    }
    @Override
    public void onBackPressed() {
        Intent homeIntent = new Intent(this, MainActivity.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    private void shareApplication() {
        ApplicationInfo app = getApplicationContext().getApplicationInfo();
        String filePath = app.sourceDir;
        Intent intent = new Intent(Intent.ACTION_SEND);
    // MIME of .apk is "application/vnd.android.package-archive".
    // but Bluetooth does not accept this. Let's use "*/*" instead.
        intent.setType("*/*");
    // Append file and send Intent
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(filePath)));
        startActivity(Intent.createChooser(intent, "Share app via"));
    }
}