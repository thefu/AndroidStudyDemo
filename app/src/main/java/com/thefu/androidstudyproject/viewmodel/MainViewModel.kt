package com.thefu.androidstudyproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel(countReserved: Int) : ViewModel() {

    //这里使用一个不可变的变量用于外部获取实例，但是却没有提供更改的方案，这样更加安全。
    val counter: LiveData<Int>
        get() = _counter
    private val _counter = MutableLiveData<Int>()

    val userLiveData = MutableLiveData<User>()
    //当userLiveData的数据发生变化时候，map()方法会监听到变化并执行转换函数中的逻辑，然后再将转换之后的数据通知给username的观察者
    val userName: LiveData<String> = Transformations.map(userLiveData) { user -> "${user.firstName} ${user.lastName}" }

    //switchMap()方法的使用场景非常固定，如果ViewModel中的某个LiveData对象是调用另外的方法获取的，那么我们就可以借助switchMap方法，将这个LiveData对象转换成另外一个可观察的LiveData对象
    private val userIdLiveData = MutableLiveData<String>()
    val user: LiveData<User> = Transformations.switchMap(userIdLiveData) { userId -> Repository.getUser(userId)}

    init {
        _counter.value = countReserved
    }

    fun plusOne() {
        val count = counter.value ?: 0
        _counter.value = count + 1
    }

    fun clear() {
        _counter.value = 0
    }
    
    fun getUser(userId: String) {
        userIdLiveData.value = userId
    }

    /**
     * 梳理一下工作流程：
     * 1.首先当外部调用MainViewModel的getUser方法来获取用户数据时，并不会发起任何请求或者函数调用，只会将传入的userId值设置到userIdLiveData中
     * 2.一旦userIdLiveData的数据发生变化，那么观察userIdLiveData的switchMap方法就会执行，并且调用我们编写的转换函数，然后在转换函数中调用Repository.getUser()方法获取真正的用户数据，
     * 3.同时，switchMap方法会将Repository.getUser()方法返回的LiveData对象转换成一个可观察的LiveData对象，对于Activity而言，只要去观察这个LiveData对象就可以了
     */

    /**
     * 注意：LiveData内部不会判断即将设置的数据和原有数据是否相同，只要调用了setValue()或postValue()方法，就一定会触发数据变化事件
     */
}