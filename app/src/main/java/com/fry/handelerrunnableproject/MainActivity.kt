package com.fry.handelerrunnableproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var number = 0
    var runnable : Runnable = Runnable{ }
    var handeler : Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun start(view:View){

      //  number = 0

        runnable = object : Runnable{

            override fun run() {
               number = number + 1
                textView.text = "Sayaç: ${number}"
                handeler.postDelayed(runnable,1000)
            }

        }
        handeler.post(runnable)

    }

    fun stop(view:View){
        handeler.removeCallbacks(runnable)
        number = 0
        textView.text = "Sayaç: 0"
    }
}