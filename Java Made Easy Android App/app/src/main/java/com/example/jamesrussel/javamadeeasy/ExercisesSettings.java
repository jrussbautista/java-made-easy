package com.example.jamesrussel.javamadeeasy;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class ExercisesSettings extends AppCompatActivity {
    private SeekBar seekBar;
    private SeekBar volumeSeekBar;
    private AudioManager audioManager;
    private TextView mTextView;
    private DNToggleButton mToggleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_settings);
        Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.action_settings);
        getSupportActionBar().setIcon(R.drawable.ic_action_settings);

        int resId = (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
                ? R.drawable.ic_night : R.drawable.ic_day;
        Drawable drawable= getResources().getDrawable(resId);
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


        seekBar = (SeekBar) findViewById(R.id.seekBar1);
        seekBar.setMax(255);

        float curBrightnessValue = 0;
        try {
            curBrightnessValue = android.provider.Settings.System.getInt(
                    getContentResolver(),
                    android.provider.Settings.System.SCREEN_BRIGHTNESS);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }

        int screen_brightness = (int) curBrightnessValue;
        seekBar.setProgress(screen_brightness);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue,
                                          boolean fromUser) {
                progress = progresValue;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                android.provider.Settings.System.putInt(getContentResolver(),
                        android.provider.Settings.System.SCREEN_BRIGHTNESS,
                        progress);
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
        Intent homeIntent = new Intent(this,ExercisesActivity.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}
