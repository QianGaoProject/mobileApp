package com.example.qian.quiz.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataResponse {
    @SerializedName("")
    private List<Question> questions;

    public List<Question> getQuestions() {
        return questions;
    }
}
