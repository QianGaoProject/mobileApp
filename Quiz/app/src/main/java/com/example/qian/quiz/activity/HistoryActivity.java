package com.example.qian.quiz.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.qian.quiz.R;
import com.example.qian.quiz.adapter.TesterAdapter;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        //get data from SQlite
        try {
            RecyclerView myReView = findViewById(R.id.results);
            TesterAdapter testerAdapter = new TesterAdapter(MainActivity.db.getAllNotes());
            myReView.setAdapter(testerAdapter);
            myReView.setLayoutManager(new LinearLayoutManager(this));
        }catch (Exception e){
            Toast toast = Toast.makeText(HistoryActivity.this, "Database Error: no found table", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle item selection
        switch (item.getItemId()) {
            case R.id.startNewQuiz:
                newQuiz();
                return true;
            case R.id.quizHistory:
                showHistory();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void newQuiz() {

        Intent intentToStartQuiz;
        if (MainActivity.emailValidate == null
                || !MainActivity.emailValidate.getText().toString().trim().matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
            // goes to main activity
            intentToStartQuiz = new Intent(HistoryActivity.this, MainActivity.class);
        } else {
            intentToStartQuiz = new Intent(HistoryActivity.this, QuestionActivity.class);
        }
        startActivity(intentToStartQuiz);
    }

    public void showHistory() {
        Intent intentToShowHistory = new Intent(HistoryActivity.this, HistoryActivity.class);
        startActivity(intentToShowHistory);
    }
}
