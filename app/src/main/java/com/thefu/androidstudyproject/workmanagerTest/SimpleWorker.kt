package com.thefu.androidstudyproject.workmanagerTest

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.time.LocalDate

class SimpleWorker(context: Context, params: WorkerParameters) : Worker(context, params){
    override fun doWork(): Result {
        Log.d("SimpleWorker", "do work in SimpleWorker")
        return Result.success();
    }
}

/**
 * 后台任务的写法非常固定，也很好理解，首先每一个后台任务都必须继承自worker类，并调用它唯一的构造函数，然后重写父类中的doWork方法，在这个方法编写具体的后台任务逻辑即可
 *
 * doWork()方法不会运行在主线程当中，因此你可以放心地在这里执行耗时逻辑，不过这里简单起见只是打印了一行日志。
 * 另外，doWork()方法要求返回一个Result对象，用于表示任务的运行结果，成功就返回Result.success()，失败就返回Result.failure()。
 * 除此之外，还有一个Result.retry()方法，它其实也代表着失败，只是可以结合WorkRequest.Builder的setBackoffCriteria()方法来重新执行任务
 *
 */