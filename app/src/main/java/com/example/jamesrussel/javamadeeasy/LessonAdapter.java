package com.example.jamesrussel.javamadeeasy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by James Russel on 9/24/2016.
 */
public class LessonAdapter extends BaseAdapter {

    private Context c;

    String[]names={"Introduction", "Creating Your First Java Classes", "Using Data", "Using Methods, Classes, and Objects", "Making Decisions", "Looping", "Characters, Strings, and the StringBuilder", "Arrays", "Advanced Array Concepts", "Introduction to Inheritance", "Exception Handling","File Input and Output","Introduction to Swing Components"};
    int[]images={R.drawable.ic_1,R.drawable.ic_2,R.drawable.ic_3,R.drawable.ic_4,R.drawable.ic_5,R.drawable.ic_6,R.drawable.ic_7,R.drawable.ic_8,
            R.drawable.ic_9,R.drawable.ic_10, R.drawable.ic_11, R.drawable.ic_12, R.drawable.ic_13};

    public LessonAdapter(Context ctx)
    {
        this.c=ctx;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int pos) {
        return names[pos];
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {

        if (convertView==null)
        {
            LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.player, null);
        }

        TextView nameTxt = (TextView)convertView.findViewById(R.id.nameTv);
        ImageView img = (ImageView)convertView.findViewById(R.id.imageView1);

        nameTxt.setText(names[pos]);
        img.setImageResource(images[pos]);



        return convertView;
    }
}
