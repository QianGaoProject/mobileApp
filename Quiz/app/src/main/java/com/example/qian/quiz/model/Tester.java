package com.example.qian.quiz.model;

public class Tester {
    public Tester() {
    }
    public Tester(long id, String email, String score){
        this.setId(id);
        this.setEmail(email);
        this.setScore(score);
    }


    // Create table SQL query
    public static final String TABLE_NAME ="tester";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_SCORE ="score";
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_EMAIL + " TEXT,"
                    + COLUMN_SCORE + " TEXT)";



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    private long id;
    private String email;
    private String score;
}
