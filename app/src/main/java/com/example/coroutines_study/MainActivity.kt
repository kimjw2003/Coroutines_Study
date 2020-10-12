package com.example.coroutines_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        test()
    }

    private fun test(){

        GlobalScope.launch {
            delay(1000L)
            println("World!")
        } //GlobalScope - CoroutineScope의 한 종류 , launch - 스코프가 있어야 동작가능

        println("Hello,")
        Thread.sleep(2000L)


    }
}