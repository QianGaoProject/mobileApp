package com.example.qian.quiz.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.qian.quiz.model.Tester;

import java.util.ArrayList;
import java.util.List;



public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 5;

    // Database Name
    private static final String DATABASE_NAME = "quiz_db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(Tester.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Tester.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }
    public long insertData(String email,String score) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Tester.COLUMN_EMAIL, email);
        values.put(Tester.COLUMN_SCORE, score);

        // insert row
        long id = db.insert(Tester.TABLE_NAME, null, values);

        // return newly inserted row id
        return id;
    }
    public Tester getData(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Tester.TABLE_NAME,
                new String[]{Tester.COLUMN_ID, Tester.COLUMN_EMAIL, Tester.COLUMN_SCORE},
                Tester.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare  object
        Tester info = new Tester(
                cursor.getInt(cursor.getColumnIndex(Tester.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Tester.COLUMN_EMAIL)),
                cursor.getString(cursor.getColumnIndex(Tester.COLUMN_SCORE)));

        // close db connection
        //db.close();
        cursor.close();
        return info;
    }

    public List<Tester> getAllNotes() {
        List<Tester> testers = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Tester.TABLE_NAME + " ORDER BY " +
                Tester.COLUMN_ID + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Tester t = new Tester();
                t.setId(cursor.getInt(cursor.getColumnIndex(Tester.COLUMN_ID)));
                t.setEmail(cursor.getString(cursor.getColumnIndex(Tester.COLUMN_EMAIL)));
                t.setScore(cursor.getString(cursor.getColumnIndex(Tester.COLUMN_SCORE)));
                testers.add(t);
            } while (cursor.moveToNext());
        }

        cursor.close();
        // return notes list
        return testers;
    }

    public int getTesterCount() {
        String countQuery = "SELECT  * FROM " + Tester.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }
    public int updateData(Tester tester) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Tester.COLUMN_EMAIL, tester.getEmail());
        values.put(Tester.COLUMN_SCORE, tester.getScore());

        // updating row
        return db.update(Tester.TABLE_NAME, values, Tester.COLUMN_ID + " = ?",
                new String[]{String.valueOf(tester.getId())});
    }
    public void deleteNote(Tester tester) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Tester.TABLE_NAME, Tester.COLUMN_ID + " = ?",
                new String[]{String.valueOf(tester.getId())});
        db.close();
    }
}