package com.example.kotlinapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_save_instance.*

class SaveInstanceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_instance)
        button_save.setOnClickListener {
            text_saved.text=edit_save.text
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putString("KEY",text_saved.text.toString())
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        text_saved.text= savedInstanceState.getString("KEY")
    }
}