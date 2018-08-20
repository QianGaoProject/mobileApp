package com.example.qian.quiz.model;

import com.google.gson.annotations.SerializedName;

public class Question{

    @SerializedName("id")
    private Long id;
    @SerializedName("question")
    private String question;
    //@SerializedName("answer")
    // private String answer;

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }


}
