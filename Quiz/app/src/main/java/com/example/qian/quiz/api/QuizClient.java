package com.example.qian.quiz.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface QuizClient {
    @GET("/questions")
    Call<List<Quiz>> quizForUser(@Query("page") int page, @Query("size") int size);

}
//Call is Retrofit hides this async form us , but we need to wrap our return into a call<> object.
/*
* Every method inside an interface represents one possible API call. It must have a HTTP annotation (GET, POST, etc.) to specify the request type and the relative URL. The return value wraps the response in a Call object with the type of the expected result.

Query parameters can also be added to a method.*/
//questions?page=2&size=3

//https://www.youtube.com/watch?v=1JGcsLZKaj4