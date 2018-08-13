package com.example.qian.day4tast1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView childTv=findViewById(R.id.child_tv);
        Intent intentReceived=getIntent();
        if(intentReceived.hasExtra(Intent.EXTRA_TEXT)){
            String stringRecieved=intentReceived.getStringExtra(Intent.EXTRA_TEXT);
            childTv.setText(stringRecieved);
        }
    }
}
