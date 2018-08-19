package com.example.qian.quiz.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qian.quiz.R;
import com.example.qian.quiz.database.DatabaseHelper;
import com.facebook.stetho.Stetho;

public class MainActivity extends AppCompatActivity {
    public static EditText emailValidate;
    public static DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Stetho.initializeWithDefaults(this);
        db = new DatabaseHelper(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean checkEmail() {
        emailValidate = findViewById(R.id.etEmail);
        String email = emailValidate.getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (!email.matches(emailPattern)) {
            Toast toast = Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return false;
        }
        return true;
    }

    public void onClick(View v) {
        if (!checkEmail()) {
            return;
        }
        newQuiz();
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
        if (!checkEmail()) {
            return;
        }
        Intent intentToStartQuiz = new Intent(MainActivity.this, QuestionActivity.class);
        startActivity(intentToStartQuiz);
    }

    public void showHistory() {
        Intent intentToShowHistory = new Intent(MainActivity.this, HistoryActivity.class);
        startActivity(intentToShowHistory);
    }
    public void onDestroy() {
        db.close();
        super.onDestroy();
    }
}
