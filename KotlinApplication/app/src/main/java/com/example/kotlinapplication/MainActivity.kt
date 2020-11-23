package com.example.kotlinapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toastMe(view: View){
        val myToast= Toast.makeText(this,"Hello hello!",Toast.LENGTH_SHORT)
        myToast.show()
    }

    fun countMe(view:View){
        val myCount=text_tv.text.toString()
        var count :Int =Integer.parseInt(myCount)
        count++
        text_tv.text=count.toString()
    }

    fun randomMe(view:View){
        val randomIntent= Intent(this,SecondActivity::class.java)
        val countString=text_tv.text.toString()
        val count=Integer.parseInt(countString)
        randomIntent.putExtra(SecondActivity.TOTAL_COUNT,count)
        startActivity(randomIntent)
    }

    private fun toastMeState(message:String){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    override fun onStart() {// активити стартует и гтовится для показа пользователю, процесс быстрый и быстро проходит к onResume
        super.onStart()
        toastMeState("ON START")
    }

    override fun onResume() {//активити видно пользователю, можно стартовать анимацию,получать доступ к камере,отображать превью и тд
        super.onResume()    // Не гарантирует 100% показ пользователю
        toastMeState("ON RESUME")
    }

    override fun onPostResume() {// не переопределяется а используется системой для запуска кода
        super.onPostResume()
        toastMeState("ON Post RESUME")
    }

    override fun onPause() { //уходит из переднего плана, но при этом может оставаться видимым, не использовать для сохр данных т.к скоротечен
        super.onPause()
        toastMeState("ON PAUSE")
    }

    override fun onStop() {//не виедн пользователю и возвращается в состояние onCreated, можно осовобожать ресурсы и (ресурсоемкие процессы)сохранять данные в бд
        super.onStop()
        toastMeState("ON STOP")
    }

    override fun onRestart() {//ативити собирается вернуться на передний план, после него OnStart и onResume
        super.onRestart()
        toastMeState("ON RESTART")
    }

    override fun onDestroy() {//активити уничтожается
        super.onDestroy()
        toastMeState("ON DESTROY")
    }


}

