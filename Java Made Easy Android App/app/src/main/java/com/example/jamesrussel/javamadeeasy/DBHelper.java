package com.example.jamesrussel.javamadeeasy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DBHelper extends SQLiteOpenHelper {

    public static final String GAME_DB = "Game_Databas";
    private static final int VERSION = 1;

    private static final String NAME_KEY ="name" ;
    private static final String SCORE_KEY = "score" ;
    private static final String RANK_KEY = "rank" ;
    private static final String HIGH_SCORE_TABLE = "HighScores" ;
    private static final String PLAYER_TABLE = "Players";
    private static final String RANK_TABLE = "Rank";
    private static final String WHOLE_QUESTION_TABLE = "wholeQuestion";
    private static final String ALL_CATEGORY_TABLE = "allCategories";
    private static final String SPORT_CATEGORY = "CHAPTER 1";
    private static final String MUSIC_CATEGORY ="CHAPTER 2" ;
    private static final String SCIENCE_CATEGORY = "CHAPTER 3";
    private static final String GEOGRAPHY_CATEGORY = "CHAPTER 4";
    private static final String MATH_CATEGORY ="CHAPTER 5" ;
    private static final String Chapter6 ="CHAPTER 6" ;
    private static final String Chapter7 ="CHAPTER 7" ;
    private static final String Chapter8 ="CHAPTER 8" ;
    private static final String Chapter9 ="CHAPTER 9" ;
    private static final String Chapter10 ="CHAPTER 10" ;
   //private static final String GAME_CATEGORY ="Games";

    private static final String ID_KEY = "_id";
    private static final String QUESTION_KEY = "question";
    private static final String ALTERNATIVE1_KEY = "alternative1";
    private static final String ALTERNATIVE2_KEY = "alternative2";
    private static final String ALTERNATIVE3_KEY = "alternative3";
    private static final String ALTERNATIVE4_KEY = "alternative4";
    private static final String CORRECT_ANSWER_KEY = "correctAnswer";
    private static final String TAG= "debug";
    private static final String CATEGORY_KEY = "category";

    private static DBHelper dbHelper = null;
    private SQLiteDatabase db;
    private String sql;
    private Context context =null;


    public static DBHelper getDbHelperInstance(Context context){
        if (dbHelper == null){
            dbHelper = new DBHelper(context);
        }
        return dbHelper;
    }

    private DBHelper(Context context) {
        super(context, GAME_DB, null, VERSION);
        this.context = context;
    }
    /**
     * @return String "name"
     */
    public static String getNameKey() {
        return NAME_KEY;
    }

    /**
     * @return String "_id"
     */
    public static String getIdKey() {
        return ID_KEY;
    }

    /**
     * @return String "score"
     */
    public static String getScoreKey() {
        return SCORE_KEY;
    }

    /**
     * @return String "rank"
     */
    public static String getRankKey() {
        return RANK_KEY;
    }

    /**
     * @return String "Players"
     */
    public static String getPlayerTable() {
        return PLAYER_TABLE;
    }

    /**
     * @return String "allCategories"
     */
    public static String getAllCategoryTable() {
        return ALL_CATEGORY_TABLE;
    }

    /**
     * @return String "Rank"
     */
    public static String getRankTable() {
        return RANK_TABLE;
    }

    /**
     * @return String "wholeQuestion"
     */
    public static String getWholeQuestionTable() {
        return WHOLE_QUESTION_TABLE;
    }

    /**
     * @return String "category"
     */
    public static String getCategoryKey() {
        return CATEGORY_KEY;
    }

    /**
     * @return String "question"
     */
    public static String getQuestionKey() {
        return QUESTION_KEY;
    }

    /**
     * @return String "alternative1"
     */
    public static String getAlternative1Key() {
        return ALTERNATIVE1_KEY;
    }

    /**
     * @return String "alternative2"
     */
    public static String getAlternative2Key() {
        return ALTERNATIVE2_KEY;
    }

    /**
     * @return String "alternative3"
     */
    public static String getAlternative3Key() {
        return ALTERNATIVE3_KEY;
    }

    /**
     * @return String "alternative4"
     */
    public static String getAlternative4Key() {
        return ALTERNATIVE4_KEY;
    }

    /**
     * @return String "correctAnswer"
     */
    public static String getCorrectAnswerKey() {
        return CORRECT_ANSWER_KEY;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        sql = " CREATE TABLE " + ALL_CATEGORY_TABLE + " ( ";
        sql += ID_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT,";
        sql += CATEGORY_KEY + " VARCHAR(225) NOT NULL";
        sql += " );";

        db.execSQL(sql);

        insertCategory(db, SPORT_CATEGORY);
        insertCategory(db, MUSIC_CATEGORY);
        insertCategory(db, SCIENCE_CATEGORY);
        insertCategory(db, GEOGRAPHY_CATEGORY);
       insertCategory(db, MATH_CATEGORY);
        insertCategory(db, Chapter6);
        insertCategory(db, Chapter7);
        insertCategory(db, Chapter8);
        insertCategory(db, Chapter9);
        insertCategory(db, Chapter10);
       // insertCategory(db, GAME_CATEGORY);

        sql = " CREATE TABLE " + HIGH_SCORE_TABLE + " ( ";
        sql += ID_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT,";
        sql += NAME_KEY + " VARCHAR(225) NOT NULL,";
        sql += SCORE_KEY + " INTEGER,";
        sql += ALL_CATEGORY_TABLE + " INTEGER";
        sql += " );";

        db.execSQL(sql);

        sql = " CREATE TABLE " + RANK_TABLE + " ( ";
        sql += ID_KEY + " INTEGER PRIMARY KEY, ";
        sql += RANK_KEY + " INTEGER";
        sql += " );";
        db.execSQL(sql);

        sql = " CREATE TABLE " + PLAYER_TABLE + " ( ";
        sql += ID_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql += NAME_KEY + " VARCHAR(225) NOT NULL ";
        sql += " );";
        db.execSQL(sql);

        // Sets name "Guest" to PLAYER_TABLE as a default name
        ContentValues cvs = new ContentValues();
        cvs.put(NAME_KEY, "Guest");
        db.insert(PLAYER_TABLE, null, cvs);

        sql = " CREATE TABLE " + WHOLE_QUESTION_TABLE + " ( ";
        sql += ID_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql += QUESTION_KEY + " VARCHAR(225) NOT NULL, ";
        sql += ALTERNATIVE1_KEY + " VARCHAR(225), ";
        sql += ALTERNATIVE2_KEY + " VARCHAR(225), ";
        sql += ALTERNATIVE3_KEY + " VARCHAR(225), ";
        sql += ALTERNATIVE4_KEY + " VARCHAR(225), ";
        sql += CORRECT_ANSWER_KEY + " VARCHAR(225) ,";
        sql += ALL_CATEGORY_TABLE + " INTEGER ";
        sql += " );";

        db.execSQL(sql);

        // Sets information to WHOLE_QUESTION_TABLE
        // Sports questions
        addQuestionsToDataBase(db,context.getString(R.string.chapter1_question_1),context.getString(R.string.chapter1_answer_1_1),context.getString(R.string.chapter1_answer_1_2),context.getString(R.string.chapter1_answer_1_3),context.getString(R.string.chapter1_answer_1_4),context.getString(R.string.chapter1_correct_answer_1),1);
        addQuestionsToDataBase(db,context.getString(R.string.chapter1_question_2),context.getString(R.string.chapter1_answer_2_1),context.getString(R.string.chapter1_answer_2_2),context.getString(R.string.chapter1_answer_2_3),context.getString(R.string.chapter1_answer_2_4),context.getString(R.string.chapter1_correct_answer_2),1);
        addQuestionsToDataBase(db,context.getString(R.string.chapter1_question_3),context.getString(R.string.chapter1_answer_3_1),context.getString(R.string.chapter1_answer_3_2),context.getString(R.string.chapter1_answer_3_3),context.getString(R.string.chapter1_answer_3_4),context.getString(R.string.chapter1_correct_answer_3),1);
        addQuestionsToDataBase(db,context.getString(R.string.chapter1_question_4),context.getString(R.string.chapter1_answer_4_1),context.getString(R.string.chapter1_answer_4_2),context.getString(R.string.chapter1_answer_4_3),context.getString(R.string.chapter1_answer_4_4),context.getString(R.string.chapter1_correct_answer_4),1);
        addQuestionsToDataBase(db,context.getString(R.string.chapter1_question_5),context.getString(R.string.chapter1_answer_5_1),context.getString(R.string.chapter1_answer_5_2),context.getString(R.string.chapter1_answer_5_3),context.getString(R.string.chapter1_answer_5_4),context.getString(R.string.chapter1_correct_answer_5),1);
        addQuestionsToDataBase(db,context.getString(R.string.chapter1_question_6),context.getString(R.string.chapter1_answer_6_1),context.getString(R.string.chapter1_answer_6_2),context.getString(R.string.chapter1_answer_6_3),context.getString(R.string.chapter1_answer_6_4),context.getString(R.string.chapter1_correct_answer_6),1);
        addQuestionsToDataBase(db,context.getString(R.string.chapter1_question_7),context.getString(R.string.chapter1_answer_7_1),context.getString(R.string.chapter1_answer_7_2),context.getString(R.string.chapter1_answer_7_3),context.getString(R.string.chapter1_answer_7_4),context.getString(R.string.chapter1_correct_answer_7),1);
        addQuestionsToDataBase(db,context.getString(R.string.chapter1_question_8),context.getString(R.string.chapter1_answer_8_1),context.getString(R.string.chapter1_answer_8_2),context.getString(R.string.chapter1_answer_8_3),context.getString(R.string.chapter1_answer_8_4),context.getString(R.string.chapter1_correct_answer_8),1);
        addQuestionsToDataBase(db,context.getString(R.string.chapter1_question_9),context.getString(R.string.chapter1_answer_9_1),context.getString(R.string.chapter1_answer_9_2),context.getString(R.string.chapter1_answer_9_3),context.getString(R.string.chapter1_answer_9_4),context.getString(R.string.chapter1_correct_answer_9),1);
        addQuestionsToDataBase(db, context.getString(R.string.chapter1_question_10), context.getString(R.string.chapter1_answer_10_1), context.getString(R.string.chapter1_answer_10_2), context.getString(R.string.chapter1_answer_10_3), context.getString(R.string.chapter1_answer_10_4), context.getString(R.string.chapter1_correct_answer_10), 1);


        addQuestionsToDataBase(db,context.getString(R.string.question_science_1),context.getString(R.string.science_answer_1_1),context.getString(R.string.science_answer_1_2),context.getString(R.string.science_answer_1_3),context.getString(R.string.science_answer_1_4),context.getString(R.string.science_correct_answer_1),2);
        addQuestionsToDataBase(db,context.getString(R.string.question_science_2),context.getString(R.string.science_answer_2_1),context.getString(R.string.science_answer_2_2),context.getString(R.string.science_answer_2_3),context.getString(R.string.science_answer_2_4),context.getString(R.string.science_correct_answer_2),2);
        addQuestionsToDataBase(db,context.getString(R.string.question_science_3),context.getString(R.string.science_answer_3_1),context.getString(R.string.science_answer_3_2),context.getString(R.string.science_answer_3_3),context.getString(R.string.science_answer_3_4),context.getString(R.string.science_correct_answer_3),2);
        addQuestionsToDataBase(db,context.getString(R.string.question_science_4),context.getString(R.string.science_answer_4_1),context.getString(R.string.science_answer_4_2),context.getString(R.string.science_answer_4_3),context.getString(R.string.science_answer_4_4),context.getString(R.string.science_correct_answer_4),2);
        addQuestionsToDataBase(db,context.getString(R.string.question_science_5),context.getString(R.string.science_answer_5_1),context.getString(R.string.science_answer_5_2),context.getString(R.string.science_answer_5_3),context.getString(R.string.science_answer_5_4),context.getString(R.string.science_correct_answer_5),2);
        addQuestionsToDataBase(db,context.getString(R.string.question_science_6),context.getString(R.string.science_answer_6_1),context.getString(R.string.science_answer_6_2),context.getString(R.string.science_answer_6_3),context.getString(R.string.science_answer_6_4),context.getString(R.string.science_correct_answer_6),2);
        addQuestionsToDataBase(db,context.getString(R.string.question_science_7),context.getString(R.string.science_answer_7_1),context.getString(R.string.science_answer_7_2),context.getString(R.string.science_answer_7_3),context.getString(R.string.science_answer_7_4),context.getString(R.string.science_correct_answer_7),2);
        addQuestionsToDataBase(db,context.getString(R.string.question_science_8),context.getString(R.string.science_answer_8_1),context.getString(R.string.science_answer_8_2),context.getString(R.string.science_answer_8_3),context.getString(R.string.science_answer_8_4),context.getString(R.string.science_correct_answer_8),2);
        addQuestionsToDataBase(db,context.getString(R.string.question_science_9),context.getString(R.string.science_answer_9_1),context.getString(R.string.science_answer_9_2),context.getString(R.string.science_answer_9_3),context.getString(R.string.science_answer_9_4),context.getString(R.string.science_correct_answer_9),2);
        addQuestionsToDataBase(db,context.getString(R.string.question_science_10),context.getString(R.string.science_answer_10_1),context.getString(R.string.science_answer_10_2),context.getString(R.string.science_answer_10_3),context.getString(R.string.science_answer_10_4),context.getString(R.string.science_correct_answer_10),2);
        addQuestionsToDataBase(db,context.getString(R.string.chapter2_question_11),context.getString(R.string.chapter2_answer_11_1),context.getString(R.string.chapter2_answer_11_2),context.getString(R.string.chapter2_answer_11_3),context.getString(R.string.chapter2_answer_11_4),context.getString(R.string.chapter2_correct_answer_11),2);
        addQuestionsToDataBase(db,context.getString(R.string.chapter2_question_12),context.getString(R.string.chapter2_answer_12_1),context.getString(R.string.chapter2_answer_12_2),context.getString(R.string.chapter2_answer_12_3),context.getString(R.string.chapter2_answer_12_4),context.getString(R.string.chapter2_correct_answer_12),2);
        addQuestionsToDataBase(db,context.getString(R.string.chapter2_question_13),context.getString(R.string.chapter2_answer_13_1),context.getString(R.string.chapter2_answer_13_2),context.getString(R.string.chapter2_answer_13_3),context.getString(R.string.chapter2_answer_13_4),context.getString(R.string.chapter2_correct_answer_13),2);
        addQuestionsToDataBase(db,context.getString(R.string.chapter2_question_14),context.getString(R.string.chapter2_answer_14_1),context.getString(R.string.chapter2_answer_14_2),context.getString(R.string.chapter2_answer_14_3),context.getString(R.string.chapter2_answer_14_4),context.getString(R.string.chapter2_correct_answer_14),2);
        addQuestionsToDataBase(db,context.getString(R.string.chapter2_question_15),context.getString(R.string.chapter2_answer_15_1),context.getString(R.string.chapter2_answer_15_2),context.getString(R.string.chapter2_answer_15_3),context.getString(R.string.chapter2_answer_15_4),context.getString(R.string.chapter2_correct_answer_15),2);
        addQuestionsToDataBase(db,context.getString(R.string.chapter2_question_16),context.getString(R.string.chapter2_answer_16_1),context.getString(R.string.chapter2_answer_16_2),context.getString(R.string.chapter2_answer_16_3),context.getString(R.string.chapter2_answer_16_4),context.getString(R.string.chapter2_correct_answer_16),2);
        addQuestionsToDataBase(db,context.getString(R.string.chapter2_question_17),context.getString(R.string.chapter2_answer_17_1),context.getString(R.string.chapter2_answer_17_2),context.getString(R.string.chapter2_answer_17_3),context.getString(R.string.chapter2_answer_17_4),context.getString(R.string.chapter2_correct_answer_17),2);
        addQuestionsToDataBase(db,context.getString(R.string.chapter2_question_18),context.getString(R.string.chapter2_answer_18_1),context.getString(R.string.chapter2_answer_18_2),context.getString(R.string.chapter2_answer_18_3),context.getString(R.string.chapter2_answer_18_4),context.getString(R.string.chapter2_correct_answer_18),2);
        addQuestionsToDataBase(db,context.getString(R.string.chapter2_question_19),context.getString(R.string.chapter2_answer_19_1),context.getString(R.string.chapter2_answer_19_2),context.getString(R.string.chapter2_answer_19_3),context.getString(R.string.chapter2_answer_19_4),context.getString(R.string.chapter2_correct_answer_19),2);
        addQuestionsToDataBase(db,context.getString(R.string.chapter2_question_20),context.getString(R.string.chapter2_answer_20_1),context.getString(R.string.chapter2_answer_20_2),context.getString(R.string.chapter2_answer_20_3),context.getString(R.string.chapter2_answer_20_4),context.getString(R.string.chapter2_correct_answer_20),2);


        // Chapter3 questions
        addQuestionsToDataBase(db,context.getString(R.string.chapter3_question_1),context.getString(R.string.chapter3_answer_1_1),context.getString(R.string.chapter3_answer_1_2),context.getString(R.string.chapter3_answer_1_3),context.getString(R.string.chapter3_answer_1_4),context.getString(R.string.chapter3_correct_answer_1),3);
        addQuestionsToDataBase(db,context.getString(R.string.chapter3_question_2),context.getString(R.string.chapter3_answer_2_1),context.getString(R.string.chapter3_answer_2_2),context.getString(R.string.chapter3_answer_2_3),context.getString(R.string.chapter3_answer_2_4),context.getString(R.string.chapter3_correct_answer_2),3);
        addQuestionsToDataBase(db,context.getString(R.string.chapter3_question_3),context.getString(R.string.chapter3_answer_3_1),context.getString(R.string.chapter3_answer_3_2),context.getString(R.string.chapter3_answer_3_3),context.getString(R.string.chapter3_answer_3_4),context.getString(R.string.chapter3_correct_answer_3),3);
        addQuestionsToDataBase(db,context.getString(R.string.chapter3_question_4),context.getString(R.string.chapter3_answer_4_1),context.getString(R.string.chapter3_answer_4_2),context.getString(R.string.chapter3_answer_4_3),context.getString(R.string.chapter3_answer_4_4),context.getString(R.string.chapter3_correct_answer_4),3);
        addQuestionsToDataBase(db,context.getString(R.string.chapter3_question_5),context.getString(R.string.chapter3_answer_5_1),context.getString(R.string.chapter3_answer_5_2),context.getString(R.string.chapter3_answer_5_3),context.getString(R.string.chapter3_answer_5_4),context.getString(R.string.chapter3_correct_answer_5),3);
        addQuestionsToDataBase(db,context.getString(R.string.chapter3_question_6),context.getString(R.string.chapter3_answer_6_1),context.getString(R.string.chapter3_answer_6_2),context.getString(R.string.chapter3_answer_6_3),context.getString(R.string.chapter3_answer_6_4),context.getString(R.string.chapter3_correct_answer_6),3);
        addQuestionsToDataBase(db,context.getString(R.string.chapter3_question_7),context.getString(R.string.chapter3_answer_7_1),context.getString(R.string.chapter3_answer_7_2),context.getString(R.string.chapter3_answer_7_3),context.getString(R.string.chapter3_answer_7_4),context.getString(R.string.chapter3_correct_answer_7),3);
        addQuestionsToDataBase(db,context.getString(R.string.chapter3_question_8),context.getString(R.string.chapter3_answer_8_1),context.getString(R.string.chapter3_answer_8_2),context.getString(R.string.chapter3_answer_8_3),context.getString(R.string.chapter3_answer_8_4),context.getString(R.string.chapter3_correct_answer_8),3);
        addQuestionsToDataBase(db,context.getString(R.string.chapter3_question_9),context.getString(R.string.chapter3_answer_9_1),context.getString(R.string.chapter3_answer_9_2),context.getString(R.string.chapter3_answer_9_3),context.getString(R.string.chapter3_answer_9_4),context.getString(R.string.chapter3_correct_answer_9),3);
        addQuestionsToDataBase(db,context.getString(R.string.chapter3_question_10),context.getString(R.string.chapter3_answer_10_1),context.getString(R.string.chapter3_answer_10_2),context.getString(R.string.chapter3_answer_10_3),context.getString(R.string.chapter3_answer_10_4),context.getString(R.string.chapter3_correct_answer_10),3);
        addQuestionsToDataBase(db,context.getString(R.string.chapter3_question_12),context.getString(R.string.chapter3_answer_12_1),context.getString(R.string.chapter3_answer_12_2),context.getString(R.string.chapter3_answer_12_3),context.getString(R.string.chapter3_answer_12_4),context.getString(R.string.chapter3_correct_answer_12),3);
        addQuestionsToDataBase(db,context.getString(R.string.chapter3_question_13),context.getString(R.string.chapter3_answer_13_1),context.getString(R.string.chapter3_answer_13_2),context.getString(R.string.chapter3_answer_13_3),context.getString(R.string.chapter3_answer_13_4),context.getString(R.string.chapter3_correct_answer_13),3);
        addQuestionsToDataBase(db,context.getString(R.string.chapter3_question_14),context.getString(R.string.chapter3_answer_14_1),context.getString(R.string.chapter3_answer_14_2),context.getString(R.string.chapter3_answer_14_3),context.getString(R.string.chapter3_answer_14_4),context.getString(R.string.chapter3_correct_answer_14),3);
        addQuestionsToDataBase(db,context.getString(R.string.chapter3_question_15),context.getString(R.string.chapter3_answer_15_1),context.getString(R.string.chapter3_answer_15_2),context.getString(R.string.chapter3_answer_15_3),context.getString(R.string.chapter3_answer_15_4),context.getString(R.string.chapter3_correct_answer_15),3);
        addQuestionsToDataBase(db,context.getString(R.string.chapter3_question_16),context.getString(R.string.chapter3_answer_16_1),context.getString(R.string.chapter3_answer_16_2),context.getString(R.string.chapter3_answer_16_3),context.getString(R.string.chapter3_answer_16_4),context.getString(R.string.chapter3_correct_answer_16),3);
        addQuestionsToDataBase(db,context.getString(R.string.chapter3_question_17),context.getString(R.string.chapter3_answer_17_1),context.getString(R.string.chapter3_answer_17_2),context.getString(R.string.chapter3_answer_17_3),context.getString(R.string.chapter3_answer_17_4),context.getString(R.string.chapter3_correct_answer_17),3);
        addQuestionsToDataBase(db,context.getString(R.string.chapter3_question_18),context.getString(R.string.chapter3_answer_18_1),context.getString(R.string.chapter3_answer_18_2),context.getString(R.string.chapter3_answer_18_3),context.getString(R.string.chapter3_answer_18_4),context.getString(R.string.chapter3_correct_answer_18),3);
        addQuestionsToDataBase(db,context.getString(R.string.chapter3_question_19),context.getString(R.string.chapter3_answer_19_1),context.getString(R.string.chapter3_answer_19_2),context.getString(R.string.chapter3_answer_19_3),context.getString(R.string.chapter3_answer_19_4),context.getString(R.string.chapter3_correct_answer_19),3);
        addQuestionsToDataBase(db,context.getString(R.string.chapter3_question_20),context.getString(R.string.chapter3_answer_20_1),context.getString(R.string.chapter3_answer_20_2),context.getString(R.string.chapter3_answer_20_3),context.getString(R.string.chapter3_answer_20_4),context.getString(R.string.chapter3_correct_answer_20),3);


        //chapter4
        addQuestionsToDataBase(db,context.getString(R.string.chapter4_question_1),context.getString(R.string.chapter4_answer_1_1),context.getString(R.string.chapter4_answer_1_2),context.getString(R.string.chapter4_answer_1_3),context.getString(R.string.chapter4_answer_1_4),context.getString(R.string.chapter4_correct_answer_1),4);
        addQuestionsToDataBase(db,context.getString(R.string.chapter4_question_2),context.getString(R.string.chapter4_answer_2_1),context.getString(R.string.chapter4_answer_2_2),context.getString(R.string.chapter4_answer_2_3),context.getString(R.string.chapter4_answer_2_4),context.getString(R.string.chapter4_correct_answer_2),4);
        addQuestionsToDataBase(db,context.getString(R.string.chapter4_question_3),context.getString(R.string.chapter4_answer_3_1),context.getString(R.string.chapter4_answer_3_2),context.getString(R.string.chapter4_answer_3_3),context.getString(R.string.chapter4_answer_3_4),context.getString(R.string.chapter4_correct_answer_3),4);
        addQuestionsToDataBase(db,context.getString(R.string.chapter4_question_4),context.getString(R.string.chapter4_answer_4_1),context.getString(R.string.chapter4_answer_4_2),context.getString(R.string.chapter4_answer_4_3),context.getString(R.string.chapter4_answer_4_4),context.getString(R.string.chapter4_correct_answer_4),4);
        addQuestionsToDataBase(db,context.getString(R.string.chapter4_question_5),context.getString(R.string.chapter4_answer_5_1),context.getString(R.string.chapter4_answer_5_2),context.getString(R.string.chapter4_answer_5_3),context.getString(R.string.chapter4_answer_5_4),context.getString(R.string.chapter4_correct_answer_5),4);
        addQuestionsToDataBase(db,context.getString(R.string.chapter4_question_6),context.getString(R.string.chapter4_answer_6_1),context.getString(R.string.chapter4_answer_6_2),context.getString(R.string.chapter4_answer_6_3),context.getString(R.string.chapter4_answer_6_4),context.getString(R.string.chapter4_correct_answer_6),4);
        addQuestionsToDataBase(db,context.getString(R.string.chapter4_question_7),context.getString(R.string.chapter4_answer_7_1),context.getString(R.string.chapter4_answer_7_2),context.getString(R.string.chapter4_answer_7_3),context.getString(R.string.chapter4_answer_7_4),context.getString(R.string.chapter4_correct_answer_7),4);
        addQuestionsToDataBase(db,context.getString(R.string.chapter4_question_8),context.getString(R.string.chapter4_answer_8_1),context.getString(R.string.chapter4_answer_8_2),context.getString(R.string.chapter4_answer_8_3),context.getString(R.string.chapter4_answer_8_4),context.getString(R.string.chapter4_correct_answer_8),4);
        addQuestionsToDataBase(db,context.getString(R.string.chapter4_question_9),context.getString(R.string.chapter4_answer_9_1),context.getString(R.string.chapter4_answer_9_2),context.getString(R.string.chapter4_answer_9_3),context.getString(R.string.chapter4_answer_9_4),context.getString(R.string.chapter4_correct_answer_9),4);
        addQuestionsToDataBase(db,context.getString(R.string.chapter4_question_10),context.getString(R.string.chapter4_answer_10_1),context.getString(R.string.chapter4_answer_10_2),context.getString(R.string.chapter4_answer_10_3),context.getString(R.string.chapter4_answer_10_4),context.getString(R.string.chapter4_correct_answer_10),5);




        //Chapter5 questions
        addQuestionsToDataBase(db,context.getString(R.string.chapter5_question_1),context.getString(R.string.chapter5_answer_1_1),context.getString(R.string.chapter5_answer_1_2),context.getString(R.string.chapter5_answer_1_3),context.getString(R.string.chapter5_answer_1_4),context.getString(R.string.chapter5_correct_answer_1),5);
        addQuestionsToDataBase(db,context.getString(R.string.chapter5_question_2),context.getString(R.string.chapter5_answer_2_1),context.getString(R.string.chapter5_answer_2_2),context.getString(R.string.chapter5_answer_2_3),context.getString(R.string.chapter5_answer_2_4),context.getString(R.string.chapter5_correct_answer_2),5);
        addQuestionsToDataBase(db,context.getString(R.string.chapter5_question_3),context.getString(R.string.chapter5_answer_3_1),context.getString(R.string.chapter5_answer_3_2),context.getString(R.string.chapter5_answer_3_3),context.getString(R.string.chapter5_answer_3_4),context.getString(R.string.chapter5_correct_answer_3),5);
        addQuestionsToDataBase(db,context.getString(R.string.chapter5_question_4),context.getString(R.string.chapter5_answer_4_1),context.getString(R.string.chapter5_answer_4_2),context.getString(R.string.chapter5_answer_4_3),context.getString(R.string.chapter5_answer_4_4),context.getString(R.string.chapter5_correct_answer_4),5);
        addQuestionsToDataBase(db,context.getString(R.string.chapter5_question_5),context.getString(R.string.chapter5_answer_5_1),context.getString(R.string.chapter5_answer_5_2),context.getString(R.string.chapter5_answer_5_3),context.getString(R.string.chapter5_answer_5_4),context.getString(R.string.chapter5_correct_answer_5),5);
        addQuestionsToDataBase(db,context.getString(R.string.chapter5_question_6),context.getString(R.string.chapter5_answer_6_1),context.getString(R.string.chapter5_answer_6_2),context.getString(R.string.chapter5_answer_6_3),context.getString(R.string.chapter5_answer_6_4),context.getString(R.string.chapter5_correct_answer_6),5);
        addQuestionsToDataBase(db,context.getString(R.string.chapter5_question_7),context.getString(R.string.chapter5_answer_7_1),context.getString(R.string.chapter5_answer_7_2),context.getString(R.string.chapter5_answer_7_3),context.getString(R.string.chapter5_answer_7_4),context.getString(R.string.chapter5_correct_answer_7),5);
        addQuestionsToDataBase(db,context.getString(R.string.chapter5_question_8),context.getString(R.string.chapter5_answer_8_1),context.getString(R.string.chapter5_answer_8_2),context.getString(R.string.chapter5_answer_8_3),context.getString(R.string.chapter5_answer_8_4),context.getString(R.string.chapter5_correct_answer_8),5);
        addQuestionsToDataBase(db,context.getString(R.string.chapter5_question_9),context.getString(R.string.chapter5_answer_9_1),context.getString(R.string.chapter5_answer_9_2),context.getString(R.string.chapter5_answer_9_3),context.getString(R.string.chapter5_answer_9_4),context.getString(R.string.chapter5_correct_answer_9),5);
        addQuestionsToDataBase(db,context.getString(R.string.chapter5_question_10),context.getString(R.string.chapter5_answer_10_1),context.getString(R.string.chapter5_answer_10_2),context.getString(R.string.chapter5_answer_10_3),context.getString(R.string.chapter5_answer_10_4),context.getString(R.string.chapter5_correct_answer_10),5);

        //chapter6
        addQuestionsToDataBase(db,context.getString(R.string.chapter6_question_1),context.getString(R.string.chapter6_answer_1_1),context.getString(R.string.chapter6_answer_1_2),context.getString(R.string.chapter6_answer_1_3),context.getString(R.string.chapter6_answer_1_4),context.getString(R.string.chapter6_correct_answer_1),6);
        addQuestionsToDataBase(db,context.getString(R.string.chapter6_question_2),context.getString(R.string.chapter6_answer_2_1),context.getString(R.string.chapter6_answer_2_2),context.getString(R.string.chapter6_answer_2_3),context.getString(R.string.chapter6_answer_2_4),context.getString(R.string.chapter6_correct_answer_2),6);
        addQuestionsToDataBase(db,context.getString(R.string.chapter6_question_3),context.getString(R.string.chapter6_answer_3_1),context.getString(R.string.chapter6_answer_3_2),context.getString(R.string.chapter6_answer_3_3),context.getString(R.string.chapter6_answer_3_4),context.getString(R.string.chapter6_correct_answer_3),6);
        addQuestionsToDataBase(db,context.getString(R.string.chapter6_question_4),context.getString(R.string.chapter6_answer_4_1),context.getString(R.string.chapter6_answer_4_2),context.getString(R.string.chapter6_answer_4_3),context.getString(R.string.chapter6_answer_4_4),context.getString(R.string.chapter6_correct_answer_4),6);
        addQuestionsToDataBase(db,context.getString(R.string.chapter6_question_5),context.getString(R.string.chapter6_answer_5_1),context.getString(R.string.chapter6_answer_5_2),context.getString(R.string.chapter6_answer_5_3),context.getString(R.string.chapter6_answer_5_4),context.getString(R.string.chapter6_correct_answer_5),6);
        addQuestionsToDataBase(db,context.getString(R.string.chapter6_question_6),context.getString(R.string.chapter6_answer_6_1),context.getString(R.string.chapter6_answer_6_2),context.getString(R.string.chapter6_answer_6_3),context.getString(R.string.chapter6_answer_6_4),context.getString(R.string.chapter6_correct_answer_6),6);
        addQuestionsToDataBase(db,context.getString(R.string.chapter6_question_7),context.getString(R.string.chapter6_answer_7_1),context.getString(R.string.chapter6_answer_7_2),context.getString(R.string.chapter6_answer_7_3),context.getString(R.string.chapter6_answer_7_4),context.getString(R.string.chapter6_correct_answer_7),6);
        addQuestionsToDataBase(db,context.getString(R.string.chapter6_question_8),context.getString(R.string.chapter6_answer_8_1),context.getString(R.string.chapter6_answer_8_2),context.getString(R.string.chapter6_answer_8_3),context.getString(R.string.chapter6_answer_8_4),context.getString(R.string.chapter6_correct_answer_8),6);
        addQuestionsToDataBase(db,context.getString(R.string.chapter6_question_9),context.getString(R.string.chapter6_answer_9_1),context.getString(R.string.chapter6_answer_9_2),context.getString(R.string.chapter6_answer_9_3),context.getString(R.string.chapter6_answer_9_4),context.getString(R.string.chapter6_correct_answer_9),6);
        addQuestionsToDataBase(db,context.getString(R.string.chapter6_question_10),context.getString(R.string.chapter6_answer_10_1),context.getString(R.string.chapter6_answer_10_2),context.getString(R.string.chapter6_answer_10_3),context.getString(R.string.chapter6_answer_10_4),context.getString(R.string.chapter6_correct_answer_10),6);

        //chapter7

        //chapter8


        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_1),context.getString(R.string.chapter7_answer_1_1),context.getString(R.string.chapter7_answer_1_2),context.getString(R.string.chapter7_answer_1_3),context.getString(R.string.chapter7_answer_1_4),context.getString(R.string.chapter7_correct_answer_1),7);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_2),context.getString(R.string.chapter7_answer_2_1),context.getString(R.string.chapter7_answer_2_2),context.getString(R.string.chapter7_answer_2_3),context.getString(R.string.chapter7_answer_2_4),context.getString(R.string.chapter7_correct_answer_2),7);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_3),context.getString(R.string.chapter7_answer_3_1),context.getString(R.string.chapter7_answer_3_2),context.getString(R.string.chapter7_answer_3_3),context.getString(R.string.chapter7_answer_3_4),context.getString(R.string.chapter7_correct_answer_3),7);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_4),context.getString(R.string.chapter7_answer_4_1),context.getString(R.string.chapter7_answer_4_2),context.getString(R.string.chapter7_answer_4_3),context.getString(R.string.chapter7_answer_4_4),context.getString(R.string.chapter7_correct_answer_4),7);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_5),context.getString(R.string.chapter7_answer_5_1),context.getString(R.string.chapter7_answer_5_2),context.getString(R.string.chapter7_answer_5_3),context.getString(R.string.chapter7_answer_5_4),context.getString(R.string.chapter7_correct_answer_5),7);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_6),context.getString(R.string.chapter7_answer_6_1),context.getString(R.string.chapter7_answer_6_2),context.getString(R.string.chapter7_answer_6_3),context.getString(R.string.chapter7_answer_6_4),context.getString(R.string.chapter7_correct_answer_6),7);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_7),context.getString(R.string.chapter7_answer_7_1),context.getString(R.string.chapter7_answer_7_2),context.getString(R.string.chapter7_answer_7_3),context.getString(R.string.chapter7_answer_7_4),context.getString(R.string.chapter7_correct_answer_7),7);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_8),context.getString(R.string.chapter7_answer_8_1),context.getString(R.string.chapter7_answer_8_2),context.getString(R.string.chapter7_answer_8_3),context.getString(R.string.chapter7_answer_8_4),context.getString(R.string.chapter7_correct_answer_8),7);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_9),context.getString(R.string.chapter7_answer_9_1),context.getString(R.string.chapter7_answer_9_2),context.getString(R.string.chapter7_answer_9_3),context.getString(R.string.chapter7_answer_9_4),context.getString(R.string.chapter7_correct_answer_9),7);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_10),context.getString(R.string.chapter7_answer_10_1),context.getString(R.string.chapter7_answer_10_2),context.getString(R.string.chapter7_answer_10_3),context.getString(R.string.chapter7_answer_10_4),context.getString(R.string.chapter7_correct_answer_10),7);

        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_1),context.getString(R.string.chapter7_answer_1_1),context.getString(R.string.chapter7_answer_1_2),context.getString(R.string.chapter7_answer_1_3),context.getString(R.string.chapter7_answer_1_4),context.getString(R.string.chapter7_correct_answer_1),8);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_2),context.getString(R.string.chapter7_answer_2_1),context.getString(R.string.chapter7_answer_2_2),context.getString(R.string.chapter7_answer_2_3),context.getString(R.string.chapter7_answer_2_4),context.getString(R.string.chapter7_correct_answer_2),8);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_3),context.getString(R.string.chapter7_answer_3_1),context.getString(R.string.chapter7_answer_3_2),context.getString(R.string.chapter7_answer_3_3),context.getString(R.string.chapter7_answer_3_4),context.getString(R.string.chapter7_correct_answer_3),8);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_4),context.getString(R.string.chapter7_answer_4_1),context.getString(R.string.chapter7_answer_4_2),context.getString(R.string.chapter7_answer_4_3),context.getString(R.string.chapter7_answer_4_4),context.getString(R.string.chapter7_correct_answer_4),8);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_5),context.getString(R.string.chapter7_answer_5_1),context.getString(R.string.chapter7_answer_5_2),context.getString(R.string.chapter7_answer_5_3),context.getString(R.string.chapter7_answer_5_4),context.getString(R.string.chapter7_correct_answer_5),8);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_6),context.getString(R.string.chapter7_answer_6_1),context.getString(R.string.chapter7_answer_6_2),context.getString(R.string.chapter7_answer_6_3),context.getString(R.string.chapter7_answer_6_4),context.getString(R.string.chapter7_correct_answer_6),8);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_7),context.getString(R.string.chapter7_answer_7_1),context.getString(R.string.chapter7_answer_7_2),context.getString(R.string.chapter7_answer_7_3),context.getString(R.string.chapter7_answer_7_4),context.getString(R.string.chapter7_correct_answer_7),8);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_8),context.getString(R.string.chapter7_answer_8_1),context.getString(R.string.chapter7_answer_8_2),context.getString(R.string.chapter7_answer_8_3),context.getString(R.string.chapter7_answer_8_4),context.getString(R.string.chapter7_correct_answer_8),8);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_9),context.getString(R.string.chapter7_answer_9_1),context.getString(R.string.chapter7_answer_9_2),context.getString(R.string.chapter7_answer_9_3),context.getString(R.string.chapter7_answer_9_4),context.getString(R.string.chapter7_correct_answer_9),8);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_10),context.getString(R.string.chapter7_answer_10_1),context.getString(R.string.chapter7_answer_10_2),context.getString(R.string.chapter7_answer_10_3),context.getString(R.string.chapter7_answer_10_4),context.getString(R.string.chapter7_correct_answer_10),8);

        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_1),context.getString(R.string.chapter7_answer_1_1),context.getString(R.string.chapter7_answer_1_2),context.getString(R.string.chapter7_answer_1_3),context.getString(R.string.chapter7_answer_1_4),context.getString(R.string.chapter7_correct_answer_1),9);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_2),context.getString(R.string.chapter7_answer_2_1),context.getString(R.string.chapter7_answer_2_2),context.getString(R.string.chapter7_answer_2_3),context.getString(R.string.chapter7_answer_2_4),context.getString(R.string.chapter7_correct_answer_2),9);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_3),context.getString(R.string.chapter7_answer_3_1),context.getString(R.string.chapter7_answer_3_2),context.getString(R.string.chapter7_answer_3_3),context.getString(R.string.chapter7_answer_3_4),context.getString(R.string.chapter7_correct_answer_3),9);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_4),context.getString(R.string.chapter7_answer_4_1),context.getString(R.string.chapter7_answer_4_2),context.getString(R.string.chapter7_answer_4_3),context.getString(R.string.chapter7_answer_4_4),context.getString(R.string.chapter7_correct_answer_4),9);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_5),context.getString(R.string.chapter7_answer_5_1),context.getString(R.string.chapter7_answer_5_2),context.getString(R.string.chapter7_answer_5_3),context.getString(R.string.chapter7_answer_5_4),context.getString(R.string.chapter7_correct_answer_5),9);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_6),context.getString(R.string.chapter7_answer_6_1),context.getString(R.string.chapter7_answer_6_2),context.getString(R.string.chapter7_answer_6_3),context.getString(R.string.chapter7_answer_6_4),context.getString(R.string.chapter7_correct_answer_6),9);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_7),context.getString(R.string.chapter7_answer_7_1),context.getString(R.string.chapter7_answer_7_2),context.getString(R.string.chapter7_answer_7_3),context.getString(R.string.chapter7_answer_7_4),context.getString(R.string.chapter7_correct_answer_7),9);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_8),context.getString(R.string.chapter7_answer_8_1),context.getString(R.string.chapter7_answer_8_2),context.getString(R.string.chapter7_answer_8_3),context.getString(R.string.chapter7_answer_8_4),context.getString(R.string.chapter7_correct_answer_8),9);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_9),context.getString(R.string.chapter7_answer_9_1),context.getString(R.string.chapter7_answer_9_2),context.getString(R.string.chapter7_answer_9_3),context.getString(R.string.chapter7_answer_9_4),context.getString(R.string.chapter7_correct_answer_9),9);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_10),context.getString(R.string.chapter7_answer_10_1),context.getString(R.string.chapter7_answer_10_2),context.getString(R.string.chapter7_answer_10_3),context.getString(R.string.chapter7_answer_10_4),context.getString(R.string.chapter7_correct_answer_10),9);

        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_1),context.getString(R.string.chapter7_answer_1_1),context.getString(R.string.chapter7_answer_1_2),context.getString(R.string.chapter7_answer_1_3),context.getString(R.string.chapter7_answer_1_4),context.getString(R.string.chapter7_correct_answer_1),10);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_2),context.getString(R.string.chapter7_answer_2_1),context.getString(R.string.chapter7_answer_2_2),context.getString(R.string.chapter7_answer_2_3),context.getString(R.string.chapter7_answer_2_4),context.getString(R.string.chapter7_correct_answer_2),10);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_3),context.getString(R.string.chapter7_answer_3_1),context.getString(R.string.chapter7_answer_3_2),context.getString(R.string.chapter7_answer_3_3),context.getString(R.string.chapter7_answer_3_4),context.getString(R.string.chapter7_correct_answer_3),10);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_4),context.getString(R.string.chapter7_answer_4_1),context.getString(R.string.chapter7_answer_4_2),context.getString(R.string.chapter7_answer_4_3),context.getString(R.string.chapter7_answer_4_4),context.getString(R.string.chapter7_correct_answer_4),10);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_5),context.getString(R.string.chapter7_answer_5_1),context.getString(R.string.chapter7_answer_5_2),context.getString(R.string.chapter7_answer_5_3),context.getString(R.string.chapter7_answer_5_4),context.getString(R.string.chapter7_correct_answer_5),10);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_6),context.getString(R.string.chapter7_answer_6_1),context.getString(R.string.chapter7_answer_6_2),context.getString(R.string.chapter7_answer_6_3),context.getString(R.string.chapter7_answer_6_4),context.getString(R.string.chapter7_correct_answer_6),10);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_7),context.getString(R.string.chapter7_answer_7_1),context.getString(R.string.chapter7_answer_7_2),context.getString(R.string.chapter7_answer_7_3),context.getString(R.string.chapter7_answer_7_4),context.getString(R.string.chapter7_correct_answer_7),10);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_8),context.getString(R.string.chapter7_answer_8_1),context.getString(R.string.chapter7_answer_8_2),context.getString(R.string.chapter7_answer_8_3),context.getString(R.string.chapter7_answer_8_4),context.getString(R.string.chapter7_correct_answer_8),10);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_9),context.getString(R.string.chapter7_answer_9_1),context.getString(R.string.chapter7_answer_9_2),context.getString(R.string.chapter7_answer_9_3),context.getString(R.string.chapter7_answer_9_4),context.getString(R.string.chapter7_correct_answer_9),10);
        addQuestionsToDataBase(db,context.getString(R.string.chapter7_question_10),context.getString(R.string.chapter7_answer_10_1),context.getString(R.string.chapter7_answer_10_2),context.getString(R.string.chapter7_answer_10_3),context.getString(R.string.chapter7_answer_10_4),context.getString(R.string.chapter7_correct_answer_10),10);














    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * adds one question, 4 alternative answers, one correct answer and a category number to the data base.
     * @param db data base to add
     * @param question question
     * @param alt1 alternative 1
     * @param alt2 alternative 2
     * @param alt3 alternative 3
     * @param alt4 alternative 4
     * @param correctAnswer correct answer's number
     * @param category a category number
     */
    public void addQuestionsToDataBase(SQLiteDatabase db,String question,String alt1,String alt2, String alt3,String alt4,String correctAnswer,int category){

        ContentValues cvs = new ContentValues();
        cvs.put(QUESTION_KEY,question);
        cvs.put(ALTERNATIVE1_KEY, alt1);
        cvs.put(ALTERNATIVE2_KEY,alt2);
        cvs.put(ALTERNATIVE3_KEY,alt3);
        cvs.put(ALTERNATIVE4_KEY,alt4);
        cvs.put(CORRECT_ANSWER_KEY, correctAnswer);
        cvs.put(ALL_CATEGORY_TABLE, category);
        db.insert(WHOLE_QUESTION_TABLE, null, cvs);

    }

    /**
     * adds a high score to the data base
     * @param name player's name
     * @param score player's final score
     * @param category game category
     */
    public void addHighScore(String name, int score, int category){
        db = getWritableDatabase();
        ContentValues cvs = new ContentValues();
        cvs.put(NAME_KEY, name);
        cvs.put(SCORE_KEY, score);
        cvs.put(ALL_CATEGORY_TABLE, category);
        db.insert(HIGH_SCORE_TABLE, null, cvs);
    }

    /**
     * retrieves information from HIGH_SCORE_TABLE and returns it as a list of integers.
     * If there is no information in the table yet then it returns a list which includes only one element "0".
     * @return - a list of high scores
     */

    public ArrayList<Integer> getHighScore(String category){
        db= getWritableDatabase();
        ArrayList<Integer> highScores = new ArrayList<Integer>();
        String[] columns={SCORE_KEY,ALL_CATEGORY_TABLE};
        long id = getIdByCategoryName(category);

        String selection = "allCategories=?";
        String[] selectionArgs = {Integer.toString(getIdByCategoryName(category))};

        Cursor cursor;
            if(id==0){
                cursor = db.query(HIGH_SCORE_TABLE, columns, null, null, null, null,"score DESC" );
            } else {
                cursor = db.query(HIGH_SCORE_TABLE, columns, selection, selectionArgs, null, null, "score DESC");
            }

            if(cursor.moveToFirst()){
                int score;
                do{
                    score = cursor.getInt(0);
                    highScores.add(score);

                }while(cursor.moveToNext());
            }else{
                highScores.add(0);
            }
        return highScores;
    }

    /**
     * This method takes a number which you want to check which rank it is in.
     * If there are numbers which are the same then they are the same rank.
     *
     * @param highScore - a list of high scores which is retrieved from the data base.
     * @param finalScore - player's final score. It is checked which rank it is in.
     * @return - the rank
     */
    public int getRank(ArrayList<Integer> highScore, int finalScore){

        ArrayList<Integer> newHighScore = new ArrayList<Integer>();

            for( int i = 0; i < highScore.size(); i++){

                if(!newHighScore.contains(highScore.get(i))){
                    newHighScore.add(highScore.get(i));
                }
            }

        int rank = 1;

            for( int i = 0; i < newHighScore.size(); i++){

                if(newHighScore.get(i) > finalScore){
                    rank++;
                }
            }
        return rank;
    }

    /**
     *
     * @param tableName - a name of the table
     * @return category's cursor
     */
    public Cursor getOneTable(String tableName){
        return getReadableDatabase().query(tableName,null,null,null,null,null,null);
    }

    /**
     * @return cursor for the HIGH_SCORE_TABLE which is sorted by scores
     */
    public Cursor getHighScoreTable(){
        return getReadableDatabase().query(HIGH_SCORE_TABLE,null,null,null,null,null,"score DESC");
    }

    /**
     * adds a player's name to the data base
     * @param name - player's name
     */
    public void addProfile(String name){
        db = getWritableDatabase();
        ContentValues cvs = new ContentValues();
        cvs.put(NAME_KEY,name);
        db.insert(PLAYER_TABLE, null, cvs);
        db.close();
    }

    /**
     * choose one category, and the cursor points at the information only in that category in WHOLE_QUESTION_TABLE
     * @param category category to choose
     * @return the cursor which is selected by category
     */
    public Cursor getCursorForOnesCategory(String category){
        db= getWritableDatabase();
        String selection = "allCategories=?";
        String[] selectionArgs={Integer.toString(getIdByCategoryName(category))};
        Cursor cursor = db.query(WHOLE_QUESTION_TABLE, null, selection, selectionArgs, null, null, null);
        return cursor;
    }

    /**
     * choose one category, and the cursor points at the information only in that category in HIGH_SCORE_TABLE
     * @param category category to choose
     * @return cursor
     */
    public Cursor getCategorisedTable(String category) {
        db= getWritableDatabase();
        String selection = "allCategories=?";
        String[] selectionArgs={Integer.toString(getIdByCategoryName(category))};
        Cursor cursor = db.query(HIGH_SCORE_TABLE, null, selection, selectionArgs, null, null, "score DESC");
        return cursor;
    }

    /**
     * choose one category, and this method counts how many questions there are in that category
     * @param category category to choose
     * @return length of questions
     */
    public int getLengthOfQuestions(String category){
        db = getReadableDatabase();
        Cursor cursor = getCursorForOnesCategory(category);
        int lengthOfQuestions = 0;

        if(cursor.moveToFirst()){
            do{
                lengthOfQuestions++;

            } while(cursor.moveToNext());
        }
        return lengthOfQuestions;
    }

    /**
     * choose one category, and this method returns a list of instances of QuestionQuiz in that category
     * @param categoryID category's ID number
     * @return list of instances of QuestionQuiz
     */
    public ArrayList<QuestionQuiz> getRandomFiveQuestions(int categoryID){

        db= getWritableDatabase();
        ArrayList<QuestionQuiz> questionQuizs = new ArrayList<QuestionQuiz>();

        String selection = "allCategories=?";
        String[] selectionArgs={Integer.toString(categoryID)};

        Cursor cursor;

        if(categoryID ==0){
            cursor = db.query(WHOLE_QUESTION_TABLE, null, null, null, null, null, "RANDOM() LIMIT 10");
        } else {
            cursor = db.query(WHOLE_QUESTION_TABLE, null, selection, selectionArgs, null, null, "RANDOM() LIMIT 10");
        }

        if(cursor.moveToFirst()){

            String question;
            String alternativeA;
            String alternativeB;
            String alternativeC;
            String alternativeD;
            String correctAnswer;
            String category;

            do{
                question = cursor.getString(1);
                alternativeA = cursor.getString(2);
                alternativeB =cursor.getString(3);
                alternativeC = cursor.getString(4);
                alternativeD = cursor.getString(5);
                correctAnswer = cursor.getString(6);
                category= getCategoryByID(cursor.getInt(7));

                questionQuizs.add(new QuestionQuiz(category,question,alternativeA,alternativeB,alternativeC,alternativeD,correctAnswer));

            }while(cursor.moveToNext());
        }
        db.close();
        return questionQuizs;
    }

    /**
     * gets category's name by category's ID
     *
     * @param categoryID category's ID
     * @return category's name
     */
    public String getCategoryByID(int categoryID){

        db = getReadableDatabase();
        String category = null;
        String selection = "_id=?";
        String[] selectionArgs={Integer.toString(categoryID)};

        Cursor cursor = db.query(ALL_CATEGORY_TABLE, null,selection, selectionArgs, null, null,null);

        if(cursor.moveToFirst()){
            do{
                category = cursor.getString(1);
            }while(cursor.moveToNext());
        }
        db.close();
        return category;
    }

    /**
     * gets category's ID by category's name
     * @param category category's name
     * @return category's ID
     */
    public int getIdByCategoryName(String category){

        db = getReadableDatabase();
        int categoryId=0;
        String selection = "category=?";
        String[] selectionArgs={category};

        Cursor cursor = db.query(ALL_CATEGORY_TABLE, null,selection, selectionArgs, null, null,null);

        if(cursor.moveToFirst()){
            do{
                categoryId = cursor.getInt(0);
            }while(cursor.moveToNext());
        }
        return categoryId;
    }

    /**
     * adds category's name to the ALL_CATEGORY_TABLE in the data base.
     * @param db the data base to add
     * @param category category's name
     */
    public void insertCategory(SQLiteDatabase db, String category){
        ContentValues cvs = new ContentValues();
        cvs.put(CATEGORY_KEY, category);
        db.insert(ALL_CATEGORY_TABLE, null, cvs);
    }

    /**
     * adds rank to the RANK_TABLE
     * @param rank -rank to add
     */
    public void insertRank(int rank){
        ContentValues cvs = new ContentValues();
        cvs.put(RANK_KEY, rank);
        db.insert(RANK_TABLE, null, cvs);
    }

    /**
     * deletes name from the PLAYER_TABLE
     * @param name -name to delete
     */
    public void deleteProfile(String name) {
        db = getWritableDatabase();
        String selection = "name=?";
        String[] selectionArgs = {name};
        db.delete(PLAYER_TABLE, selection, selectionArgs);
        db.close();
    }

    /**
     * choose one category, and this method deletes information in that category from WHOLE_QUESTION_TABLE
     * and that category from ALL_CATEGORY_TABLE
     * @param category - category to choose
     */
    public void deleteCategory(String category){
        db = getWritableDatabase();

        String[] selectionArg = new String[]{Integer.toString(getIdByCategoryName(category))};
        db.delete(WHOLE_QUESTION_TABLE,"allCategories=?",selectionArg);

        String[] selectionArgs = new String[]{category};
        db.delete(ALL_CATEGORY_TABLE, "category=?", selectionArgs);

        db.close();
    }

    /**
     * deletes rank and id from RANK_TABLE
     */
    public void deleteRank() {
        db = getWritableDatabase();
        db.delete(RANK_TABLE, RANK_KEY, null);
        db.delete(RANK_TABLE, ID_KEY, null);
    }

    /**
     * deletes one question from the WHOLE_QUESTION_TABLE
     * @param ID question's unique ID
     */
    public void deleteQuestion(String ID){
        db = getWritableDatabase();
        String[] selectionArg = {ID};
        db.delete(WHOLE_QUESTION_TABLE, "_id=?", selectionArg);
    }

}
