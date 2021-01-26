package com.example.lesson_.authentification;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lesson_.R;
public class StoreDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "registration.db";
    private static final int DATABASE_VERSION = 2;

    public static final String TABLE_STUDENTS = "students";
    public static final String TABLE_GROUPS = "user_groups";
    private static final String TABLE_LANGUAGE ="languages";

    public static final String COLUMN_INFO = "user_full_name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_GROUP_ID = "group_id";

    public static final String COLUMN_GINFO = "group_name";
    public static final String COLUMN_SUM = "group_sum";
    private static final String COLUMN_LANGUAGE ="group_language";
    private static final String COLUMN_LANGUAGE_ID ="group_language_id";

    Context context;

    public StoreDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_STUDENTS + "(" +
                COLUMN_INFO + "TEXT, " +
                COLUMN_EMAIL + "TEXT, " +
                COLUMN_GROUP_ID + "TEXT, " +
                COLUMN_PASSWORD + "TEXT )");

        db.execSQL("CREATE TABLE " + TABLE_GROUPS + "(" +
                COLUMN_INFO + "TEXT, " +
                COLUMN_SUM + "INTEGER, " +
                COLUMN_GROUP_ID + "TEXT )");

        db.execSQL("CREATE TABLE CITY" + TABLE_LANGUAGE + "("+
                COLUMN_LANGUAGE_ID + "TEXT," +

                COLUMN_LANGUAGE+"TEXT)");
        initGroups(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GROUPS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LANGUAGE);

        onCreate(db);
    }

    public void initGroups(SQLiteDatabase db){
        ContentValues group1 = new ContentValues();
        group1.put(COLUMN_INFO, "IT");
        group1.put(COLUMN_SUM, 25);
        group1.put(COLUMN_GROUP_ID, "3E");
        db.insert(TABLE_GROUPS, null, group1);

        ContentValues group2 = new ContentValues();
        group2.put(COLUMN_INFO, "IT");
        group2.put(COLUMN_SUM, 24);
        group2.put(COLUMN_GROUP_ID, "2F");
        db.insert(TABLE_GROUPS, null, group2);

        ContentValues group3 = new ContentValues();
        group3.put(COLUMN_INFO, "IT");
        group3.put(COLUMN_SUM, 24);
        group3.put(COLUMN_GROUP_ID, "1F");
        db.insert(TABLE_GROUPS, null, group3);
    }

    public void initlanguage(SQLiteDatabase db){
        ContentValues language1 = new ContentValues();
        language1.put(COLUMN_LANGUAGE, "language1");
        language1.put(COLUMN_LANGUAGE_ID, "kazakh");

        db.insert(TABLE_LANGUAGE,null,language1);

        ContentValues language2 = new ContentValues();
        language2.put(COLUMN_LANGUAGE, "language2");
        language2.put(COLUMN_LANGUAGE_ID, "russian");

        db.insert(TABLE_LANGUAGE,null,language2);

        ContentValues language3 = new ContentValues();
        language3.put(COLUMN_LANGUAGE, "language3");
        language3.put(COLUMN_LANGUAGE_ID, "english");

        db.insert(TABLE_LANGUAGE,null,language3);}
}