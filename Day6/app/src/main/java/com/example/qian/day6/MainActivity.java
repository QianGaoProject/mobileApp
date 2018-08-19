package com.example.qian.day6;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.stetho.Stetho;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Stetho.initializeWithDefaults(this);
         db =new DatabaseHelper(this);


    }


    public void onButtonClickSave(View v){

        EditText e1= findViewById(R.id.etName);
        EditText e2 =findViewById(R.id.etAddress);
        EditText e3 =findViewById(R.id.etPhone);
        db.insertData(e1.getText().toString(),
                e2.getText().toString(),
                e3.getText().toString());
    }
    public void onButtonClickShowAll(View v){

        RecyclerView myReView =findViewById(R.id.result);
        InformationAdapter informationAdapter=new InformationAdapter(db.getAllNotes());
        myReView.setAdapter(informationAdapter);
        myReView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void onDestroy(){
        db.close();
        super.onDestroy();
    }



}
