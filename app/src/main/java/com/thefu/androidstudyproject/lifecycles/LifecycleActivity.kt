package com.thefu.androidstudyproject.lifecycles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thefu.androidstudyproject.R

class LifecycleActivity : AppCompatActivity() {
    //这里我们让MyObserver能够感知到Activity的声明周期，需要专门在activity中重写相应的声明周期方法，然后再通知给MyObserver
//    lateinit var observer: MyObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
//        observer = MyObserver()

        lifecycle.addObserver(MyObserver2())
    }

    override fun onStart() {
        super.onStart()
//        observer.activityStart()
    }

    override fun onStop() {
        super.onStop()
//        observer.activityStop()
    }
}