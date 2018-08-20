package com.example.qian.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
//    ImageView iv;
    int x,y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         tv= findViewById(R.id.tv1);
//         iv=findViewById(R.id.iv);

    }
    public void onButtonClick(View v){
     x++;
     y++;
        tv.setText("width "+tv.getMeasuredWidth()+" Height "+tv.getMeasuredHeight()) ;
        //tv.setText("width "+tv.getWidth()+" Height "+tv.getHeight()) ;
tv.setPadding(x,x,y,y);
tv.post(new Runnable() {
    @Override
    public void run() {
        int w = tv.getMeasuredWidth();
        int h = tv.getMeasuredHeight();


    }


}
