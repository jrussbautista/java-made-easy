package com.example.jamesrussel.javamadeeasy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class GlossaryRepo {
    private MyDBHelper myDbHelper;

    public GlossaryRepo(Context context) {
        myDbHelper = new MyDBHelper(context);
    }

    public int insert(GlossaryDescription glossaryDescription) {


        SQLiteDatabase db = myDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(GlossaryDescription.KEY_age, glossaryDescription.age);
        values.put(GlossaryDescription.KEY_email, glossaryDescription.email);
        values.put(GlossaryDescription.KEY_name, glossaryDescription.name);

        long student_Id = db.insert(GlossaryDescription.TABLE, null, values);
        db.close();
        return (int) student_Id;
    }
    public Cursor  getStudentList() {
        SQLiteDatabase db = myDbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  rowid as " +
                GlossaryDescription.KEY_ROWID + "," +
                GlossaryDescription.KEY_ID + "," +
                GlossaryDescription.KEY_name + "," +
                GlossaryDescription.KEY_email + "," +
                GlossaryDescription.KEY_age +
                " FROM " + GlossaryDescription.TABLE;


        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return cursor;


    }


    public Cursor  getStudentListByKeyword(String search) {
        //Open connection to read only
        SQLiteDatabase db = myDbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  rowid as " +
                GlossaryDescription.KEY_ROWID + "," +
                GlossaryDescription.KEY_ID + "," +
                GlossaryDescription.KEY_name + "," +
                GlossaryDescription.KEY_email + "," +
                GlossaryDescription.KEY_age +
                " FROM " + GlossaryDescription.TABLE +
                " WHERE " +  GlossaryDescription.KEY_name + "  LIKE  '%" +search + "%' "
                ;


        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return cursor;


    }

    public GlossaryDescription getStudentById(int Id){
        SQLiteDatabase db = myDbHelper.getReadableDatabase();
        String selectQuery =  "SELECT " +
                GlossaryDescription.KEY_ID + "," +
                GlossaryDescription.KEY_name + "," +
                GlossaryDescription.KEY_email + "," +
                GlossaryDescription.KEY_age +
                " FROM " + GlossaryDescription.TABLE
                + " WHERE " +
                GlossaryDescription.KEY_ID + "=?";//

        int iCount =0;
        GlossaryDescription glossaryDescription = new GlossaryDescription();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                glossaryDescription.student_ID =cursor.getInt(cursor.getColumnIndex(GlossaryDescription.KEY_ID));
                glossaryDescription.name =cursor.getString(cursor.getColumnIndex(GlossaryDescription.KEY_name));
                glossaryDescription.email  =cursor.getString(cursor.getColumnIndex(GlossaryDescription.KEY_email));
                glossaryDescription.age =cursor.getInt(cursor.getColumnIndex(GlossaryDescription.KEY_age));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return glossaryDescription;
    }




}