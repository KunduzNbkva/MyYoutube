package com.example.myyoutube.data.local

import android.content.Context
import android.content.SharedPreferences

class SharedPref(context: Context) {

    private var prefs: SharedPreferences? = null
    val lanquage: String?
        get() = prefs?.getString("lang", " ")

    companion object {
        @Volatile
        var instance: SharedPref? = null
        fun getPrefInstance(context: Context): SharedPref? {
            if (instance == null) SharedPref(
                context
            )
            return instance
        }
    }

    init {
        instance = this
        prefs = context.getSharedPreferences("lang", Context.MODE_PRIVATE) }

    fun saveLang(s: String) {
        prefs?.edit()?.putString("lang", s)?.apply()
    }

}


