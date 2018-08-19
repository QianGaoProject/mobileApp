package com.example.qian.quiz.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qian.quiz.R;
import com.example.qian.quiz.model.Questions;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.viewHolder> {
    private List<Questions> questionsList;

    public QuestionAdapter(List<Questions> questionsList) {
        this.questionsList = questionsList;

    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.per_item_question, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Questions question = questionsList.get(position);
        holder.tv.setText("" + question.getId() + ". " + question.getQuestion());
    }

    @Override
    public int getItemCount() {
        return questionsList.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_in_item);
        }
    }

    //pagination
    public void addQuestions(List<Questions> questions) {
        for (Questions q : questions) {
             questionsList.add(q);
        }
    }
}
