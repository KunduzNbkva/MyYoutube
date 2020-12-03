package com.example.myyoutube.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


open class BaseViewModel: ViewModel() {
    var errorMessage = MutableLiveData<String>()
}