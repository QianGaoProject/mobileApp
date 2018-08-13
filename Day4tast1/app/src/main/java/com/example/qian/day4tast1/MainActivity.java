package com.example.qian.day4tast1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int selectedItemId=item.getItemId();
        switch (selectedItemId){
            case R.id.openItsLocationOnTheMap:
            {
                openItsLocationOnTheMap();
                return true;
            }
            case R.id.openTheOfficialWebside:
            {
                openTheOfficialWebside();
                return true;
            }
            case R.id.displayPageThatGivesInformationAboutTheCollege:{
                displayPageThatGivesInformationAboutTheCollege();
                return true;
            }
            default: return super.onOptionsItemSelected(item);
        }

    }
    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void openItsLocationOnTheMap(){
 showMap(Uri.parse("geo:45.4060,-73.9419"));
    }
    public void openTheOfficialWebside(){
       Uri uri= Uri.parse("http://www.johnabbott.qc.ca/");
       Intent openWebItent =new Intent(Intent.ACTION_VIEW,uri);
       if(openWebItent.resolveActivity(getPackageManager())!=null){
           startActivity(openWebItent);
       }
    }
    public void displayPageThatGivesInformationAboutTheCollege(){
        String info = getResources().getString(R.string.officialInfo);
        Intent intentToStartActivity= new Intent(MainActivity.this,Main3Activity.class);
        intentToStartActivity.putExtra(Intent.EXTRA_TEXT,info);
        startActivity(intentToStartActivity);
    }
}
