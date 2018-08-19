package com.example.qian.quiz.model;

import com.google.gson.annotations.SerializedName;

public class Questions {
    @SerializedName("id")
    private Long id;
    @SerializedName("question")
    private String question;
    @SerializedName("answer")
    private String answer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
