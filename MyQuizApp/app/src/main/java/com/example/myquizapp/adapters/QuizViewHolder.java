package com.example.myquizapp.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myquizapp.R;
import com.example.myquizapp.data.models.QuizModel;

public class QuizViewHolder extends RecyclerView.ViewHolder {
TextView questionTxt;
    public QuizViewHolder(@NonNull View itemView) {
        super(itemView);
        questionTxt=itemView.findViewById(R.id.question_txt);
    }

    public void onBind(QuizModel quizModel) {
        questionTxt.setText(quizModel.getQuestion());
    }
}
