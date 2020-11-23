package com.example.myquizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myquizapp.adapters.QuizAdapter;

public class QuizActivity extends AppCompatActivity {
    private  QuizViewModel viewModel;
    private RecyclerView recyclerQuestions;
    private QuizAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        viewModel = ViewModelProviders.of(this).get(QuizViewModel.class);

    }
}