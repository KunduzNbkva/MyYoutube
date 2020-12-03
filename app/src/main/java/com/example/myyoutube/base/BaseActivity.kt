package com.example.myyoutube.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myyoutube.showToastShort
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlin.reflect.KClass

abstract class BaseActivity<out ViewModel : BaseViewModel>(private var layoutId: Int, viewModelClass: KClass<ViewModel>)
    : AppCompatActivity() {
    private val viewModel: ViewModel by lazy { getViewModel<ViewModel>(viewModelClass) }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        initLanguage()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        setupViews()
        setupLiveData()
        setupFetchRequests()
        showError()
    }

    private fun initLanguage() {}

    abstract fun setupLiveData()
    abstract fun setupViews()
    abstract fun setupFetchRequests()

    private fun showError() {
        viewModel.errorMessage.observeForever {
          showToastShort(it)
        }
    }
}
