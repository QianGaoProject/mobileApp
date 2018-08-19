package com.example.qian.day6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Qian on 15/08/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Information_db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(Information.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Information.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }
    public long insertData(String name,String address, String phone) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Information.COLUMN_NAME, name);
        values.put(Information.COLUMN_ADDRESS, address);
        values.put(Information.COLUMN_PHONE, phone);

        // insert row
        long id = db.insert(Information.TABLE_NAME, null, values);
        // close db connection
       // db.close();

        // return newly inserted row id
        return id;
    }
    public Information getData(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Information.TABLE_NAME,
                new String[]{Information.COLUMN_ID, Information.COLUMN_NAME, Information.COLUMN_ADDRESS,Information.COLUMN_PHONE},
                Information.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare  object
        Information info = new Information(
                cursor.getInt(cursor.getColumnIndex(Information.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Information.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndex(Information.COLUMN_ADDRESS)),
                cursor.getString(cursor.getColumnIndex(Information.COLUMN_PHONE)));

        // close db connection
        db.close();

        return info;
    }

    public List<Information> getAllNotes() {
        List<Information> informations = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Information.TABLE_NAME + " ORDER BY " +
                Information.COLUMN_ID + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Information information = new Information();
                information.setId(cursor.getInt(cursor.getColumnIndex(Information.COLUMN_ID)));
                information.setName(cursor.getString(cursor.getColumnIndex(Information.COLUMN_NAME)));
                information.setAddress(cursor.getString(cursor.getColumnIndex(Information.COLUMN_ADDRESS)));
                information.setPhone(cursor.getString(cursor.getColumnIndex(Information.COLUMN_PHONE)));
                informations.add(information);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return informations;
    }

    public int getNotesCount() {
        String countQuery = "SELECT  * FROM " + Information.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }
    public int updateData(Information info) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Information.COLUMN_NAME, info.getName());
        values.put(Information.COLUMN_ADDRESS, info.getAddress());
        values.put(Information.COLUMN_PHONE, info.getPhone());

        // updating row
        return db.update(Information.TABLE_NAME, values, Information.COLUMN_ID + " = ?",
                new String[]{String.valueOf(info.getId())});
    }
    public void deleteNote(Information info) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Information.TABLE_NAME, Information.COLUMN_ID + " = ?",
                new String[]{String.valueOf(info.getId())});
        db.close();
    }
}