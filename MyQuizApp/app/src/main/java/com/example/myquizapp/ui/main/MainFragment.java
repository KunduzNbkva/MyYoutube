package com.example.myquizapp.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myquizapp.QuizActivity;
import com.example.myquizapp.R;
import com.example.myquizapp.core.SimpleOnSeekBarChangeListener;

public class MainFragment extends Fragment {
    private static final String EXTRA_AMOUNT = "amount";
    private static final String EXTRA_DIFFICULTY = "difficulty";
    private static final String EXTRA_CATEGORY = "category";
    private TextView questionsAmountTxt, countText;
    private SeekBar questionsSeekbar;
    private Spinner categoriesSpinner, difficultySpinner;
    private MainViewModel mViewModel;
    private Button plus, minus, startBtn;
    private int category;
    private String difficulty;


    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        categoriesSpinner = view.findViewById(R.id.categories_spinner);
        difficultySpinner = view.findViewById(R.id.difficulty_spinner);
        questionsAmountTxt = view.findViewById(R.id.text_amount);
        questionsSeekbar = view.findViewById(R.id.questions_slider);
        startBtn = view.findViewById(R.id.start_btn);
        countText = view.findViewById(R.id.count_txt);
        plus = view.findViewById(R.id.plus_btn);
        minus = view.findViewById(R.id.minus_btn);
        questionsAmountTxt.setText("0");
        getQuestionsAmount();
        setListeners();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    }
    public void getQuestionsAmount() {
        questionsSeekbar.setOnSeekBarChangeListener(new SimpleOnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                super.onProgressChanged(seekBar, i, b);
                countText.setText(i);
            }
        });
    }
    public void setListeners() {
        questionsSeekbar.setOnSeekBarChangeListener(new SimpleOnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                questionsAmountTxt.setText(String.valueOf(i));
            }
        });
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParamsOfQuiz();
            }
        });


        difficultySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                difficulty = getResources().getStringArray(R.array.spinner_difficulty)[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
    public void getParamsOfQuiz() {
        Intent intent = new Intent(requireContext(), QuizActivity.class);
        intent.putExtra(EXTRA_AMOUNT, questionsSeekbar.getProgress());
        intent.putExtra(EXTRA_DIFFICULTY, difficulty);
        intent.putExtra(EXTRA_CATEGORY, category);
        startActivity(intent);
    }


}