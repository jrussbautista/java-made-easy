package com.example.jamesrussel.javamadeeasy;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;


    private static final String DATABASE_NAME = "searchwidget.db";

    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String CREATE_TABLE_STUDENT = "CREATE TABLE " + GlossaryDescription.TABLE  + "("
                + GlossaryDescription.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + GlossaryDescription.KEY_name + " TEXT, "
                + GlossaryDescription.KEY_age + " INTEGER, "
                + GlossaryDescription.KEY_email + " TEXT )";

        db.execSQL(CREATE_TABLE_STUDENT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + GlossaryDescription.TABLE);
        onCreate(db);

    }

}