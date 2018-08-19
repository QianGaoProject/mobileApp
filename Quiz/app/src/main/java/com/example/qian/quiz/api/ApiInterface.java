package com.example.qian.quiz.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("questions")
    Call<List<DataResponse>> getQuestions(@Query("page") int page,@Query("size") int size);
}
