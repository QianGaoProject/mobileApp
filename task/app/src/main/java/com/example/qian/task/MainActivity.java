package com.example.qian.task;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void getData(View view){
        Toast.makeText(this,"Button Created",Toast.LENGTH_LONG).show();
        URL apiUrl;
        try {
            apiUrl=new URL("https://jsonplaceholder.typicode.com/todos/1");
            new FetchDataFromApi().execute(apiUrl);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }

    }

    public class FetchDataFromApi extends AsyncTask<URL,Void,String> {

        @Override
        protected String doInBackground(URL... urls) {
            URL myUrl = urls[0];
            String response = "";
            try {
                response = NetworkUtility.getResponseFromHttpUrl(myUrl);
                return response;
            } catch (IOException e) {
                e.printStackTrace();
                TextView tv=findViewById(R.id.tvResult);
                tv.setText(e.getMessage());
            }
            return response;
        }
        @Override
        protected void onPostExecute(String s){
            TextView tv=findViewById(R.id.tvResult);
            tv.setText(s);
        }
    }

    public void startSecondActicity(View view){
      Intent intentToStartActivity= new Intent(MainActivity.this,Main2Activity.class);
      intentToStartActivity.putExtra(Intent.EXTRA_TEXT,"Sent from main Activit!");
      startActivity(intentToStartActivity);
    }
    public void startSecondActivityWithResult(View view){
        Intent i=new Intent(this,Main2Activity.class);

    }
    public void startWebpageActivity(View view){
        Uri uri=Uri.parse("http://www.johnabbott.qc.ca/");
        Intent openWebpageIntent= new Intent(Intent.ACTION_VIEW,uri);
        if(openWebpageIntent.resolveActivity(getPackageManager())!=null)
        startActivity(openWebpageIntent);
    }
}
