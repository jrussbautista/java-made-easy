package com.example.jamesrussel.javamadeeasy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class VideoAdapter extends BaseAdapter {

    private Context c;

    String[]names={"Introduction and Installing the Java (JDK)", "Installing Eclipse IDE and Setting Up Eclipse", "Creating First Java Project in Eclipse IDE", "Variables and Types in Java", "Getting User Input using Java",
            "Math Operators in Java", "Increment Operator and Assignment Operator", "If.. else Statement and Relational Operators",
            "Logical Operators in Java", "The While Statements (while loops)",
            "The Do While Statements (do-while loops)", "Arrays in Java","The For Statement in Java (for loops)",
            "Java String", "Introduction to Methods", "Parameter passing and Returning a Value from a Method ",
            "Object and Classes", "Polymorphism in Java", "Arraylist", "Linkedlist"};
    String[]goals={"13:10","15:03","19:40", "9:57", "12:10", "8:48", "7:10", "8:35", "7:28", "9:37", "6:48"
    , "6:01", "8:40" ,"8:36" , "8:54", "12:41", "15:31", "14:13", "8:33", "10:58", "7:57"};
    int[]images={R.drawable.v1, R.drawable.v2, R.drawable.v3,R.drawable.v4,R.drawable.v5,R.drawable.v6,R.drawable.v7,R.drawable.v8,R.drawable.v9,
            R.drawable.v10,R.drawable.v11, R.drawable.v12, R.drawable.v13, R.drawable.v14, R.drawable.v15, R.drawable.v16,
            R.drawable.v17, R.drawable.v18, R.drawable.v19, R.drawable.v20
    };

    public VideoAdapter(Context ctx)
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
            convertView=inflater.inflate(R.layout.video, null);
        }

        TextView nameTxt = (TextView)convertView.findViewById(R.id.nameTv);
        ImageView img = (ImageView)convertView.findViewById(R.id.imageView1);
        TextView goalsTxt = (TextView)convertView.findViewById(R.id.goalsTv);
        nameTxt.setText(names[pos]);
        goalsTxt.setText(goals[pos]);
        img.setImageResource(images[pos]);
        return convertView;
    }
}
