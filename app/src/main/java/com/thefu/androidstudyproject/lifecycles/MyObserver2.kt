package com.thefu.androidstudyproject.lifecycles

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

//LifecycleObserver是一个空方法接口，只需要进行一下接口实现声明就可以了，不需要去重写任何方法
//有了Lifecycle对象之后，就可以在任何地方调用lifecycle.currentState来主动获取当前的声明周期状态，一共有五种状态类型
//INITIALIZED、DESTROYED、CREATED、STARTED、RESUMED
class MyObserver2(val lifecycle: Lifecycle) : LifecycleObserver {

    private var TAG = "MyObserver2"

    /**
     * 如果想要感知Activity的生命周期，还得借助额外的注解功能才行
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun activityStart() {
        Log.d(TAG, "activityStart")
    }

    /**
     * 声明周期事件类型一共有7种，ON_CREATE,ON_START,ON_RESUME,ON_STOP和ON_DESTROY分别匹配Activity中的声明周期回调，另外还有一种ON_ANY类型，表示可以匹配Activity的任何声明周期回调
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun activityStop() {
        Log.d(TAG, "activityStop")
    }
}