package com.example.jamesrussel.javamadeeasy;

/**
 * Created by James Russel on 9/4/2016.
 */
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CoverFlowAdapter extends BaseAdapter {

    private ArrayList<Game> data;
    private AppCompatActivity activity;

    public CoverFlowAdapter(AppCompatActivity context, ArrayList<Game> objects) {
        this.activity = context;
        this.data = objects;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Game getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_flow_view, null, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.gameImage.setImageResource(data.get(position).getImageSource());
        viewHolder.gameName.setText(data.get(position).getName());

        convertView.setOnClickListener(onClickListener(position));

        return convertView;
    }

    private View.OnClickListener onClickListener(final int position) {

        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                displayView(position);
            }
            private void displayView(int position) {
                switch (position) {
                    case 0:
                        new ProgramActivity();
                        Intent video = new Intent("com.example.jamesrussel.javamadeeasy.ProgramActivity");
                        video.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        activity.startActivity(video);
                        break;
                    case 1:
                        new GlossaryActivity();
                        Intent lesson = new Intent("com.example.jamesrussel.javamadeeasy.GlossaryActivity");
                        lesson.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        activity.startActivity(lesson);
                        break;
                    case 2:
                        new LessonActivity();
                        Intent program = new Intent("com.example.jamesrussel.javamadeeasy.LessonActivity");
                        program.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        activity.startActivity(program);
                        break;
                    case 3:
                        new MyQuizActivity();
                        Intent question = new Intent("com.example.jamesrussel.javamadeeasy.MyQuizActivity");
                        question.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        activity.startActivity(question);
                        break;
                    case 4:
                        new VideoTutorialsActivity();
                        Intent exercises = new Intent("com.example.jamesrussel.javamadeeasy.VideoTutorialsActivity");
                        exercises.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        activity.startActivity(exercises);
                        break;
                    case 5:
                        new QuestionActivity();
                        Intent quiz = new Intent("com.example.jamesrussel.javamadeeasy.QuestionActivity");
                        quiz.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        activity.startActivity(quiz);
                        break;
                    case 6:
                        new ExercisesActivity();
                        Intent glossary = new Intent("com.example.jamesrussel.javamadeeasy.ExercisesActivity");
                        activity.startActivity(glossary);
                        glossary.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        break;
                }
            }
        };
    }


    private static class ViewHolder {
        private TextView gameName;
        private ImageView gameImage;

        public ViewHolder(View v) {
            gameImage = (ImageView) v.findViewById(R.id.image);
            gameName = (TextView) v.findViewById(R.id.name);
        }
    }
}