package com.thefu.androidstudyproject.workmanagerTest

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.work.BackoffPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.thefu.androidstudyproject.R
import java.util.concurrent.TimeUnit

class WorkManagerActivity : AppCompatActivity() {

    lateinit var doWorkBtn: Button;

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)
        doWorkBtn = findViewById(R.id.doWorkBtn)
        doWorkBtn.setOnClickListener {
            val request = OneTimeWorkRequest.Builder(SimpleWorker::class.java).setInitialDelay(5, TimeUnit.MINUTES).addTag("simple").
            setBackoffCriteria(BackoffPolicy.LINEAR, 10, TimeUnit.SECONDS).build()
            WorkManager.getInstance(this).enqueue(request)
            WorkManager.getInstance(this).cancelAllWorkByTag("simple")
            WorkManager.getInstance(this).getWorkInfoByIdLiveData(request.id).observe(this) {
                workinfo ->
                if (workinfo.state == WorkInfo.State.SUCCEEDED) {
                    Log.d("Activity", "do work success")
                } else if (workinfo.state == WorkInfo.State.FAILED) {
                    Log.d("Activity", "do work failed")
                }
            }
        }
    }
}