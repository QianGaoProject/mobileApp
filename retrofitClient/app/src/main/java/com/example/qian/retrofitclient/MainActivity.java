package com.example.qian.retrofitclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         recyclerView=findViewById(R.id.results);

        Retrofit.Builder builder =new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

          GitHubClient client =retrofit.create(GitHubClient.class);
          Call<List<GitHubRepo>> call= client.reposForUser("QianGaoProject");

          call.enqueue(new Callback<List<GitHubRepo>>() {
              @Override
              public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                  List<GitHubRepo> repos = response.body();
                  recyclerView.setAdapter(new TesterAdapter(repos));
                  recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
              }

              @Override
              public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                  Toast.makeText(MainActivity.this,"error :(",Toast.LENGTH_SHORT).show();
              }
          });
    }
}
