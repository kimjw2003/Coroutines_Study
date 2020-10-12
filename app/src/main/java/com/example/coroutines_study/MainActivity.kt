package com.example.coroutines_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        test()
    }

    private fun test() = runBlocking {
        val job = GlobalScope.launch {
            delay(3000L)
            Log.d("Logd", "World!")
        } //GlobalScope - CoroutineScope의 한 종류 , launch - 스코프가 있어야 동작가능

        Log.d("Logd","Hello,")
            job.join()

        } //runBlocking - 자신이 호출한 스레드를 블로킹
    }