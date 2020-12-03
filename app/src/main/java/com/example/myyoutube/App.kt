package com.example.myyoutube

import android.app.Application
import com.example.myyoutube.di.dbModule
import com.example.myyoutube.di.networkModule
import com.example.myyoutube.di.repositoryModule
import com.example.myyoutube.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            //inject()
            modules(listOf(networkModule, dbModule, repositoryModule, viewModelModule))
        }
    }

//    fun inject()=loadKotlinModules
//    private val loadKotlinModules by lazy {
//        loadKoinModules(listOf(repositoryModule,fragmentmodule,viewmoduleModule,networkModule))
//    }

}