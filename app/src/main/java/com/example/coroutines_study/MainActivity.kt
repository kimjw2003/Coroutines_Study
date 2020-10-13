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
        //코루틴을 사용하면 쓰레드를 사용하는것보다 메모리 누수가 적고 속도가 빠르고 코드가 간결화됨

        //test()
        structuredConcurrency()
    }

    private fun test() = runBlocking {
        val job = GlobalScope.launch {
            delay(3000L)
            Log.d("Logd", "World!")
        } //GlobalScope , launch - 스코프가 있어야 동작가능

        Log.d("Logd","Hello,")
            job.join()

        } //runBlocking - 자신이 호출한 스레드를 블로킹


    private fun structuredConcurrency() = runBlocking {// join을 여러번 사용하지 않아도 로그를 여러번 찍을 수 있음
            launch {
                suspend()
            }
            Log.d("Logd","Hello,")
        } //코드의 간결화 가능

    private suspend fun suspend(){ //suspend를 사용하면 따로 함수로 뺄수 있음
        delay(1000L)
        Log.d("Logd", "World!")
        }



    }