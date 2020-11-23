package com.example.kotlinapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*
import java.util.*

class SecondActivity : AppCompatActivity() {
    companion object{
        const val TOTAL_COUNT="total_count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        showRandomNumber()
    }
    fun showRandomNumber(){
        val count=intent.getIntExtra(TOTAL_COUNT,0)
        val random=Random()
        var randomInt=0
        if(count>0){
            randomInt=random.nextInt(count+1)
        }
        random_txt.text=randomInt.toString()
        textViewLabel.text=getString(R.string.text_header,count)

    }

}