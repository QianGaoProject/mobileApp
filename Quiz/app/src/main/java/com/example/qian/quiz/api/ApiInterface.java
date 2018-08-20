package com.example.qian.quiz.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("questions/1")
    Call<List<Questions>> getQuestions();
    //Call<List<DataResponse>> getQuestions(@Query("page") int page,@Query("size") int size);
}
/*
* Every method inside an interface represents one possible API call. It must have a HTTP annotation (GET, POST, etc.) to specify the request type and the relative URL. The return value wraps the response in a Call object with the type of the expected result.

Query parameters can also be added to a method.*/