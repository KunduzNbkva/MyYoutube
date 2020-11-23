package com.example.myquizapp.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myquizapp.data.models.CategoriesResponse;
import com.example.myquizapp.data.models.QuizModel;

import java.util.List;

public class MainViewModel extends ViewModel {
    public MutableLiveData<Integer> result = new MutableLiveData<>();
    public MutableLiveData<List<QuizModel>> questions = new MutableLiveData<>();
    public MutableLiveData<CategoriesResponse> listCategories = new MutableLiveData<>();
}