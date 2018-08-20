package com.example.qian.quiz.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.qian.quiz.R;
import com.example.qian.quiz.adapter.QuestionAdapter;
import com.example.qian.quiz.api.Quiz;
import com.example.qian.quiz.api.QuizClient;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuestionActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    private int pageNumber =1;
    private int pageSize =5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);


        progressBar=findViewById(R.id.showProgressBar);
        progressBar.setVisibility(View.VISIBLE);

        recyclerView =findViewById(R.id.resultsQuestion);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //api
        Retrofit.Builder builder =new Retrofit.Builder()
                .baseUrl("http://192.168.0.180:8080/mobile/webapi/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        QuizClient client =retrofit.create(QuizClient.class);
        Call<List<Quiz>> call= client.quizForUser(pageNumber,pageSize);

        call.enqueue(new Callback<List<Quiz>>() {
            @Override
            public void onResponse(Call<List<Quiz>> call, Response<List<Quiz>> response) {
                 Log.d("RetrofitExample", response.body().toString());
                 List<Quiz> quizzes = response.body();
                recyclerView.setAdapter(new QuestionAdapter(quizzes));
                recyclerView.setLayoutManager(new LinearLayoutManager(QuestionActivity.this));
            }

            @Override
            public void onFailure(Call<List<Quiz>> call, Throwable t) {
                Toast.makeText(QuestionActivity.this,"error :(",Toast.LENGTH_SHORT).show();
            }
        });
    }

//    private void performPagination(){
//        Call<List<DataResponse>> call = apiInterface.getQuestions(pageNumber,pageSize);
//        call.enqueue(new Callback<List<DataResponse>>() {
//            @Override
//            public void onResponse(Call<List<DataResponse>> call, Response<List<DataResponse>> response) {
//                List<Questions> questions = response.body().get(0).getQustions();
//                adapter = new QuestionAdapter(questions);
//                recyclerView.setAdapter(adapter);
//                Toast.makeText(QuestionActivity.this,"First page is loaded...",Toast.LENGTH_SHORT).show();
//                progressBar.setVisibility(View.GONE);
//            }
//
//            @Override
//            public void onFailure(Call<List<DataResponse>> call, Throwable t) {
//
//            }
//        });
//    }

    public void onButtonClickSave(View v) {

        MainActivity.db.insertData("", "");
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
            intentToStartQuiz = new Intent(QuestionActivity.this, MainActivity.class);
        } else {
            intentToStartQuiz = new Intent(QuestionActivity.this, QuestionActivity.class);
        }
        startActivity(intentToStartQuiz);
    }

    public void showHistory() {
        Intent intentToShowHistory = new Intent(QuestionActivity.this, HistoryActivity.class);
        startActivity(intentToShowHistory);
    }
}
